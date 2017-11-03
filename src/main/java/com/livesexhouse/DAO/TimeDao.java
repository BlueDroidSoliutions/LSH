/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.DAO;

import com.google.common.collect.Sets;
import com.livesexhouse.model.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roller
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class TimeDao {

    @Autowired
    SessionFactory sessionFactory;

    public void save(Time t) {
        try {
            Time tt = new Time();
            tt=t;

            Session session = sessionFactory.getCurrentSession();
            //pr 1
            if (t.getStatus() == 1) {
                Query q = session.getNamedQuery("Time.findByUserIdPr");
                q.setParameter("userId", t.getUserId());
                q.setParameter("girlId", t.getGirlId());

                List<Time> tList = new ArrayList<>();

                tList = q.getResultList();
                if (!tList.isEmpty()) {

                    
                    q = session.createNativeQuery("DELETE FROM time where userId =" + t.getUserId() + " AND status = " + t.getStatus() + ";");
                    
                    System.out.println("DELETE FROM time where userId =" + t.getUserId() + " AND status = " + t.getStatus() + ";");
                    
                    q.executeUpdate();

                } 
                    session.save(tt);
                
            } else {
                Query q = session.getNamedQuery("Time.findByUserIdGr");
                q.setParameter("userId", t.getUserId());
                q.setParameter("girlId", t.getGirlId());

                List<Time> tList = new ArrayList<>();

                tList = q.getResultList();
                if (!tList.isEmpty()) {

                    q = session.createNativeQuery("DELETE FROM time where userId =" + t.getUserId() + " AND status = " + t.getStatus() + ";");
                    System.out.println("DELETE FROM time where userId =" + t.getUserId() + " AND status = " + t.getStatus() + ";");
                    q.executeUpdate();

                } 
                    session.save(tt);
                
            }

        } catch (HibernateException e) {
        }
    }

    public Time getTimePr(int userId, int girlId) {
        Time t = new Time();
        try {

            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("Time.findByUserIdPr");
            q.setParameter("userId", userId);
            q.setParameter("girlId", girlId);

            List<Time> tList = new ArrayList<>();

            tList = q.getResultList();
            if (!tList.isEmpty()) {
                t = tList.get(0);
            }

        } catch (Exception e) {

        }

        return t;
    }

    public Time getTimeGr(int userId, int girlId) {
        Time t = new Time();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("Time.findByUserIdGr");
            q.setParameter("userId", userId);
            q.setParameter("girlId", girlId);
            List<Time> tList = new ArrayList<>();

            tList = q.getResultList();
            if (!tList.isEmpty()) {
                t = tList.get(0);
            }
        } catch (Exception e) {

        }
        return t;
    }

}
