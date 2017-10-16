package com.livesexhouse.DAO;

import com.livesexhouse.model.Participant;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ParticipantDao {

    @Autowired
    SessionFactory sessionFactory;

     public void saveParticipant(Participant y) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(y);
        } catch (HibernateException e) {

        }

    }

}