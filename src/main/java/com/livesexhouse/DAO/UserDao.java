/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.DAO;

<<<<<<< HEAD
import com.livesexhouse.controller.Checker;
=======
>>>>>>> branch 'master' of https://roller01285@bitbucket.org/roller01285/www.livesexhouse.com.git
import com.livesexhouse.model.UserRoles;
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
public class UserDao {

    @Autowired
    SessionFactory sessionFactory;
    
    @Autowired
    Checker checker;

    public Users findByUsername(String username) {

        Users u = new Users();

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("Users.findByUsername");
            query.setParameter("username", username);
            u = (Users) query.getSingleResult();
        } catch (HibernateException e) {
        }
        return u;
    }

    public List<String> findGirls() {
        List<String> l = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Users.findByEnabled2");
            l = q.getResultList();

        } catch (HibernateException e) {
        }
        return l;

    }

<<<<<<< HEAD
    public Users findById(int id) {

        Users u = new Users();

        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("Users.findById");
            q.setParameter("id", id);
            if (!q.getResultList().isEmpty()) {
                u = (Users) q.getSingleResult();
            }

        } catch (HibernateException e) {
        }
        return u;
=======
 public void saveRola(UserRoles u) {
     try{
        Session session = sessionFactory.getCurrentSession();
        session.save(u);
     }
     catch(Exception e){}
>>>>>>> branch 'master' of https://roller01285@bitbucket.org/roller01285/www.livesexhouse.com.git
    }

    public Integer save(Users c) {
        Integer i = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            i = (Integer) session.save(c);
        } catch (HibernateException e) {
        }
        return i;
    }

    public void saveRola(UserRoles u) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(u);
        } catch (HibernateException e) {
        }
    }

    public boolean existUserName(String username) {
        boolean b = false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            if(checker.check(username)){
            Query q = session.createNativeQuery("SELECT * FROM users WHERE username = '" + username + "';");
            if (!q.getResultList().isEmpty()) {
                b = true;
            }
        }
            
        } catch (HibernateException e) {
        }
        return b;
    }
<<<<<<< HEAD

    public boolean existEmail(String email) {
        boolean b = false;

        try {
            Session session = sessionFactory.getCurrentSession();
            if(checker.checkEmail(email)){
            Query q = session.createNativeQuery("SELECT * FROM users WHERE email = '" + email + "';");
            if (!q.getResultList().isEmpty()) {
                b = true;
            }}
        } catch (HibernateException e) {
        }
        return b;
    }

    public void delete(Users c) {

        try {
            Session session = sessionFactory.getCurrentSession();

            Query query = session.createNativeQuery("DELETE FROM users WHERE id = " + c.getId() + ";");
            query.executeUpdate();
            query = session.createNativeQuery("DELETE FROM user_m2m WHERE user_id = " + c.getId() + ";");
            query.executeUpdate();
            query = session.createNativeQuery("DELETE FROM user_roles WHERE username_id = " + c.getId() + ";");
            query.executeUpdate();
            query = session.createNativeQuery("DELETE FROM user_bck_data WHERE id = " + c.getId() + ";");
            query.executeUpdate();

        } catch (HibernateException e) {
        }

    }

    public void update(Users u) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(u);
        } catch (HibernateException e) {

        }

    }

=======
 
 public Users findByEpochMemberId(String memberId) {
	 Query query = sessionFactory.getCurrentSession()
			 .createQuery("SELECT * FROM users WHERE epoch_member_id = :memberId");
	 query.setParameter("memberId", memberId);
	 return (Users) query.getSingleResult();
 }
 
    
>>>>>>> branch 'master' of https://roller01285@bitbucket.org/roller01285/www.livesexhouse.com.git
}
