package com.livesexhouse.DAO.impl;

import com.livesexhouse.DAO.OrderPaymentDao;
import com.livesexhouse.model.OrderPayment;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nstankovic
 */
@Repository("orderPaymentDao")
public class OrderPaymentDaoImpl extends AbstractGenericDao<OrderPayment> implements OrderPaymentDao {

    protected OrderPaymentDaoImpl() {
        super(OrderPayment.class);
    }

}
