/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.DAO;

import com.google.common.collect.Sets;
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
public class OnlineDao {

    @Autowired
    SessionFactory sessionFactory;

    public String onlineNow() {
        String num = "";
        try {

            Session session = sessionFactory.getCurrentSession();
            Query q = sessionFactory.getCurrentSession().createNativeQuery("SELECT COUNT(*) FROM online where status = 2 or status = 4 or status = 3;");
            num = q.getSingleResult().toString();

        } catch (HibernateException e) {
        }
        return num;

    }

    public int onlineStatus(String id) {
        int num = 0;

        try {
            int idd=0;
            idd = Integer.valueOf(id);
            Session session = sessionFactory.getCurrentSession();
            Query q = session.createNativeQuery("SELECT status FROM online WHERE id = '" + idd + "';");
            if (!q.getResultList().isEmpty()) {
                num = (Integer) q.getSingleResult();
            }
        } catch (HibernateException e) {
        }
        return num;
    }
    
    public Set<Integer> onlineGirls() {
        List<Integer> users = new ArrayList<>();
            Set<Integer> active = Sets.newTreeSet();

        try {
            
           
            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("Online.findByStatus");
            
            q.setParameter("status", 2);
            
            users = q.getResultList();
            for (int s : users) {
                active.add(s);
            }
           
            
        } catch (HibernateException e) {
        }
        return active;
    }

    public void setPrivate(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createNativeQuery("update online set status=" + 4 + " where id = " + id + ";");
            query.executeUpdate();
        } catch (HibernateException e) {

        }

    }

    public void setGroup(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createNativeQuery("update online set status=" + 3 + " where id = " + id + ";");
            query.executeUpdate();
        } catch (HibernateException e) {

        }

    }

    public void setOnline(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createNativeQuery("update online set status=" + 2 + " where id = " + id + ";");
            query.executeUpdate();
        } catch (HibernateException e) {

        }

    }

    public void setOffline(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createNativeQuery("update online set status=" + 0 + " where id = " + id + ";");
            query.executeUpdate();
        } catch (HibernateException e) {

        }

    }

}
