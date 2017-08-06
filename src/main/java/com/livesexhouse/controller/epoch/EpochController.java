package com.livesexhouse.controller.epoch;

import com.livesexhouse.DAO.UserDao;
import com.livesexhouse.model.Order;
import com.livesexhouse.model.OrderPayment;
import com.livesexhouse.model.Users;
import com.livesexhouse.service.OrderPaymentService;
import com.livesexhouse.service.OrderService;
import com.livesexhouse.util.CryptoUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;

@RestController
@RequestMapping("epoch")
public class EpochController {

	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(EpochController.class);

	/**
	 * Value {@value #POSTBACK_SUCCESSFUL_TRANSACTION} will be received from
	 * Epoch for successuful transaction.
	 */
	private static final String POSTBACK_SUCCESSFUL_TRANSACTION = "Y";

	/**
	 * Value {@value #DATA_PLUS_CHARRGEBACK_TRANSACTION} will be received from
	 * Epoch for chargeback transaction.
	 */
	private static final String DATA_PLUS_CHARRGEBACK_TRANSACTION = "D";

	/**
	 * Value {@value #DATA_PLUS_INITIAL_RECURRING_TRANSACTION} will be received
	 * from Epoch for Standard Initial Recurring Transaction.
	 */
	private static final String DATA_PLUS_INITIAL_RECURRING_TRANSACTION = "I";

	/**
	 * Value {@value #DATA_PLUS_NON_INITIAL_RECURRING_TRANSACTION} will be
	 * received from Epoch for Standard NonInitial Recurring Transaction.
	 */
	private static final String DATA_PLUS_NON_INITIAL_RECURRING_TRANSACTION = "N";

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderPaymentService orderPaymentService;

	@Autowired
	private UserDao userDao;

	@Value("${billing.epoch.pi.code}")
	private String epochPiCode;

	/**
	 * POST /epoch/postback -> calling after user buy tokens, only Epoch is
	 * executing this method
	 * 
	 * @param ans
	 * @param memberId
	 * @param transactionId
	 * @param piCode
	 * @param orderId
	 */
	@RequestMapping(value = "/postback", method = RequestMethod.POST)
	public void postback(@RequestParam("ans") String ans, @RequestParam("order_id") String memberId,
			@RequestParam("transaction_id") String transactionId, @RequestParam("pi_code") String piCode,
			@RequestParam("x_order_id") String orderId) {
        LOGGER.info("REST postback request from Epoch memberId: {} transactionId: {} orderId: {}", memberId,
				transactionId, orderId);
        try {
            byte[] decodedOrderId = Base64.decodeBase64(orderId);
            String decryptedOrderId = CryptoUtil.decrypt(decodedOrderId);
            Long originalOrderId = Long.valueOf(decryptedOrderId);
            validatePostBackParameters(transactionId, piCode, originalOrderId);

            Order order = getOrderService().findById(originalOrderId);
            Users user = order.getUser();
            if (user.getEpochMemberId() == null && memberId != null) {
                user.setEpochMemberId(memberId);
            }
            user.setTokens(user.getTokens() + order.getPricePackage().getTokens());
            getUserDao().save(user);
            getOrderPaymentService().create(order, transactionId);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
	}

	private void validatePostBackParameters(String ans, String piCode, Long orderId) throws InvalidParameterException {
		if (!POSTBACK_SUCCESSFUL_TRANSACTION.equals(ans)) {
			throw new InvalidParameterException(String.format("Transaction failed answer code: %s ", ans));
		}
		if (!StringUtils.equals(piCode, getEpochPiCode())) {
			throw new InvalidParameterException(
					String.format("Postback processing failed pi code: %s did not match!", piCode));
		}
		if (orderId == null) {
			throw new InvalidParameterException("Postback processing failed Order id is not provided!");
		}
		Order order = getOrderService().findById(orderId);
		if (order == null) {
			throw new InvalidParameterException(
					String.format("Postback processing failed Order id: %d is not correct!", orderId));
		}
	}

	/**
	 * POST /epoch/dataplus -> processing transactions from Epoch (chargebacks,
	 * recurrings...), only Epoch is executing this method
	 *
	 * @param transactionId
	 * @param originalTransactionId
	 * @param transactionType
	 * @param memberId
	 * @param username
	 * @param email
	 * @param transactionDate
	 */
	@RequestMapping(value = "/dataplus", method = RequestMethod.POST)
	public void dataplus(@RequestParam("ets_transaction_id") String transactionId,
			@RequestParam("ets_ref_trans_ids") String originalTransactionId,
			@RequestParam("ets_transaction_type") String transactionType,
			@RequestParam("ets_member_idx") String memberId,
			@RequestParam(value = "ets_username", required = false) String username,
			@RequestParam(value = "ets_email", required = false) String email,
			@RequestParam(value = "ets_transaction_date", required = false) String transactionDate) {
		LOGGER.info(
				"REST request from Epoch transactionId: {} originalTransactionId: {} transactionType: {} memberId: {} username: {} transactionDate: {}",
				transactionId, originalTransactionId, transactionType, memberId, username, transactionDate);
		switch (transactionType) {
		case DATA_PLUS_CHARRGEBACK_TRANSACTION:
			handleChargebackTransaction(originalTransactionId);
			break;
		case DATA_PLUS_INITIAL_RECURRING_TRANSACTION:
		case DATA_PLUS_NON_INITIAL_RECURRING_TRANSACTION:
			handleRecurringTransaction(memberId, transactionId);
			break;
		default:
			LOGGER.error("Epoch dataplus type not supported!");
			break;
		}
	}

	private void handleChargebackTransaction(String originalTransactionId) {
		OrderPayment orderPayment = getOrderPaymentService().findByTransactionId(originalTransactionId);
		if (orderPayment == null) {
			LOGGER.error("Order Payment for transaction id: {} could not be found!", originalTransactionId);
		} else {
			LOGGER.debug("Processing Order Payment with id: {}", orderPayment.getId());
			Order order = orderPayment.getOrder();
			Users user = order.getUser();
			user.setTokens(user.getTokens() - order.getPricePackage().getTokens());
			getUserDao().save(user);
		}
	}

	private void handleRecurringTransaction(String memberId, String transactionId) {
		// TODO Auto-generated method stub
	}

	private OrderService getOrderService() {
		return orderService;
	}

	private OrderPaymentService getOrderPaymentService() {
		return orderPaymentService;
	}

    private UserDao getUserDao() {
        return userDao;
    }

    private String getEpochPiCode() {
		return epochPiCode;
	}

}
