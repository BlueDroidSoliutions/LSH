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
