/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.DAO;

import com.livesexhouse.model.UserM2m;
import com.livesexhouse.model.UserRoles;
import com.livesexhouse.model.Users;
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
       
       
       
       public Users findById(int id) {

        Users u = new Users();

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("Users.findById");
            query.setParameter("id", id);
            u = (Users) query.getSingleResult();
        } catch (HibernateException e) {
        }
        return u;
    }
       
       
       
    
 public Integer save(Users c) {
     Integer i = 0;
     try{
        Session session = sessionFactory.getCurrentSession();
        i = (Integer)session.save(c);
     }
     catch(Exception e){}
     return i;
    }
 
 public void saveRola(UserRoles u) {
     try{
        Session session = sessionFactory.getCurrentSession();
        session.save(u);
     }
     catch(Exception e){}
    }
   
    
    
 public boolean existUserName(String username) {
        boolean b = false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.createNativeQuery("SELECT * FROM users WHERE username = '"+username+"';");
            if(q.getResultList().size()!=0)
                b=true;
        } catch (Exception e) {
        }
        return b;
    }
 
 
 
 public boolean existEmail(String email) {
        boolean b = false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.createNativeQuery("SELECT * FROM users WHERE email = '"+email+"';");
            if(q.getResultList().size()!=0)
                b=true;
        } catch (Exception e) {
        }
        return b;
    }
 
 
 
 public void delete(Users c) {
    
     try{
        Session session = sessionFactory.getCurrentSession();
//        session.delete(c);
        
        Query query = session.createNativeQuery("DELETE FROM users WHERE id = "+c.getId()+";");
        query.executeUpdate();
        query = session.createNativeQuery("DELETE FROM user_m2m WHERE user_id = "+c.getId()+";");
        query.executeUpdate();
        query = session.createNativeQuery("DELETE FROM user_roles WHERE username_id = "+c.getId()+";");
        query.executeUpdate();
        query = session.createNativeQuery("DELETE FROM user_bck_data WHERE id = "+c.getId()+";");
        query.executeUpdate();
        
        
        
     }
     catch(Exception e){}
     
    }
 
 
 
 
 
  public void update(Users u) {
        Session session = sessionFactory.getCurrentSession();
        session.update(u);
    }
 
 
 
    
}
