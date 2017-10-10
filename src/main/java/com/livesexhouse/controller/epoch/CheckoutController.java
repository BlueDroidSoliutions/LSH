package com.livesexhouse.controller.epoch;
<<<<<<< HEAD
import com.livesexhouse.DAO.UserDao;
import com.livesexhouse.controller.epoch.response.CheckoutResponse;
import com.livesexhouse.model.Order;
import com.livesexhouse.model.PricePackage;
import com.livesexhouse.model.Users;
import com.livesexhouse.service.OrderService;
import com.livesexhouse.service.PricePackageService;
import com.livesexhouse.util.CryptoUtil;
import com.livesexhouse.util.HashUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.Principal;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "checkout", produces = MediaType.APPLICATION_JSON_VALUE)
public class CheckoutController {

     
	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutController.class);

	/**
	 * Algorithm {@value #EPOCH_DIGEST_HASH_ALGORITHM} will be used for
	 * generating epoch digest value.
	 */
	private static final String EPOCH_DIGEST_HASH_ALGORITHM = "HmacMD5";

	@Autowired
	private UserDao userDao;

	@Autowired
	private PricePackageService pricePackageService;

	@Autowired
	private OrderService orderService;

//	@Value("${billing.epoch.url}")
	private String epochUrl;

//	@Value("${billing.epoch.pi.code}")
	private String epochPiCode;

//	@Value("${billing.epoch.postback.url}")
	private String postbackUrl;

