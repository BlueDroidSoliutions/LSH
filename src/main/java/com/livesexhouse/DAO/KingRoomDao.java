/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.DAO;

import com.livesexhouse.model.KingRoom;
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
public class KingRoomDao {

    @Autowired
    SessionFactory sessionFactory;

   public void save(KingRoom k) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(k);
        } catch (HibernateException e) {
        }
    }
    
   
   
   public void update(KingRoom k){
       
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(k);
            
        } catch (HibernateException e) {
        }
   }
   
   
   
   
    
    public KingRoom findKing(int girlId) {

        KingRoom u = new KingRoom();
       
     

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("KingRoom.findByGirl");
            query.setParameter("girl", girlId);
            if(!query.getResultList().isEmpty())
            u = (KingRoom) query.getSingleResult();
        } catch (HibernateException e) {
        }
        return u;
    }

    
    

}
