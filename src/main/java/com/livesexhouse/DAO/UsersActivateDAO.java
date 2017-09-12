
package com.livesexhouse.DAO;

import com.livesexhouse.model.UsersActivate;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UsersActivateDAO {

    @Autowired
    SessionFactory sessionFactory;

    
  public boolean exist(String key) {
        boolean b = false;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("UsersActivate.findByUserKey");
            q.setParameter(key, "userKey");
            UsersActivate vfn = (UsersActivate) q.getSingleResult();

            if (!vfn.getUserKey().isEmpty()) {
                b = true;
            }
        } catch (Exception e) {
        }
        return b;
    }
  
  public void delete(UsersActivate vc){
        Session session = sessionFactory.getCurrentSession();
        session.delete(vc);
    }
    
        
        
        
     public void save(UsersActivate k){
         try{
        Session session = sessionFactory.getCurrentSession();
        session.save(k);
         } catch (Exception e){
         }
         
    } 
    
    
     
     
     public Object[] findByKey(String key) {
        
    UsersActivate v = new UsersActivate();
       boolean b = false;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("UsersActivate.findByUserKey");
            query.setParameter("userKey",key);
            v = (UsersActivate)query.getSingleResult();

            if (v!=null)
                b=true; 

        } catch (HibernateException e) {
        }
            return new Object[]{b,v};
    }
     
     
     
    
   
 
 
}