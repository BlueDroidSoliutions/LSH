package com.livesexhouse.DAO;

import com.livesexhouse.model.VideoCategoryCountClip;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import com.livesexhouse.controller.Comparator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class VideoCategoryCountClipDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    Comparator comparator;

    public List<VideoCategoryCountClip> find() {
        List<VideoCategoryCountClip> result = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("VideoCategoryCountClip.findAll");
            result = query.getResultList();
        } catch (HibernateException e) {

        }

        return comparator.sort(result);
    }

}
