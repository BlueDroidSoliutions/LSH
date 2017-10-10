package com.livesexhouse.service;

import com.livesexhouse.model.Order;
import com.livesexhouse.model.OrderPayment;

/**
 *
 * @author nstankovic
 */
public interface OrderPaymentService extends GenericService<OrderPayment> {

    OrderPayment create(Order order, String transactionId);

    OrderPayment findByTransactionId(String transactionId);

}