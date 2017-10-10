package com.livesexhouse.DAO;

import com.livesexhouse.model.OrderPayment;

/**
 *
 * @author nstankovic
 */
public interface OrderPaymentDao extends GenericDao<OrderPayment> {

    OrderPayment findByTransactionId(String transactionId);

}
