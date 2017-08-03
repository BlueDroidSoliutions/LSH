package com.livesexhouse.model;

import com.livesexhouse.model.OrderPayment;
import com.livesexhouse.model.OrderStatus;
import com.livesexhouse.model.PricePackage;
import com.livesexhouse.model.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-03T15:52:51")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, Date> createdDate;
    public static volatile SingularAttribute<Order, PricePackage> pricePackage;
    public static volatile SingularAttribute<Order, String> ipAddress;
    public static volatile SingularAttribute<Order, OrderPayment> payment;
    public static volatile SingularAttribute<Order, Long> id;
    public static volatile SingularAttribute<Order, Users> user;
    public static volatile SingularAttribute<Order, OrderStatus> status;

}