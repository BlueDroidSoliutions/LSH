package com.livesexhouse.DAO;

import com.livesexhouse.model.MemberHouse;
import com.livesexhouse.model.Users;
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
public class MemberHouseDao {

    @Autowired
    SessionFactory sessionFactory;

    public List<MemberHouse> find() {

        List<MemberHouse> result = new ArrayList<>();

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("MemberHouse.findAll");
            result = query.getResultList();
        } catch (HibernateException e) {

        }

        return result;
    }
    
    
  
     public void updateUserMinus1token(Users u) {
        try {
            Session session = sessionFactory.getCurrentSession();
//           Users u = (Users) session.get(Users.class, id);
           if(u.getTokens()>0)
            u.setTokens(u.getTokens()-1);
           session.update(u);
        } catch (HibernateException e) {
        }
    }
    
     public void updateMemberPlus1Vote(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
           MemberHouse u = (MemberHouse) session.get(MemberHouse.class, id);
           u.setVote(u.getVote()+1);
           session.update(u);
        } catch (HibernateException e) {
        }
    }
     

}
