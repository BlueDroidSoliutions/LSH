package com.livesexhouse.DAO;

import com.livesexhouse.model.Contact;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UsersBlacklistDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void saveContact(Contact c) {

        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(c);
        } catch (HibernateException e) {

        }

    }

}
