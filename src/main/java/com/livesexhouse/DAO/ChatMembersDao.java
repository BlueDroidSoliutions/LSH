/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.DAO;

import com.livesexhouse.controller.Checker;
import com.livesexhouse.model.ChatMembers;
import com.livesexhouse.model.Users;
import java.util.ArrayList;
import java.util.List;
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
public class ChatMembersDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserDao userDao;


    public int count(int girlId) {
        int count = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("ChatMembers.count");
            q.setParameter("girlId", girlId);
            
            if (q.getResultList().size() > 0) {
                count = Integer.valueOf(q.getSingleResult().toString());
            }

        } catch (HibernateException e) {

        }
        return count;
    }

    public void setUser(int userId, int girlId) {
        try {
            
            ChatMembers c = new ChatMembers();
            c.setGirlId(girlId);
            c.setUserId(userId);

             Session session = sessionFactory.getCurrentSession();
            session.save(c);
            
            
        } catch (HibernateException e) {

        }
    }

    public void deleteFromUser(int userId) {
        try {
            Session session = sessionFactory.getCurrentSession();
//            Query q = sessionFactory.getCurrentSession().createNativeQuery("delete from chatMembers where user_id=" + userId + ";");
            Query query = session.getNamedQuery("ChatMembers.findByUserId");
            query.setParameter("userId", userId);
            ChatMembers cm = (ChatMembers) query.getSingleResult();
            session.delete(cm);
            
        } catch (HibernateException e) {
        }
    }

    public void deleteFromGirl(int girlId) {
        try {
            Session session = sessionFactory.getCurrentSession();
//            Query q = sessionFactory.getCurrentSession().createNativeQuery("delete from chatMembers where girl_id=" + girlId + ";");
           Query query = session.getNamedQuery("ChatMembers.findByGirlId");
            query.setParameter("girlId", girlId);
            ChatMembers cm = (ChatMembers) query.getSingleResult();
            session.delete(cm);
        } catch (HibernateException e) {
        }
    }

    public List<String> selectAllUsers(int girlId) {
        List<Integer> users = new ArrayList<>();
        List<String> fusers = new ArrayList<>();
        Users u = new Users();
        try {
            Session session = sessionFactory.getCurrentSession();
             Query q = session.getNamedQuery("ChatMembers.selectAllUsers");
            q.setParameter("girlId", girlId);
            users = q.getResultList();

            for (Integer s : users) {

                u = userDao.findById(s);

                if (u.getUsername() != null) {
                    fusers.add(u.getUsername());
                }
            }

        } catch (HibernateException e) {
        }
        return fusers;
    }

}
