/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.DAO;

import com.livesexhouse.model.Girls;
import com.livesexhouse.model.UserM2m;
import com.livesexhouse.model.VideoClip;
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
public class UserM2mDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void save(UserM2m u) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(u);
        } catch (HibernateException e) {
        }
    }

    public List<VideoClip> findFavVideosByUser(int id) {
        List<VideoClip> result = new ArrayList<>();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("SELECT v.favClip FROM UserM2m v WHERE v.userId = :m");
            q.setParameter("m", id);
            List cat = new ArrayList();
            cat = q.getResultList();

            Query q2 = sessionFactory.getCurrentSession().createQuery("SELECT v FROM VideoClip v WHERE v.id IN :cat");
            q2.setParameter("cat", cat);

            result = q2.getResultList();
        } catch (HibernateException e) {

        }

        return result;
    }
    
     public List<Girls> findFavGirlByUser(int id) {
        List<Girls> result = new ArrayList<>();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("SELECT v.favGirl FROM UserM2m v WHERE v.userId = :m");
            q.setParameter("m", id);
            List cat = new ArrayList();
            cat = q.getResultList();

            Query q2 = sessionFactory.getCurrentSession().createQuery("SELECT v FROM Girls v WHERE v.id IN :cat");
            q2.setParameter("cat", cat);

            result = q2.getResultList();
        } catch (HibernateException e) {

        }

        return result;
    }

    public List<VideoClip> findLikedVideosByUser(int id) {
        List<VideoClip> result = new ArrayList<>();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("SELECT v.likedClip FROM UserM2m v WHERE v.userId = :m");
            q.setParameter("m", id);
            List cat = new ArrayList();
            cat = q.getResultList();

            Query q2 = sessionFactory.getCurrentSession().createQuery("SELECT v FROM VideoClip v WHERE v.id IN :cat");
            q2.setParameter("cat", cat);

            result = q2.getResultList();
        } catch (HibernateException e) {

        }

        return result;
    }
    
    public List<UserM2m> findLikedVideosByUserId(int id, int vid) {
        List<UserM2m> result = new ArrayList<>();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("SELECT v FROM UserM2m v WHERE v.userId = :m AND v.likedClip = :n");
            q.setParameter("m", id);
            q.setParameter("n", vid);
           
            result = q.getResultList();
        } catch (HibernateException e) {

        }

        return result;
    }
    
    public List<UserM2m> findDisLikedVideosByUserId(int id , int vid) {
        List<UserM2m> result = new ArrayList<>();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("SELECT v FROM UserM2m v WHERE v.userId = :m AND v.disLikedclip = :n");
            q.setParameter("m", id);
             q.setParameter("n", vid);
           

            result = q.getResultList();
        } catch (HibernateException e) {

        }

        return result;
    }
    
    public List<UserM2m> findFacVideosByUserId(int id , int cid) {
        List<UserM2m> result = new ArrayList<>();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("SELECT v FROM UserM2m v WHERE v.userId = :m AND v.favClip = :n");
            q.setParameter("m", id);
            q.setParameter("n", cid);
           
            result = q.getResultList();
        } catch (HibernateException e) {

        }

        return result;
    }
    
     public void deleteLiked(int userId , int liked) {
        List<VideoClip> result = new ArrayList<>();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("delete FROM UserM2m v WHERE v.userId = :m AND v.likedClip = :n");
           
            q.setParameter("m", userId);
            q.setParameter("n", liked);
           
            q.executeUpdate();
        } catch (HibernateException e) {

        }}
        
         public void deleteDisLiked(int userId , int disliked) {
        List<VideoClip> result = new ArrayList<>();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("delete FROM UserM2m v WHERE v.userId = :m AND v.disLikedclip = :n");
           
            q.setParameter("m", userId);
            q.setParameter("n", disliked);
           
            q.executeUpdate();
        } catch (HibernateException e) {

        }

       
    }

}
