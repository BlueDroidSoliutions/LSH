package com.livesexhouse.model;

import com.livesexhouse.model.Order;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-12T13:15:44")
@StaticMetamodel(OrderPayment.class)
public class OrderPayment_ { 

    public static volatile SingularAttribute<OrderPayment, Date> createdDate;
    public static volatile SingularAttribute<OrderPayment, Long> id;
    public static volatile SingularAttribute<OrderPayment, String> transactionId;
    public static volatile SingularAttribute<OrderPayment, Order> order;

}