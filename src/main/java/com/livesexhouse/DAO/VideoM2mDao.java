package com.livesexhouse.DAO;

import com.livesexhouse.controller.Setup;
import com.livesexhouse.model.GirlsHair;
import com.livesexhouse.model.GirlsHair;
import com.livesexhouse.model.MemberHouse;
import com.livesexhouse.model.VideoClip;
import com.livesexhouse.model.VideoM2m;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class VideoM2mDao {

    @Autowired
    SessionFactory sessionFactory;
    
    
      public void delete(VideoM2m vc){
        Session session = sessionFactory.getCurrentSession();
        session.delete(vc);
    }
    
    
      
       public VideoM2m findById(int id) {
        
    VideoM2m v = new VideoM2m();
       
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("VideoM2m.findById");
            query.setParameter("id",id);
            v = (VideoM2m)query.getSingleResult();

        } catch (Exception e) {
        }
        return v;
    }
      
      
    
     public Object[] save(VideoM2m k){
         boolean b = false;
         int id = 0;
         try{
       Session session = sessionFactory.getCurrentSession();
       id = (Integer)session.save(k);
       b= true;
         } catch (Exception e){
             b=false;
         }
      return new Object[]{b,id};
    } 
    
    
    
    
    

    public List<Integer> findVideosIdByMember(int member) {
        
        
        Query q = sessionFactory.getCurrentSession().getNamedQuery("VideoM2m.findByMemberHouse");
            q.setParameter("memberHouse", member);
            
        List<VideoM2m> vM2m = q.getResultList();
        List<Integer> result = new ArrayList<>();
        for(VideoM2m c : vM2m){
            result.add(c.getClipId());
        }
        
        
                
        return result;
    }
    
    public List<Integer> findVideosIdBySeason(int season) {
        Query q = sessionFactory.getCurrentSession().getNamedQuery("VideoM2m.findBySeason");
            q.setParameter("season", season);
        
        List<VideoM2m> vM2m = q.getResultList();
        List<Integer> result = new ArrayList<>();
       
        for(VideoM2m c : vM2m){
            result.add(c.getClipId());
        }
                
        return result;
    }
    
   public List<Integer> findVideosIdByRoom(int room) {
        Query q = sessionFactory.getCurrentSession().getNamedQuery("VideoM2m.findByRoom");
            q.setParameter("room", room);
        
        List<VideoM2m> vM2m = q.getResultList();
       
        List<Integer> result = new ArrayList<>();
        for(VideoM2m c : vM2m){
            result.add(c.getClipId());
        }
        return result;
    }
    
}
