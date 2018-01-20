package com.livesexhouse.DAO;

import com.livesexhouse.controller.Setup;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

public class SetupDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    Setup setup;

    public List<Setup> getSetups() {
        List<Setup> setups = new ArrayList<>();
        try {

            Query query = sessionFactory.getCurrentSession().getNamedQuery("Setup.findAll");

            setups = query.getResultList();

        } catch (HibernateException e) {
        }
        return setups;
    }

    public String getSiteName() {
        String r = "";
        try {
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Setup.findById");
            q.setParameter("id", 5);
            setup = (Setup) q.getSingleResult();
            r = setup.getValueString();
        } catch (HibernateException e) {
        }
        return r;

    }
    public String getStreamLnk() {
        String r = "";
        try {
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Setup.findById");
            q.setParameter("id", 15);
            setup = (Setup) q.getSingleResult();
            r = setup.getValueString();
        } catch (HibernateException e) {
        }
        return r;

    }
    
    
    
     public String getStreamLnkMH() {
        String r = "";
        try {
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Setup.findById");
            q.setParameter("id", 16);
            setup = (Setup) q.getSingleResult();
            r = setup.getValueString();
        } catch (HibernateException e) {
        }
        return r;

    }
     
     
     
             
             
        public String defaultCamOnLiveStream() {
        String r = "";
        try {
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Setup.findById");
            q.setParameter("id", 17);
            setup = (Setup) q.getSingleResult();
            r = setup.getValueString();
        } catch (HibernateException e) {
        }
        return r;

    }      

    public String getLocation() {
        String r = "";
        try {
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Setup.findById");
            q.setParameter("id", 1);
            setup = (Setup) q.getSingleResult();
            r = setup.getValueString();
        } catch (HibernateException e) {
        }
        return r;
    }

    public String getPath() {
        String r = "";
        try {
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Setup.findById");
            q.setParameter("id", 2);
            setup = (Setup) q.getSingleResult();
            r = setup.getValueString();
        } catch (HibernateException e) {
        }
        return r;
    }

    public String getMethodLocation() {
        String r = "";
        try {
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Setup.findById");
            q.setParameter("id", 4);
            setup = (Setup) q.getSingleResult();
            r = setup.getValueString();
        } catch (HibernateException e) {
        }
        return r;
    }

    public int maxVideoPerPage() {
        int r = 0;
        try {
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Setup.findById");
            q.setParameter("id", 3);
            setup = (Setup) q.getSingleResult();
            r = setup.getValueInt();
        } catch (HibernateException e) {
        }
        return r;
    }

    public int getTotalSeason() {
        int r = 0;
        try {
            Query q = sessionFactory.getCurrentSession().getNamedQuery("Setup.findById");
            q.setParameter("id", 6);
            setup = (Setup) q.getSingleResult();
            r = setup.getValueInt();
        } catch (HibernateException e) {
        }
        return r;
    }

}
