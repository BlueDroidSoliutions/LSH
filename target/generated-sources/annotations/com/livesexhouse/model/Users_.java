package com.livesexhouse.model;

import com.livesexhouse.model.Membership;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-03T15:52:51")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Date> memberfrom;
    public static volatile SingularAttribute<Users, Integer> tokens;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, Short> enabled;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile ListAttribute<Users, Membership> memberships;
    public static volatile SingularAttribute<Users, String> username;

}