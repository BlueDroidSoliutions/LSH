package com.livesexhouse.DAO;

import com.livesexhouse.model.VideoRoom;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class VideoRoomDao {

    @Autowired
    SessionFactory sessionFactory;

    public List<VideoRoom> find() {
        List<VideoRoom> result = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("VideoRoom.findAll");
            result = query.getResultList();
        } catch (HibernateException e) {

        }
        return result;
    }

}
