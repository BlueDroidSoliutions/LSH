/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.DAO;

import com.livesexhouse.controller.Checker;
import com.livesexhouse.model.BlockedCountry;
import com.livesexhouse.model.BlockedCountryM2m;
import com.livesexhouse.model.BlockedRegion;
import com.livesexhouse.model.BlockedRegionM2m;
import com.livesexhouse.model.Body;
import com.livesexhouse.model.Country;
import com.livesexhouse.model.Decoration;
import com.livesexhouse.model.Girls;
import com.livesexhouse.model.Hair;
import com.livesexhouse.model.Interes;
import com.livesexhouse.model.InteresM2m;
import com.livesexhouse.model.Kinky;
import com.livesexhouse.model.KinkyM2m;
import com.livesexhouse.model.Language;
import com.livesexhouse.model.LanguageSpoken;
import com.livesexhouse.model.Model;
import com.livesexhouse.model.UserRoles;
import com.livesexhouse.model.Users;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roller
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ModelDao {

    @Autowired
    SessionFactory sessionFactory;

    

   

  

    public List<Interes> findInteres() {
        List<Interes> l = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Interes.findAll");
            l = q.getResultList();

        } catch (HibernateException e) {
        }
        return l;

    }

  
 public List<Country> findCountry() {
        List<Country> l = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Country.findAll");
            l = q.getResultList();

        } catch (HibernateException e) {
        }
        return l;

    }
   

    
 
  public List<Language> findLanguage() {
        List<Language> l = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Language.findAll");
            l = q.getResultList();

        } catch (HibernateException e) {
        }
        return l;

    }
   public List<Body> findBody() {
        List<Body> l = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Body.findAll");
            l = q.getResultList();

        } catch (HibernateException e) {
        }
        return l;

    }
    public List<Decoration> findDecoration() {
        List<Decoration> l = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Decoration.findAll");
            l = q.getResultList();

        } catch (HibernateException e) {
        }
        return l;

    }
     public List<LanguageSpoken> findLanguageSpoken() {
        List<LanguageSpoken> l = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = sessionFactory.getCurrentSession().getNamedQuery("LanguageSpoken.findAll");
            l = q.getResultList();

        } catch (HibernateException e) {
        }
        return l;

    }
      public List<Hair> findHair() {
        List<Hair> l = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Hair.findAll");
            l = q.getResultList();

        } catch (HibernateException e) {
        }
        return l;

    }
       public List<Kinky> findKinky() {
        List<Kinky> l = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Kinky.findAll");
            l = q.getResultList();

        } catch (HibernateException e) {
        }
        return l;

    }
        public List<BlockedCountry> findBlockedCountry() {
        List<BlockedCountry> l = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = sessionFactory.getCurrentSession().getNamedQuery("BlockedCountry.findAll");
            l = q.getResultList();

        } catch (HibernateException e) {
        }
        return l;

    }
         public List<BlockedRegion> findBlockedRegion() {
        List<BlockedRegion> l = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = sessionFactory.getCurrentSession().getNamedQuery("BlockedRegion.findAll");
            l = q.getResultList();

        } catch (HibernateException e) {
        }
        return l;

    }
         
 
 
  public Integer saveI(Model c) {
        Integer i = 0;
        Session session = null;
         Transaction tx = null;
         try
         {
         session = sessionFactory.openSession();
         tx = session.beginTransaction();
         session.saveOrUpdate(c);
         tx.commit();
         session.close();
                      }
         catch (Exception ex)
         {
            tx.rollback();
            // handle exception
         }
         finally
         {
            session.close();
         }
         i=c.getId();
        return i;
    }
 
 
  public void saveBC(BlockedCountryM2m c) {
        Session session = null;
         try
         {
         session = sessionFactory.getCurrentSession();
         session.saveOrUpdate(c);
         
                      }
         catch (Exception ex)
         {
           
         }
       
    }
 

   

    
     public void saveBR(BlockedRegionM2m c) {
        Session session = null;
         try
         {
         session = sessionFactory.getCurrentSession();
         session.saveOrUpdate(c);
         
                      }
         catch (Exception ex)
         {
           
         }
       
    }
    
    
    
     public void saveIn(InteresM2m c) {
        Session session = null;
         try
         {
         session = sessionFactory.getCurrentSession();
         session.saveOrUpdate(c);
         
                      }
         catch (Exception ex)
         {
           
         }
       
    }
    
  
    
         public void saveKn(KinkyM2m c) {
        Session session = null;
         try
         {
         session = sessionFactory.getCurrentSession();
         session.saveOrUpdate(c);
         
                      }
         catch (Exception ex)
         {
           
         }
       
    }
    


  
    

}
