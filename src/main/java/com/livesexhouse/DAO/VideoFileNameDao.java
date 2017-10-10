package com.livesexhouse.DAO;

import com.livesexhouse.model.VideoFileName;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class VideoFileNameDao {

    @Autowired
    SessionFactory sessionFactory;

    public void delete(VideoFileName vc) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(vc);
        } catch (HibernateException e) {

        }

    }

    public Object[] save(VideoFileName k) {
        boolean b = true;
        int id = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            id = (Integer) session.save(k);
        } catch (HibernateException e) {
            b = false;
        }
        return new Object[]{b, id};
    }

    public VideoFileName findById(int id) {

        VideoFileName v = new VideoFileName();

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("VideoFileName.findByClipId");
            query.setParameter("clipId", id);
            v = (VideoFileName) query.getSingleResult();

        } catch (HibernateException e) {
        }
        return v;
    }

    public boolean exist(String key) {
        boolean b = false;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("VideoFileName.findByFileName");
            q.setParameter("fileName",key );
            List l = new ArrayList();
            l = q.getResultList();
            if(!l.isEmpty()){
                b=true;
            }
//          
        } catch (HibernateException e) {
        }
        return b;
    }

}
