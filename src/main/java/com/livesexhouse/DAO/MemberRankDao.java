/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.DAO;

import com.livesexhouse.model.MembersRank;
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
public class MemberRankDao {

    @Autowired
    SessionFactory sessionFactory;

   
    public List<MembersRank> find() {

        List<MembersRank> result = new ArrayList<>();

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("MembersRank.findAll");
            result = query.getResultList();
        } catch (HibernateException e) {

        }

        return result;
    }
    
    public List<MembersRank> findTop4() {

        List<MembersRank> result = new ArrayList<>();

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("MembersRank.findAll");
            query.setMaxResults(4);
            result = query.getResultList();
        } catch (HibernateException e) {

        }

        return result;
    }
    
     public List<MembersRank> findTop5() {

        List<MembersRank> result = new ArrayList<>();

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("MembersRank.findAll");
            query.setMaxResults(5);
            result = query.getResultList();
        } catch (HibernateException e) {

        }

        return result;
    }

}
