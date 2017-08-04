package com.livesexhouse.service;

import com.livesexhouse.model.Order;
import com.livesexhouse.model.PricePackage;
import com.livesexhouse.model.Users;

/**
 *
 * @author nstankovic
 */
public interface OrderService extends GenericService<Order> {

    Order create(Users user, PricePackage pricePackage);

}
