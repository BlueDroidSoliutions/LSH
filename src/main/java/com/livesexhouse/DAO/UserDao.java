/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.DAO;

import com.livesexhouse.model.Contact;
import com.livesexhouse.model.Users;
import com.livesexhouse.model.VideoFileName;
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

    
 public void saveContact(Users c) {
        Session session = sessionFactory.getCurrentSession();
        session.save(c);
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
