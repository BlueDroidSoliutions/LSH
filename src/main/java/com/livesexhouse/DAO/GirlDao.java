/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.DAO;

import com.livesexhouse.controller.Checker;
import com.livesexhouse.model.Girls;
import com.livesexhouse.model.UserRoles;
import com.livesexhouse.model.Users;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
public class GirlDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    Checker checker;

    @Autowired
    OnlineDao onlineDao;


    public List<Girls> findGirlsInactive() {
        List<Girls> activeGirls = new ArrayList<>();
        List<Integer> ac = new ArrayList<>();
        List<Girls> allGirls = new ArrayList<>();
        List<Girls> inactiveGirls = new ArrayList<>();

        try {
            ac = onlineDao.allOnlineGirls();
            
            if(!ac.isEmpty()){
            
            Session session = sessionFactory.getCurrentSession();
            Query q2 = session.createQuery("SELECT g FROM Girls g WHERE g.id IN :ac");
            q2.setParameter("ac", ac);
            activeGirls = q2.getResultList();

            Query q = session.getNamedQuery("Girls.findByEnabled");
            allGirls = q.getResultList();
            inactiveGirls = q.getResultList();
            
            for ( int i = 0 ; i < inactiveGirls.size() ; i++) {
                for (Girls s : activeGirls) {
                    if (inactiveGirls.get(i).getId() == s.getId()) {
                        inactiveGirls.remove(i);
                    }
                }

            }
            } else {
                Session session = sessionFactory.getCurrentSession();
                Query q = session.getNamedQuery("Girls.findByEnabled");
            allGirls = q.getResultList();
            inactiveGirls = allGirls;
            }
           

        } catch (HibernateException e) {
        }
        return  inactiveGirls;

    }
    
    public List<Girls> findGirlsActive() {
        List<Girls> activeGirls = new ArrayList<>();
        List<Integer> ac = new ArrayList<>();
       

        try {
            ac = onlineDao.allOnlineGirls();
            if(!ac.isEmpty()){
            Session session = sessionFactory.getCurrentSession();
            Query q2 = session.createQuery("SELECT v FROM Girls v WHERE v.id IN :ac");
            q2.setParameter("ac", ac);
            activeGirls = q2.getResultList();

            }
           
        } catch (HibernateException e) {
        }
        return activeGirls;

    }
    
     public List<Girls> findGirlsActive23(int id) {
        List<Girls> activeGirls = new ArrayList<>();
        List<Girls> activeGirlsF = new ArrayList<>();
        List<Integer> ac = new ArrayList<>();
       

        try {
            ac = onlineDao.allOnlineGirls23();
            if(!ac.isEmpty()){
            Session session = sessionFactory.getCurrentSession();
            Query q2 = session.createQuery("SELECT v FROM Girls v WHERE v.id IN :ac");
            q2.setParameter("ac", ac);
            activeGirls = q2.getResultList();
            
            for(Girls gg : activeGirls){
                if(gg.getId()!=id){
                    activeGirlsF.add(gg);
                }
            }
            
            
            if(activeGirlsF.isEmpty()){
                  q2 = session.getNamedQuery("Girls.findAll");
            q2.setMaxResults(4);
            activeGirls = q2.getResultList();
            for(Girls gg : activeGirls){
                if(gg.getId()!=id){
                    activeGirlsF.add(gg);
                }
            }
            
            activeGirlsF.size();
            if(activeGirlsF.size()==4){
                activeGirlsF.remove(3);
            } 
            
            }

            } else {
                Session session = sessionFactory.getCurrentSession();
            Query q2 = session.getNamedQuery("Girls.findAll");
            q2.setMaxResults(4);
            activeGirls = q2.getResultList();
            for(Girls gg : activeGirls){
                if(gg.getId()!=id){
                    activeGirlsF.add(gg);
                }
            }
            
            activeGirlsF.size();
            if(activeGirlsF.size()==4){
                activeGirlsF.remove(3);
            }
            
            
            }
           
        } catch (HibernateException e) {
        }
        return activeGirlsF;

    }

    public Girls findByUsername(String username) {

        Girls u = new Girls();

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("Girls.findByName");
            query.setParameter("name", username);
            u = (Girls) query.getSingleResult();
        } catch (HibernateException e) {
        }
        return u;
    }

    public List<Girls> findGirls() {
        List<Girls> l = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Girls.findByEnabled");
            l = q.getResultList();

        } catch (HibernateException e) {
        }
        return l;

    }

    public String pricePrivate(int id) {
        String num = "";
        
        try {
          

                Session session = sessionFactory.getCurrentSession();
                Query q = 
//                        sessionFactory.getCurrentSession().createNativeQuery("SELECT id FROM girls where name='" + userName + "';");
//                id = q.getSingleResult().toString();
//                q = 
                        sessionFactory.getCurrentSession().createNativeQuery("SELECT private_tariff FROM girls where id=" + id + ";");
                num = q.getSingleResult().toString();
           
        } catch (HibernateException e) {
        }
        return num;

    }

    public String priceGroup(String userName) {
        String num = "";
        String id = "";
        try {
            if (checker.check(userName)) {
                Session session = sessionFactory.getCurrentSession();
                Query q = sessionFactory.getCurrentSession().createNativeQuery("SELECT id FROM girls where name='" + userName + "';");
                id = q.getSingleResult().toString();
                q = sessionFactory.getCurrentSession().createNativeQuery("SELECT group_tariff FROM girls where id=" + id + ";");
                num = q.getSingleResult().toString();
            }
        } catch (HibernateException e) {
        }
        return num;

    }

    public String minPersons(String userName) {
        String num = "";
        String id = "";
        try {
            if (checker.check(userName)) {
                Session session = sessionFactory.getCurrentSession();
                Query q = sessionFactory.getCurrentSession().createNativeQuery("SELECT id FROM girls where name='" + userName + "';");
                id = q.getSingleResult().toString();
                q = sessionFactory.getCurrentSession().createNativeQuery("SELECT group_min_person FROM girls where id=" + id + ";");
                num = q.getSingleResult().toString();
            }
        } catch (HibernateException e) {
        }
        return num;

    }

    public Girls findById(int id) {

        Girls u = new Girls();

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("Girls.findById");
            query.setParameter("id", id);
            u = (Girls) query.getSingleResult();
        } catch (HibernateException e) {
        }
        return u;
    }

    public Integer save(Users c) {
        Integer i = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            i = (Integer) session.save(c);
        } catch (HibernateException e) {
        }
        return i;
    }

    public void saveRola(UserRoles u) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(u);
        } catch (HibernateException e) {
        }
    }

    public void delete(Users c) {

        try {
            Session session = sessionFactory.getCurrentSession();
//        session.delete(c);

            Query query = session.createNativeQuery("DELETE FROM users WHERE id = " + c.getId() + ";");
            query.executeUpdate();
            query = session.createNativeQuery("DELETE FROM user_m2m WHERE user_id = " + c.getId() + ";");
            query.executeUpdate();
            query = session.createNativeQuery("DELETE FROM user_roles WHERE username_id = " + c.getId() + ";");
            query.executeUpdate();
            query = session.createNativeQuery("DELETE FROM user_bck_data WHERE id = " + c.getId() + ";");
            query.executeUpdate();

        } catch (HibernateException e) {
        }

    }

    public void update(Users u) {

        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(u);
        } catch (HibernateException e) {

        }

    }

    public void updateGirl(Girls g) {

        try {
            Session session = sessionFactory.getCurrentSession();

            Query query = session.createNativeQuery("update girls set private_tariff=" + g.getPrivateTariff() + ",group_tariff=" + g.getGroupTariff() + ",group_min_person=" + g.getGroupMinPerson() + " where id = " + g.getId() + ";");

            query.executeUpdate();
        } catch (HibernateException e) {

        }

    }

}
