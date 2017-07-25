/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.DAO;

import com.livesexhouse.model.Users;
import javax.persistence.Query;
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

    
 public void save(Users c) {
     try{
         System.out.println("t1");
        Session session = sessionFactory.getCurrentSession();
         System.out.println("t2");
        session.save(c);
     System.out.println("t3");}
     catch(Exception e){System.out.println("trrr");}
    }
   
    
    
 public boolean exist(String key) {
        boolean b = false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.createNativeQuery("SELECT * FROM users WHERE username = '"+key+"';");
            if(q.getResultList().size()!=0)
                b=true;
        } catch (Exception e) {
        }
        return b;
    }
 
 
 
    
}
