package com.livesexhouse.chat;

import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

public class ActiveUserPinger {

    @Autowired
    SessionFactory sessionFactory;

    private SimpMessagingTemplate template;

    Session session;
    Query q;

    Set<Integer> active = Sets.newTreeSet();
    List<Integer> users = new ArrayList<>();

    public ActiveUserPinger(SimpMessagingTemplate template) {
        this.template = template;

    }

    @Scheduled(fixedDelay = 2000)
    public void pingUsers() {

        try {
            session = sessionFactory.openSession();

            q = session.getNamedQuery("Online.findByStatus");
            q.setParameter("status", 2);
            users = q.getResultList();
            for (int s : users) {
                active.add(s);
            }
            template.convertAndSend("/topic/activeG", active);

            q.setParameter("status", 4);
            users.clear();
            users = q.getResultList();
            active.clear();
            for (int s : users) {
                active.add(s);
            }
            template.convertAndSend("/topic/activeGP", active);

            q.setParameter("status", 6);
            users.clear();
            users = q.getResultList();
            active.clear();
            for (int s : users) {
                active.add(s);
            }
            template.convertAndSend("/topic/activeM", active);

            q.setParameter("status", 8);
            users.clear();
            users = q.getResultList();
            active.clear();
            for (int s : users) {
                active.add(s);
            }
            template.convertAndSend("/topic/activeMP", active);
            users.clear();
            active.clear();

            session.close();
        } catch (HibernateException | MessagingException e) {

        }

    }

}
