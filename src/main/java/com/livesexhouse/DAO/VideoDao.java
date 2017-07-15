package com.livesexhouse.DAO;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;


import com.livesexhouse.model.VideoClip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class VideoDao {

   @Autowired
    SessionFactory sessionFactory;
    
    public void save(VideoClip k){
       Session session = sessionFactory.getCurrentSession();
              session.save(k);
    } 
    public void update(VideoClip k){
       Session session = sessionFactory.getCurrentSession();
              session.update(k);
    } 
    
    public Integer saveR(VideoClip k){
        Session session = sessionFactory.getCurrentSession();
       Integer id = (Integer) session.save(k);
       
      return id;
    } 
    
    public void delete(VideoClip vc){
        Session session = sessionFactory.getCurrentSession();
        session.delete(vc);
    }
    
    
    
public VideoClip findById(int id) {
        
    VideoClip v = new VideoClip();
       
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("VideoClip.findById");
            query.setParameter("id", id);
            v = (VideoClip)query.getSingleResult();
        } catch (HibernateException e) {
        }
        return v;
    }

public VideoClip findByIdNewSes(int id) {
        
    VideoClip v = new VideoClip();
        try {
            Session session = sessionFactory.getCurrentSession();
        
            Query query = session.getNamedQuery("VideoClip.findByIdWithout");
            query.setParameter("id", id);
            v = (VideoClip)query.getSingleResult();
        } catch (HibernateException e) {
        }

        
        
        return v;
    }
    
    
    public Object[] search(String input) {

        List<VideoClip> result = new ArrayList();
        int numVideos = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
//            Criteria cr = session.createCriteria(VideoClip.class);
//            numVideos = cr.list().size();
//            
//            result = cr.list();

//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
//            EntityManager em = emf.createEntityManager();
//
//            FullTextEntityManager fullTextEntityManager
//                    = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
//            em.getTransaction().begin();
//
//            QueryBuilder qb = fullTextEntityManager.getSearchFactory()
//                    .buildQueryBuilder().forEntity(VideoClip.class).get();
//            org.apache.lucene.search.Query luceneQuery = qb
//                    .keyword()
//                    .onFields("name", "tag")
//                    .matching(input)
//                    .createQuery();
//
//            javax.persistence.Query jpaQuery
//                    = fullTextEntityManager.createFullTextQuery(luceneQuery, VideoClip.class);
//
////  search
//            result = jpaQuery.getResultList();
//            numVideos = result.size();
//
//            em.getTransaction().commit();
//            em.close();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");

            EntityManager em = emf.createEntityManager();
            FullTextEntityManager fullTextEntityManager
                    = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
            em.getTransaction().begin();

            QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                    .buildQueryBuilder().forEntity(VideoClip.class).get();
            org.apache.lucene.search.Query luceneQuery = qb
                    .keyword()
                    .onFields("name", "tag")
                    .matching(input)
                    .createQuery();

// wrap Lucene query in a javax.persistence.Query
            javax.persistence.Query jpaQuery
                    = fullTextEntityManager.createFullTextQuery(luceneQuery, VideoClip.class);

// execute search
            result = jpaQuery.getResultList();

            em.getTransaction().commit();
            em.close();

        } catch (HibernateException e) {
        }
        return new Object[]{result, numVideos};

    }

    public void update() throws InterruptedException {
        try {
            Session session = sessionFactory.getCurrentSession();
            FullTextSession fullTextSession = Search.getFullTextSession(session);
            fullTextSession.createIndexer().startAndWait();

        } catch (InterruptedException | HibernateException e) {
        }

    }

    public Object[] findAll(int maxVideoPerPage, int firstResult) {
        List<VideoClip> result = new ArrayList();
        int numVideos = 0;
        try {
            Session session = sessionFactory.getCurrentSession();

            Query query = session.getNamedQuery("VideoClip.findAll");
            numVideos = query.getResultList().size();

            query.setFirstResult(firstResult);
            query.setMaxResults(maxVideoPerPage);
            result = query.getResultList();

        } catch (HibernateException e) {
        }
        return new Object[]{result, numVideos};
    }

    public Object[] find(int maxVideoPerPage, int firstResult, int sort, int dateFilter, int roomFilter, int seasonFilter, int durationFilter, int memberFilter, int categoryFilter) {
        List<VideoClip> result = new ArrayList();
        int numVideos = 0;
        int videoNumTotal = 0;
        try {

            List seasonList = new ArrayList();
            List memberList = new ArrayList();
            List roomList = new ArrayList();
            List categoryList = new ArrayList();
            String and = "AND";
            String query = "";
            Boolean begin = false;
            Boolean noResult = false;
            Boolean memberB = false;
            Boolean seasonB = false;
            Boolean roomB = false;
            Boolean categoryB = false;
            

            Query videoNumTotalQ = sessionFactory.getCurrentSession().createQuery("SELECT v.id FROM VideoClip v");
            videoNumTotal = (int) videoNumTotalQ.getResultList().size();
            
            
            
            
            if (memberFilter != 0) {
                Query member = sessionFactory.getCurrentSession().createQuery("SELECT v.clipId FROM VideoM2m v WHERE v.memberHouseId = :m ");
                member.setParameter("m", memberFilter);
                memberList = member.getResultList();
                if(memberList.isEmpty())
                    noResult = true;
                query = query + "SELECT v FROM VideoClip v WHERE v.id IN :memberList";
                begin = true;
                memberB = true;
            }

            if (seasonFilter != 0) {
                Query season = sessionFactory.getCurrentSession().createQuery("SELECT v.clipId FROM VideoM2m v WHERE v.season = :s ");
                season.setParameter("s", seasonFilter);
                seasonList = season.getResultList();
                if(seasonList.isEmpty())
                    noResult = true;
                if (!begin) {
                    query = query + "SELECT v FROM VideoClip v WHERE v.id IN :seasonList";
                    begin = true;
                } else {
                    query = query + " AND v.id IN :seasonList";
                }
                seasonB = true;
            }

                            
            if (roomFilter != 0) {
                Query room = sessionFactory.getCurrentSession().createQuery("SELECT v.clipId FROM VideoM2m v WHERE v.room = :r ");
                room.setParameter("r", roomFilter);
                roomList = room.getResultList();
                if(roomList.isEmpty())
                    noResult = true;
                if(!begin){
                    query = query + "SELECT v FROM VideoClip v WHERE v.id IN :roomList";
                    begin = true;
                } else {
                    query = query + " AND v.id IN :roomList";
                }
                roomB=true;
            }

            if (categoryFilter != 0) {
                Query category = sessionFactory.getCurrentSession().createQuery("SELECT v.clipId FROM VideoM2m v WHERE v.categoryId = :c ");
                category.setParameter("c", categoryFilter);
                categoryList = category.getResultList();
                if(categoryList.isEmpty())
                    noResult = true;
                if(!begin){
                    query = query + "SELECT v FROM VideoClip v WHERE v.id IN :categoryList";
                    begin = true;
                } else {
                    query = query + " AND v.id IN :categoryList";
                }
                categoryB=true;
            }
            
            
            
            
            
            if(!noResult){
            
            Query q2 = sessionFactory.getCurrentSession().createQuery(query);

            if(memberB)
                q2.setParameter("memberList", memberList);
            if(seasonB)
                q2.setParameter("seasonList", seasonList);
            if(roomB)
                q2.setParameter("roomList", roomList);
            if(categoryB)
                q2.setParameter("categoryList", categoryList);
            
            

            numVideos = q2.getResultList().size();

            q2.setFirstResult(firstResult);
            q2.setMaxResults(maxVideoPerPage);
            
            result = q2.getResultList();
            }

//            switch (sort) {
//                case 0:
//                    cr.addOrder(Order.asc("name"));
//                    break;
//                case 1:
//                    cr.addOrder(Order.asc("name"));
//                    break;
//                case 2:
//                    cr.addOrder(Order.desc("name"));
//                    break;
//                case 3:
//                    cr.addOrder(Order.desc("wishList"));
//                    break;
//                case 4:
//                    cr.addOrder(Order.desc("view"));
//                    break;
//                case 5:
//                    cr.addOrder(Order.asc("like"));
//                    break;
//                case 6:
//                    cr.addOrder(Order.desc("like"));
//                    break;
//                case 7:
//                    cr.addOrder(Order.asc("uploadDate"));
//                    break;
//                case 8:
//                    cr.addOrder(Order.desc("uploadDate"));
//                    break;
//                case 9:
//                    cr.addOrder(Order.asc("season"));
//                    break;
//                case 10:
//                    cr.addOrder(Order.desc("season"));
//                    break;
//                case 11:
//                    cr.addOrder(Order.asc("duration"));
//                    break;
//                case 12:
//                    cr.addOrder(Order.desc("duration"));
//                    break;
//            }
            

        } catch (HibernateException e) {
        }
        return new Object[]{result, numVideos ,videoNumTotal};
    }
    
    
    
    
    

}
