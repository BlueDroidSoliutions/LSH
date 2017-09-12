package com.livesexhouse.service.impl;

import com.livesexhouse.DAO.GenericDao;
import com.livesexhouse.DAO.OrderDao;
import com.livesexhouse.model.Order;
import com.livesexhouse.model.OrderStatus;
import com.livesexhouse.model.PricePackage;
import com.livesexhouse.model.Users;
import com.livesexhouse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< .merge_file_Mo4YWE
=======
import org.springframework.transaction.annotation.Transactional;
>>>>>>> .merge_file_7ePTeV

/**
 *
 * @author nstankovic
 */
@Service("orderService")
public class OrderServiceImpl extends AbstractGenericService<Order> implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
<<<<<<< .merge_file_Mo4YWE
=======
    @Transactional
>>>>>>> .merge_file_7ePTeV
    public Order create(Users user, PricePackage pricePackage) {
        Order order = new Order();
        order.setUser(user);
        order.setPricePackage(pricePackage);
        order.setStatus(OrderStatus.INITIALIZED);
        getEntityDao().save(order);
        return order;
    }

    @Override
    protected GenericDao<Order> getEntityDao() {
        return getOrderDao();
    }

    private OrderDao getOrderDao() {
        return orderDao;
    }
}
