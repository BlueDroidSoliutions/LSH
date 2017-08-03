package com.livesexhouse.service.impl;

import com.livesexhouse.DAO.GenericDao;
import com.livesexhouse.DAO.OrderPaymentDao;
import com.livesexhouse.model.OrderPayment;
import com.livesexhouse.service.OrderPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nstankovic
 */
@Service("orderPaymentService")
public class OrderPaymentServiceImpl extends AbstractGenericService<OrderPayment> implements OrderPaymentService {

    @Autowired
    private OrderPaymentDao orderPaymentDao;

    @Override
    protected GenericDao<OrderPayment> getEntityDao() {
        return getOrderPaymentDao();
    }

    private OrderPaymentDao getOrderPaymentDao() {
        return orderPaymentDao;
    }
}