//	@Value("${billing.epoch.secret.key}")
	private String secretKey;

        
        
        
	/**
	 * POST /checkout -> calling when buying tokens
	 *
     * @param principal
	 * @param pricePackageId
	 * @return {@link CheckoutResponse} object
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody CheckoutResponse submit(Principal principal, @RequestParam Long pricePackageId) {
		CheckoutResponse response = new CheckoutResponse();
                
		if (principal == null) {
		    response.setMessage("You must be logged in to buy tokens.");
		    response.setSuccess(Boolean.FALSE);
		    return response;
        }
		Users user = getUserDao().findByUsername(principal.getName());
		if (user == null && user.getEnabled() == 1) {
			response.setSuccess(Boolean.FALSE);
			response.setMessage("You don't have permissions to buy tokens!");
			return response;
		}
		PricePackage pricePackage = getPricePackageService().findById(pricePackageId);
		if (pricePackage == null) {
			response.setSuccess(Boolean.FALSE);
			response.setMessage("You must choose price package.");
			LOGGER.error("User with username: {} is trying to buy tokens without selecting price package.",
					user.getUsername());
			return response;
		}
		Order order = getOrderService().create(user, pricePackage);
		if (StringUtils.isEmpty(user.getEpochMemberId())) {
			buildJoinResponse(response, user, order);
		} else {
			buildCamChargeResponse(response, user, order);
		}
		return response;
	}

	private void buildJoinResponse(CheckoutResponse response, Users user, Order order) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(getEpochUrl());
		Map<String, String> params = new LinkedHashMap<>();
		// Required parameters
		params.put("api", "join");
		params.put("action", "authandclose");
		params.put("pi_code", getEpochPiCode());
		params.put("reseller", "a");
		// Optional parameters
		params.put("auth_amount", order.getPricePackage().getAmount().toString());
		params.put("pburl", getPostbackUrl());
		params.put("no_userpass", "1");
		params.put("username", user.getUsername());
		params.put("email", user.getEmail());
		byte[] encryptedOrderId = null;
		try {
			encryptedOrderId = CryptoUtil.encrypt(order.getId().toString());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		String orderIdBase64Encoded = Base64.getUrlEncoder().encodeToString(encryptedOrderId);
		params.put("x_order_id", orderIdBase64Encoded);
		params.put("epoch_digest", getEpochDigest(params));
		String uriParams = params.entrySet().stream().map(e -> String.format("%s=%s", e.getKey(), e.getValue()))
				.collect(Collectors.joining("&"));
		uriBuilder.query(uriParams);
		response.setSuccess(Boolean.TRUE);
		response.setRedirectUrl(uriBuilder.buildAndExpand(params).encode().toUriString());
	}

	private void buildCamChargeResponse(CheckoutResponse response, Users user, Order order) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(getEpochUrl());
		Map<String, String> params = new LinkedHashMap<>();
		// Required parameters
		params.put("api", "camcharge");
		params.put("action", "authandclose");
		params.put("description", order.getPricePackage().getName());
		params.put("member_id", user.getEpochMemberId());
		// Optional parameters
		params.put("auth_amount", order.getPricePackage().getAmount().toString());
		params.put("pburl", getPostbackUrl());
		byte[] encryptedOrderId = null;
		try {
			encryptedOrderId = CryptoUtil.encrypt(order.getId().toString());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		String orderIdBase64Encoded = Base64.getUrlEncoder().encodeToString(encryptedOrderId);
		params.put("x_order_id", orderIdBase64Encoded);
		params.put("epoch_digest", getEpochDigest(params));
		String uriParams = params.entrySet().stream().map(e -> String.format("%s=%s", e.getKey(), e.getValue()))
				.collect(Collectors.joining("&"));
		uriBuilder.query(uriParams);
		response.setSuccess(Boolean.TRUE);
		response.setRedirectUrl(uriBuilder.buildAndExpand(params).encode().toUriString());
	}

	/**
	 * @param params
	 * @return digest value of input value params
	 */
	private String getEpochDigest(Map<String, String> params) {
		String uriParams = params.entrySet().stream().sorted(Map.Entry.<String, String>comparingByKey())
				.map(e -> e.getKey() + e.getValue()).collect(Collectors.joining());
		return HashUtil.getHmacHexadecimalValue(uriParams, getSecretKey(), EPOCH_DIGEST_HASH_ALGORITHM);
	}

    private PricePackageService getPricePackageService() {
        return pricePackageService;
    }

    private UserDao getUserDao() {
        return userDao;
    }

    private OrderService getOrderService() {
		return orderService;
	}

	private String getEpochUrl() {
		return epochUrl;
	}

	private String getEpochPiCode() {
		return epochPiCode;
=======

import com.livesexhouse.DAO.UserDao;
import com.livesexhouse.controller.epoch.response.CheckoutResponse;
import com.livesexhouse.model.Order;
import com.livesexhouse.model.PricePackage;
import com.livesexhouse.model.Users;
import com.livesexhouse.service.OrderService;
import com.livesexhouse.service.PricePackageService;
import com.livesexhouse.util.CryptoUtil;
import com.livesexhouse.util.HashUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.Principal;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "checkout", produces = MediaType.APPLICATION_JSON_VALUE)
public class CheckoutController {

	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutController.class);

	/**
	 * Algorithm {@value #EPOCH_DIGEST_HASH_ALGORITHM} will be used for
	 * generating epoch digest value.
	 */
	private static final String EPOCH_DIGEST_HASH_ALGORITHM = "HmacMD5";

	@Autowired
	private UserDao userDao;

	@Autowired
	private PricePackageService pricePackageService;

	@Autowired
	private OrderService orderService;

	@Value("${billing.epoch.url}")
	private String epochUrl;

	@Value("${billing.epoch.postback.url}")
	private String postbackUrl;

	@Value("${billing.epoch.secret.key}")
	private String secretKey;

	/**
	 * POST /checkout -> calling when buying tokens
	 *
     * @param principal
	 * @param pricePackageId
	 * @return {@link CheckoutResponse} object
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody CheckoutResponse submit(Principal principal, @RequestParam Long pricePackageId) {
		CheckoutResponse response = new CheckoutResponse();
		if (principal == null) {
		    response.setMessage("You must be logged in to buy tokens.");
		    response.setSuccess(Boolean.FALSE);
		    return response;
        }
		Users user = getUserDao().findByUsername(principal.getName());
		if (user == null || user.getEnabled() == 1) {
			response.setSuccess(Boolean.FALSE);
			response.setMessage("You don't have permissions to buy tokens!");
			return response;
		}
		PricePackage pricePackage = getPricePackageService().findById(pricePackageId);
		if (pricePackage == null) {
			response.setSuccess(Boolean.FALSE);
			response.setMessage("You must choose price package.");
			LOGGER.error("User with username: {} is trying to buy tokens without selecting price package.",
					user.getUsername());
			return response;
		}
		Order order = getOrderService().create(user, pricePackage);
		if (StringUtils.isEmpty(user.getEpochCamChargeMemberId())) {
			buildJoinResponse(response, user, order);
		} else {
			buildCamChargeResponse(response, user, order);
		}
		return response;
	}
	
	/**
	 * POST /checkout/vip -> calling when buying vip membership
	 *
     * @param principal
	 * @param pricePackageId
	 * @return {@link CheckoutResponse} object
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody CheckoutResponse submitVipMembership(Principal principal, @RequestParam Long pricePackageId) {
		CheckoutResponse response = new CheckoutResponse();
		if (principal == null) {
		    response.setMessage("You must be logged in to buy vip membership.");
		    response.setSuccess(Boolean.FALSE);
		    return response;
        }
		Users user = getUserDao().findByUsername(principal.getName());
		if (user == null || user.getEnabled() == 1) {
			response.setSuccess(Boolean.FALSE);
			response.setMessage("You don't have permissions to buy vip membership!");
			return response;
		}
		PricePackage pricePackage = getPricePackageService().findById(pricePackageId);
		if (pricePackage == null || !pricePackage.getMonthly()) {
			response.setSuccess(Boolean.FALSE);
			response.setMessage("Error has occurred during buying vip membership.");
			LOGGER.error("User with username: {} is trying to buy vip membership without selecting price package.",
					user.getUsername());
			return response;
		}
		Order order = getOrderService().create(user, pricePackage);
		buildJoinResponse(response, user, order);
		return response;
	}

	private void buildJoinResponse(CheckoutResponse response, Users user, Order order) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(getEpochUrl());
		Map<String, String> params = new LinkedHashMap<>();
		// Required parameters
		params.put("api", "join");
		params.put("pi_code", order.getPricePackage().getExternalPackageId());
		params.put("reseller", "a");
		// Optional parameters
		params.put("auth_amount", order.getPricePackage().getAmount().toString());
		params.put("pburl", getPostbackUrl());
		params.put("no_userpass", "1");
		params.put("username", user.getUsername());
		params.put("email", user.getEmail());
		byte[] encryptedOrderId = null;
		try {
			encryptedOrderId = CryptoUtil.encrypt(order.getId().toString());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		String orderIdBase64Encoded = Base64.getUrlEncoder().encodeToString(encryptedOrderId);
		params.put("x_order_id", orderIdBase64Encoded);
		params.put("epoch_digest", getEpochDigest(params));
		String uriParams = params.entrySet().stream().map(e -> String.format("%s=%s", e.getKey(), e.getValue()))
				.collect(Collectors.joining("&"));
		uriBuilder.query(uriParams);
		response.setSuccess(Boolean.TRUE);
		response.setRedirectUrl(uriBuilder.buildAndExpand(params).encode().toUriString());
	}

	private void buildCamChargeResponse(CheckoutResponse response, Users user, Order order) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(getEpochUrl());
		Map<String, String> params = new LinkedHashMap<>();
		// Required parameters
		params.put("api", "camcharge");
		params.put("action", "authandclose");
		params.put("description", order.getPricePackage().getName());
		params.put("member_id", user.getEpochCamChargeMemberId());
		// Optional parameters
		params.put("auth_amount", order.getPricePackage().getAmount().toString());
		params.put("pburl", getPostbackUrl());
		byte[] encryptedOrderId = null;
		try {
			encryptedOrderId = CryptoUtil.encrypt(order.getId().toString());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		String orderIdBase64Encoded = Base64.getUrlEncoder().encodeToString(encryptedOrderId);
		params.put("x_order_id", orderIdBase64Encoded);
		params.put("epoch_digest", getEpochDigest(params));
		String uriParams = params.entrySet().stream().map(e -> String.format("%s=%s", e.getKey(), e.getValue()))
				.collect(Collectors.joining("&"));
		uriBuilder.query(uriParams);
		response.setSuccess(Boolean.TRUE);
		response.setRedirectUrl(uriBuilder.buildAndExpand(params).encode().toUriString());
	}

	/**
	 * @param params
	 * @return digest value of input value params
	 */
	private String getEpochDigest(Map<String, String> params) {
		String uriParams = params.entrySet().stream().sorted(Map.Entry.<String, String>comparingByKey())
				.map(e -> e.getKey() + e.getValue()).collect(Collectors.joining());
		return HashUtil.getHmacHexadecimalValue(uriParams, getSecretKey(), EPOCH_DIGEST_HASH_ALGORITHM);
	}

    private PricePackageService getPricePackageService() {
        return pricePackageService;
    }

    private UserDao getUserDao() {
        return userDao;
    }

    private OrderService getOrderService() {
		return orderService;
	}

	private String getEpochUrl() {
		return epochUrl;
>>>>>>> branch 'master' of https://roller01285@bitbucket.org/roller01285/www.livesexhouse.com.git
	}

	private String getPostbackUrl() {
		return postbackUrl;
	}

	private String getSecretKey() {
		return secretKey;
	}
}
