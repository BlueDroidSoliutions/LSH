package com.livesexhouse.DAO;

import com.livesexhouse.model.VideoCategories;
import com.livesexhouse.model.VideoM2m;
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
public class VideoM2mDao {

    @Autowired
    SessionFactory sessionFactory;

    public void delete(VideoM2m vc) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(vc);
        } catch (HibernateException e) {

        }

    }

    public VideoM2m findById(int id) {

        VideoM2m v = new VideoM2m();

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("VideoM2m.findById");
            query.setParameter("id", id);
            v = (VideoM2m) query.getSingleResult();

        } catch (HibernateException e) {
        }
        return v;
    }

    public Object[] save(VideoM2m k) {
        boolean b = false;
        int id = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            id = (Integer) session.save(k);
            b = true;
        } catch (HibernateException e) {
            b = false;
        }
        return new Object[]{b, id};
    }

    public List<Integer> findVideosIdByMember(int member) {
        List<Integer> result = new ArrayList<>();
        try {
            Query q = sessionFactory.getCurrentSession().getNamedQuery("VideoM2m.findByMemberHouse");
            q.setParameter("memberHouse", member);

            List<VideoM2m> vM2m = q.getResultList();

            for (VideoM2m c : vM2m) {
                result.add(c.getClipId());
            }
        } catch (HibernateException e) {

        }

        return result;
    }

    public List<Integer> findVideosIdBySeason(int season) {
        List<Integer> result = new ArrayList<>();
        try {
            Query q = sessionFactory.getCurrentSession().getNamedQuery("VideoM2m.findBySeason");
            q.setParameter("season", season);

            List<VideoM2m> vM2m = q.getResultList();

            for (VideoM2m c : vM2m) {
                result.add(c.getClipId());
            }
        } catch (HibernateException e) {

        }

        return result;
    }

    public List<Integer> findVideosIdByRoom(int room) {
        List<Integer> result = new ArrayList<>();
        try {
            Query q = sessionFactory.getCurrentSession().getNamedQuery("VideoM2m.findByRoom");
            q.setParameter("room", room);

            List<VideoM2m> vM2m = q.getResultList();

            for (VideoM2m c : vM2m) {
                result.add(c.getClipId());
            }
        } catch (HibernateException e) {

        }

        return result;
    }

    public List<VideoCategories> findCategoriesByVideoId(int id) {
        List<VideoCategories> result = new ArrayList<>();
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("SELECT v.categoryId FROM VideoM2m v WHERE v.clipId = :m");
            q.setParameter("m", id);
            List cat = new ArrayList();
            cat = q.getResultList();
            Query q2 = sessionFactory.getCurrentSession().createQuery("SELECT v FROM VideoCategories v WHERE v.id IN :cat");
            q2.setParameter("cat", cat);

            result = q2.getResultList();
        } catch (HibernateException e) {

        }

        return result;
    }

    public int findSeasonByVideoId(int id) {
        int r = 0;
        try {
            Query q = sessionFactory.getCurrentSession().createNativeQuery("SELECT v.season FROM video_m2m v WHERE v.clip_id =" + id + " and v.season is not null;");

            List<Integer> cat = new ArrayList<>();
            r = (Integer) q.getSingleResult();

        } catch (HibernateException e) {

        }

        return r;

    }

}
