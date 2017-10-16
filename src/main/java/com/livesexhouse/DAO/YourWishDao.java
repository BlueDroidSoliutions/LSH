package com.livesexhouse.DAO;

import com.livesexhouse.model.Contact;
import com.livesexhouse.model.YourWish;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class YourWishDao {

    @Autowired
    SessionFactory sessionFactory;

     public void saveWish(YourWish y) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(y);
        } catch (HibernateException e) {

        }

    }

}