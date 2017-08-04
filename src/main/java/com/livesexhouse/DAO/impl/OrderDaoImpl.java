package com.livesexhouse.DAO.impl;

import com.livesexhouse.DAO.OrderDao;
import com.livesexhouse.model.Order;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nstankovic
 */
@Repository("orderDao")
public class OrderDaoImpl extends AbstractGenericDao<Order> implements OrderDao {

    protected OrderDaoImpl() {
        super(Order.class);
    }

}
