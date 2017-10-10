package com.livesexhouse.service.impl;

import com.livesexhouse.DAO.GenericDao;
import com.livesexhouse.DAO.OrderPaymentDao;
import com.livesexhouse.model.Order;
import com.livesexhouse.model.OrderPayment;
import com.livesexhouse.service.OrderPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 *
 * @author nstankovic
 */
@Service("orderPaymentService")
public class OrderPaymentServiceImpl extends AbstractGenericService<OrderPayment> implements OrderPaymentService {

    @Autowired
    private OrderPaymentDao orderPaymentDao;

    @Override
    @Transactional
    public OrderPayment create(Order order, String transactionId) {
        OrderPayment orderPayment = new OrderPayment();
        orderPayment.setOrder(order);
        orderPayment.setTransactionId(transactionId);
        orderPayment.setCreatedDate(new Date());
        getOrderPaymentDao().save(orderPayment);
        return orderPayment;
    }

    @Override
    @Transactional(readOnly = true)
    public OrderPayment findByTransactionId(String transactionId) {
        return getOrderPaymentDao().findByTransactionId(transactionId);
    }

    @Override
    protected GenericDao<OrderPayment> getEntityDao() {
        return getOrderPaymentDao();
    }

    private OrderPaymentDao getOrderPaymentDao() {
        return orderPaymentDao;
    }
}
