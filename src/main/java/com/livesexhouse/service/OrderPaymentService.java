package com.livesexhouse.service;

import com.livesexhouse.model.Order;
import com.livesexhouse.model.OrderPayment;

/**
 *
 * @author nstankovic
 */
public interface OrderPaymentService extends GenericService<OrderPayment> {

    OrderPayment create(Order order, String transactionId);

<<<<<<< .merge_file_GmONZW
=======
    OrderPayment findByTransactionId(String transactionId);

>>>>>>> .merge_file_kPHCrA
}
