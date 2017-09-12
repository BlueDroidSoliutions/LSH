/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.DAO;

import com.livesexhouse.model.UserM2m;
import com.livesexhouse.model.VideoCategories;
import com.livesexhouse.model.VideoClip;
import java.util.ArrayList;
import java.util.List;
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
public class UserM2mDAO {
    
      @Autowired
    SessionFactory sessionFactory;
    
    public void save(UserM2m u) {
     try{
        Session session = sessionFactory.getCurrentSession();
        session.save(u);
     }
     catch(Exception e){}
    }
    
    
    
    public List<VideoClip> findFavVideosByUser(int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("SELECT v.favClip FROM UserM2m v WHERE v.userId = :m");
            q.setParameter("m", id);
         List cat = new ArrayList();
         cat = q.getResultList();
         
         
         Query q2 = sessionFactory.getCurrentSession().createQuery("SELECT v FROM VideoClip v WHERE v.id IN :cat");
         q2.setParameter("cat", cat);
         
       
        List<VideoClip> result = new ArrayList<>();
        
        result = q2.getResultList();
        
        return result;
    }
    
    public List<VideoClip> findLikedVideosByUser(int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("SELECT v.likedClip FROM UserM2m v WHERE v.userId = :m");
            q.setParameter("m", id);
         List cat = new ArrayList();
         cat = q.getResultList();
         
         
         Query q2 = sessionFactory.getCurrentSession().createQuery("SELECT v FROM VideoClip v WHERE v.id IN :cat");
         q2.setParameter("cat", cat);
         
       
        List<VideoClip> result = new ArrayList<>();
        
        result = q2.getResultList();
        
        return result;
    }
    
    
    
}
