package com.livesexhouse.service.impl;

import com.livesexhouse.DAO.GenericDao;
import com.livesexhouse.DAO.OrderDao;
import com.livesexhouse.model.Order;
import com.livesexhouse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nstankovic
 */
@Service("orderService")
public class OrderServiceImpl extends AbstractGenericService<Order> implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    protected GenericDao<Order> getEntityDao() {
        return getOrderDao();
    }

    private OrderDao getOrderDao() {
        return orderDao;
    }
}
