package com.livesexhouse.DAO;

import com.livesexhouse.model.GirlsHair;
import com.livesexhouse.model.GirlsHair;
import com.livesexhouse.model.MemberHouse;
import com.livesexhouse.model.VideoCategories;
import com.livesexhouse.model.VideoCategoryCountClip;
import com.livesexhouse.model.VideoClip;
import com.livesexhouse.model.VideoM2m;
import com.livesexhouse.model.VideoRoom;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import com.livesexhouse.controller.Comparator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("VideoCategoryCountClip.findAll");
        List<VideoCategoryCountClip> result = query.getResultList();
        return comparator.sort(result);
    }
    
    
    
   
    
}
