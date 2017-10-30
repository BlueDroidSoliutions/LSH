package com.livesexhouse.controller;

import com.livesexhouse.DAO.HeartbeatDao;
import com.livesexhouse.model.Heartbeat;
//import com.livesexhouse.DAO.HeartbeatDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;

import org.springframework.scheduling.annotation.Scheduled;

public class HeartBeatCTRL {

    @Autowired
    SessionFactory sessionFactory;
    
    @Autowired
    HeartbeatDao heartbeatDao;

    Session session;
    Query q;
    int i = 0;
    
    List<Heartbeat> list = new ArrayList<>();
    

    public HeartBeatCTRL() {

    }

    @Scheduled(fixedDelay = 10000)
    public void pingUsers() {

        try {
            
           
            // kad user prihvati grupni, status je 8 i ceka se status 9
            // ako je status 9 , krenuo je cet
            // ako je status 7 , izasli su iz ceta
            
            
            i++;
            if (i == 6)   i = 0;
//            System.out.println("&&&&&&&&& " + i);
            
            
            // brisemo korisnike sa statusom 7 , izasli su iz ceta
            heartbeatDao.deleteStatus7();
            
            
            // nadji sve gde je status 9 i daj im status i=ja 
            heartbeatDao.findStatus9giveNew(i);
            
            
            // nadji status i-ja , skini im novac i daj devojkama
            heartbeatDao.findStatusTakeMoney(i);
            
            
            // posalji im zahtev da li su tu i regulisi to
            heartbeatDao.check(i);
            
            heartbeatDao.checkGroupGirlUser(i);
            
            heartbeatDao.checkAloneGirls();
            
            
        } catch (HibernateException | MessagingException e) {

        }

    }

}
