/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.DAO;

import com.livesexhouse.chat.ChatMessage;
import com.livesexhouse.model.ChatMembers;
import com.livesexhouse.model.Girls;
import com.livesexhouse.model.Heartbeat;
import com.livesexhouse.model.Online;
import com.livesexhouse.model.Users;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roller
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class HeartbeatDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserDao userDao;

    @Autowired
    ChatMembersDao chatMembersDao;

    @Autowired
    OnlineDao onlineDao;

    ChatMessage chatMessage = new ChatMessage();

    SimpMessagingTemplate template;

    List<Integer> usersIdList = new ArrayList<>();
    List<Heartbeat> heartBeatList = new ArrayList<>();
    List<Users> usersList = new ArrayList<>();
    List<Users> girlsList = new ArrayList<>();
    List<Girls> girlsGList = new ArrayList<>();
    Set<Integer> girlsGSet = new HashSet<>();
    Set<Integer> girlsGFailSet = new HashSet<>();
    List<Integer> girlsListId = new ArrayList<>();
    Set<Integer> girlsSet = new HashSet<>();
    Set<Integer> usersSet = new HashSet<>();
    Set<Integer> usersFailSet = new HashSet<>();
    List<Heartbeat> heartBeatDeleteList = new ArrayList<>();
    List<Integer> chatMembersUserIdDelete = new ArrayList<>();
    List<ChatMembers> chatMembersDeleteList = new ArrayList<>();
    List<ChatMembers> chatMembersDeleteUsers = new ArrayList<>();
    List<Heartbeat> list = new ArrayList<>();
    List<Online> onlineList = new ArrayList<>();
    int min = 0;
    boolean girlsInPrivate = false;

    public HeartbeatDao(SimpMessagingTemplate template) {
        this.template = template;

    }

    public void findStatusTakeMoney(int i) {
        boolean reverse = false;
        try {

            Session session = sessionFactory.getCurrentSession();

            girlsGList.clear();
            girlsGSet.clear();
            usersIdList.clear();
            heartBeatList.clear();
            usersList.clear();
            girlsList.clear();
            girlsListId.clear();
            girlsSet.clear();
            usersSet.clear();
            heartBeatDeleteList.clear();
            chatMembersUserIdDelete.clear();
            chatMembersDeleteList.clear();
            girlsGFailSet.clear();
            min = 0;
            usersFailSet.clear();
            chatMembersDeleteUsers.clear();
            onlineList.clear();

            //uzimamo sve heartbeat-ove
            Query q = session.getNamedQuery("Heartbeat.findByStatus");
            q.setParameter("status", i);
            heartBeatList = q.getResultList();

            //
            // punimo listu sa id-evima korisnika i punimo listu sa id-evima devojaka
            if (!heartBeatList.isEmpty()) {
                for (Heartbeat m : heartBeatList) {
                    usersIdList.add(m.getUser());
                    girlsListId.add(m.getGirl());
                }

                // brisemo duplikate id-eva iz liste devojaka
                girlsSet.addAll(girlsListId);
                girlsListId.clear();
                girlsListId.addAll(girlsSet);

                //
                // brisemo duplikate id-eva iz liste usera ako ih ima
                usersSet.addAll(usersIdList);
                usersIdList.clear();
                usersIdList.addAll(usersSet);

                // uzimamo sve devojke U iz liste
                q = session.createQuery("SELECT u from Users u WHERE u.id IN :idl");
                q.setParameter("idl", girlsListId);
                girlsList = q.getResultList();

                // uzimamo sve devojke G iz liste
                q = session.createQuery("SELECT u from Girls u WHERE u.id IN :idl");
                q.setParameter("idl", girlsListId);
                girlsGList = q.getResultList();

                //
                // uzimamo sve usere iz liste    
                q = session.createQuery("SELECT u from Users u WHERE u.id IN :ids");
                q.setParameter("ids", usersIdList);
                usersList = q.getResultList();

                // skidamo kes ako ima para za sledeci minut, ako nema, saljemo mu da nema kesa
                for (Heartbeat hb : heartBeatList) {

                    for (Users us : usersList) {

                        if (hb.getUser() == us.getId()) {

                            // ako ima dovoljno da odgleda sledeci minut
                            if ((us.getTokens() - hb.getPrice()) > -1) {
                                // skida mu se token i posle apdejtuje
                                us.setTokens(us.getTokens() - hb.getPrice());

                                // dajemo devojci token
                                for (Users g : girlsList) {
                                    if (Objects.equals(g.getId(), hb.getGirl())) {
                                        g.setTokens(g.getTokens() + hb.getPrice());
                                    }
                                }

                                //
                            } else {
                                chatMessage.setMessage("nemateDovoljnoKesa###@@@");
                                chatMessage.setRecipient(us.getUsername());
                                chatMessage.setSender(us.getUsername());
                                template.convertAndSendToUser(us.getUsername(), "/queue/messages", chatMessage);
                                // treba da se brise iz liste hb i iz liste chatmembers
                                heartBeatDeleteList.add(hb);
                                chatMembersUserIdDelete.add(hb.getUser());
                            }
                        }
                    }
                }

                // brisemo iz hb onog ko nema kes
                if (!heartBeatDeleteList.isEmpty()) {
                    for (Heartbeat h : heartBeatDeleteList) {
                        session.delete(h);
                    }
                }

                // brisemo iz chatmembersa onog ko nema kesa  
                if (!chatMembersUserIdDelete.isEmpty()) {
                    q = session.createQuery("SELECT u from ChatMembers u WHERE u.userId IN :idp");
                    q.setParameter("idp", chatMembersUserIdDelete);
                    chatMembersDeleteList = q.getResultList();
                    for (ChatMembers cm : chatMembersDeleteList) {
                        session.delete(cm);
                    }

                }

                // apdejt tokena
                for (Users us : usersList) {
                    userDao.update(us);
                }

                // dajemo devojci tokene
                for (Users us : girlsList) {
                    userDao.update(us);
                }

            }

            usersIdList.clear();
            heartBeatList.clear();
            usersList.clear();
            girlsList.clear();
            girlsListId.clear();
            girlsSet.clear();
            usersSet.clear();
            heartBeatDeleteList.clear();
            chatMembersUserIdDelete.clear();
            chatMembersDeleteList.clear();
            girlsGList.clear();
            girlsGSet.clear();
            girlsGFailSet.clear();
            min = 0;
            usersFailSet.clear();
            chatMembersDeleteUsers.clear();
            onlineList.clear();

        } catch (HibernateException e) {
            usersIdList.clear();
            heartBeatList.clear();
            usersList.clear();
            girlsList.clear();
            girlsListId.clear();
            girlsSet.clear();
            usersSet.clear();
            heartBeatDeleteList.clear();
            chatMembersUserIdDelete.clear();
            chatMembersDeleteList.clear();
            girlsGList.clear();
            girlsGSet.clear();
            girlsGFailSet.clear();
            min = 0;
            usersFailSet.clear();
            chatMembersDeleteUsers.clear();
            onlineList.clear();
        }

    }

    public void checkGroupGirlUser(int i) {
        girlsGList.clear();
        girlsGSet.clear();
        usersIdList.clear();
        heartBeatList.clear();
        usersList.clear();
        girlsList.clear();
        girlsListId.clear();
        girlsSet.clear();
        usersSet.clear();
        heartBeatDeleteList.clear();
        chatMembersUserIdDelete.clear();
        chatMembersDeleteList.clear();
        girlsGFailSet.clear();
        min = 0;
        usersFailSet.clear();
        chatMembersDeleteUsers.clear();
        onlineList.clear();

        if (i != 5) {
            i++;
        } else {
            i = 0;
        }

        try {
            Set<Integer> privateGirls = new HashSet<>();
            Session session = sessionFactory.getCurrentSession();
            // uzimamo sve heartbeat-ove
            Query q = session.getNamedQuery("Heartbeat.findByStatus");
            q.setParameter("status", i);
            heartBeatList = q.getResultList();

            // uzimamo sve girlId-eve od private
            privateGirls = onlineDao.privateGirls();

            //
            // punimo listu sa id-evima korisnika i punimo listu sa id-evima devojaka
            if (!heartBeatList.isEmpty()) {
                for (Heartbeat m : heartBeatList) {
                    usersIdList.add(m.getUser());
                    girlsListId.add(m.getGirl());
                }
                // brisemo duplikate id-eva iz liste devojaka
                girlsSet.addAll(girlsListId);
                girlsListId.clear();
                girlsSet.removeAll(privateGirls);
                girlsListId.addAll(girlsSet);

                //
                // brisemo duplikate id-eva iz liste usera ako ih ima
                usersSet.addAll(usersIdList);
                usersIdList.clear();
                usersIdList.addAll(usersSet);

                // uzimamo sve devojke G iz liste
                if (!girlsListId.isEmpty()) {
                    q = session.createQuery("SELECT u from Girls u WHERE u.id IN :idl");
                    q.setParameter("idl", girlsListId);
                    girlsGList = q.getResultList();
                    // za sve devojke iz liste ako nemaju dovoljno korisnika
                    for (Girls g : girlsGList) {
                        min = chatMembersDao.count(g.getId());
                        if (min < g.getGroupMinPerson()) {
                            //ako nemaju dovoljno korisnika, punimo girlsGFailSet id-evima devojaka
                            girlsGFailSet.add(g.getId());
                            chatMessage.setMessage("@&$Out$^Of*%@Ussers");
                            chatMessage.setRecipient(g.getName());
                            chatMessage.setSender(g.getName());
                            template.convertAndSendToUser(g.getName(), "/queue/messages", chatMessage);

                        }
                    }
                }

                if (!girlsGFailSet.isEmpty()) {

                    List<Heartbeat> hbL = new ArrayList<>();
                    List<ChatMembers> cmL = new ArrayList<>();
                    List<Online> onL = new ArrayList<>();

                    q = session.createQuery("SELECT u from Heartbeat u WHERE u.girl IN :idl");
                    q.setParameter("idl", girlsGFailSet);
                    hbL = q.getResultList();
                    for (Heartbeat h : hbL) {
                        session.delete(h);
                    }
                    q = session.createQuery("SELECT u from ChatMembers u WHERE u.girlId IN :idl");
                    q.setParameter("idl", girlsGFailSet);
                    cmL = q.getResultList();
                    for (ChatMembers h : cmL) {
                        session.delete(h);
                    }
                    q = session.createQuery("SELECT u from Online u WHERE u.id IN :idl");
                    q.setParameter("idl", girlsGFailSet);
                    onL = q.getResultList();
                    for (Online h : onL) {
                        h.setStatus(2);
                        session.update(h);
                    }

                }

            }

            girlsGList.clear();
            girlsGSet.clear();
            usersIdList.clear();
            heartBeatList.clear();
            usersList.clear();
            girlsList.clear();
            girlsListId.clear();
            girlsSet.clear();
            usersSet.clear();
            heartBeatDeleteList.clear();
            chatMembersUserIdDelete.clear();
            chatMembersDeleteList.clear();
            girlsGFailSet.clear();
            min = 0;
            usersFailSet.clear();
            chatMembersDeleteUsers.clear();
            onlineList.clear();
        } catch (Exception e) {
            girlsGList.clear();
            girlsGSet.clear();
            usersIdList.clear();
            heartBeatList.clear();
            usersList.clear();
            girlsList.clear();
            girlsListId.clear();
            girlsSet.clear();
            usersSet.clear();
            heartBeatDeleteList.clear();
            chatMembersUserIdDelete.clear();
            chatMembersDeleteList.clear();
            girlsGFailSet.clear();
            min = 0;
            usersFailSet.clear();
            chatMembersDeleteUsers.clear();
            onlineList.clear();
        }

    }

    public void check(int i) {

        try {

            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("Heartbeat.findByStatus");

            int statusNext = 0;
            int statusPrev = 0;

            if (i == 0) {
                //nadji status 2, stavi im 12
                statusNext = 2;
                //nadji status 11 i stavi 7
                statusPrev = 11;
            }
            if (i == 1) {
                //nadji status 3, stavi im 13
                statusNext = 3;
                //nadji status 12 i stavi 7
                statusPrev = 12;
            }
            if (i == 2) {
                //nadji status 4, stavi im 14 
                statusNext = 4;
                //nadji status 13 i stavi 7
                statusPrev = 13;
            }
            if (i == 3) {
                //nadji status 5, stavi im 15 
                statusNext = 5;
                //nadji status 14 i stavi 7
                statusPrev = 14;
            }
            if (i == 4) {
                //nadji status 0, stavi im 10 
                statusNext = 0;
                //nadji status 15 i stavi 7
                statusPrev = 15;
            }
            if (i == 5) {
                //nadji status 1, stavi im 11 
                statusNext = 1;
                //nadji status 10 i stavi 7
                statusPrev = 10;
            }

            list.clear();
            q.setParameter("status", statusNext);
            list = q.getResultList();
            if (!list.isEmpty()) {
                for (Heartbeat h : list) {
                    h.setStatus(statusNext + 10);
                    session.update(h);
                }
            }

            if (!list.isEmpty()) {
                for (Heartbeat m : list) {
                    usersIdList.add(m.getUser());
                }

                // brisemo duplikate id-eva iz liste usera ako ih ima
                usersSet.addAll(usersIdList);
                usersIdList.clear();
                usersIdList.addAll(usersSet);

                // uzimamo sve usere iz liste    
                q = session.createQuery("SELECT u from Users u WHERE u.id IN :ids");
                q.setParameter("ids", usersIdList);
                usersList = q.getResultList();

                for (Users us : usersList) {
                    chatMessage.setMessage("&#@%he5re@+^" + (statusNext + 10));
                    chatMessage.setRecipient(us.getUsername());
                    chatMessage.setSender(us.getUsername());
                    template.convertAndSendToUser(us.getUsername(), "/queue/messages", chatMessage);
                }
            }

            list.clear();
            q = session.getNamedQuery("Heartbeat.findByStatus");
            q.setParameter("status", statusPrev);
            list = q.getResultList();

            q = session.getNamedQuery("Online.findByStatus");
            q.setParameter("status", 4);
            usersIdList.clear();
            usersIdList = q.getResultList();
            girlsInPrivate = !usersIdList.isEmpty();

            
            
            if (girlsInPrivate) {
               q = session.createQuery("SELECT u from Users u WHERE u.id IN :idl");
                q.setParameter("idl", usersIdList);
                girlsList.clear();
                girlsList = q.getResultList();
            }

            
           
            
            
            if (!list.isEmpty()) {

                if (girlsInPrivate) {

                    for (Heartbeat h : list) {
                        h.setStatus(7);
                        session.update(h);
                        for (Users g :girlsList) {

                            if (h.getGirl() == g.getId()) {
                              
                            chatMessage.setMessage("leave*#^Private@#&$");
                            chatMessage.setRecipient(g.getUsername());
                            chatMessage.setSender(g.getUsername());
                            template.convertAndSendToUser(g.getUsername(), "/queue/messages", chatMessage);
                                
                            }

                        }

                    }

                } else {

                    for (Heartbeat h : list) {
                        h.setStatus(7);
                        session.update(h);
                    }
                }

            }
            list.clear();
        } catch (HibernateException e) {
            list.clear();
        }
    }

    public void findStatus9giveNew(int newStatus) {
        list.clear();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("Heartbeat.findByStatus");
            q.setParameter("status", 9);
            list = q.getResultList();

            if (!list.isEmpty()) {
                for (Heartbeat h : list) {
                    h.setStatus(newStatus);
                    session.update(h);
                }
            }
            list.clear();

        } catch (HibernateException e) {
            list.clear();
        }

    }

    public void deleteStatus7() {
        list.clear();
        List<Integer> li = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("Heartbeat.findByStatus");
            q.setParameter("status", 7);
            list = q.getResultList();

            if (!list.isEmpty()) {

                for (Heartbeat h : list) {
                    li.add(h.getUser());
                    session.delete(h);
                }
                q = session.createQuery("SELECT c from ChatMembers c WHERE c.userId IN :ids");

                q.setParameter("ids", li);

                List<ChatMembers> lcm = new ArrayList<>();
                lcm = q.getResultList();

                for (ChatMembers c : lcm) {
                    session.delete(c);
                }

            }

            list.clear();
        } catch (HibernateException e) {
            list.clear();
        }
    }

    public void deleteFromUser(int id) {
        list.clear();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("Heartbeat.findByUser");
            q.setParameter("user", id);
            list = q.getResultList();

            if (!list.isEmpty()) {
                for (Heartbeat h : list) {
                    session.delete(h);
                }
            }
            list.clear();
        } catch (HibernateException e) {
            list.clear();
        }
    }

    public void deleteFromGirlPrivateOut(int girl) {
        list.clear();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("Heartbeat.findByGirl");
            q.setParameter("girl", girl);
            list = q.getResultList();

            if (!list.isEmpty()) {
                for (Heartbeat h : list) {
                    session.delete(h);
                }
            }
            list.clear();
        } catch (HibernateException e) {
            list.clear();
        }
    }

    public void setStatus(int userId, int status) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("Heartbeat.findByUser");
            q.setParameter("user", userId);

            Heartbeat h = new Heartbeat();

            h = (Heartbeat) q.getSingleResult();
            h.setStatus(status);
            session.save(h);

        } catch (Exception e) {

        }
    }

    public void setStatusMinus10(int userId, int status) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("Heartbeat.findByUser");
            q.setParameter("user", userId);

            Heartbeat h = new Heartbeat();

            h = (Heartbeat) q.getSingleResult();
            h.setStatus(status - 10);
            session.save(h);

        } catch (Exception e) {

        }
    }

    public void setUser(int userId, int status, int price, int girl) {
        try {
            Session session = sessionFactory.getCurrentSession();

            Heartbeat h = new Heartbeat();

            h.setGirl(girl);
            h.setPrice(price);
            h.setStatus(status);
            h.setUser(userId);

            session.save(h);

        } catch (Exception e) {

        }
    }

    public void deleteFromGirl(int girlId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = sessionFactory.getCurrentSession().createNativeQuery("delete from heartbeat where girl=" + girlId + ";");

            query.executeUpdate();
        } catch (HibernateException e) {
        }
    }

    public List<Heartbeat> findByGirl(int girlId) {
        List<Heartbeat> hbL = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.getNamedQuery("Heartbeat.findByGirl");
            q.setParameter("girl", girlId);

            hbL = q.getResultList();

        } catch (HibernateException e) {
        }
        return hbL;
    }

    public void checkAloneGirls() {
        List<Integer> isti = new ArrayList<>();
        Set<Integer> sIsti = new HashSet<>();
        List<Integer> nisu = new ArrayList<>();
        Set<Integer> sNisu = new HashSet<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query q = session.createNativeQuery("select girl_id from chatmembers where  girl_id = user_id; ");

            isti = q.getResultList();
            q = session.createNativeQuery("select girl_id from chatmembers where  girl_id != user_id; ");
            nisu = q.getResultList();

            sIsti.addAll(isti);

            sNisu.addAll(nisu);

            sIsti.removeAll(sNisu);

            isti.clear();

            isti.addAll(sIsti);

            if (!isti.isEmpty()) {
                chatMembersDao.deleteAloneGirls(isti);
                girlsList.clear();
                q = session.createQuery("SELECT u from Users u WHERE u.id IN :idl");
                q.setParameter("idl", isti);
                girlsList = q.getResultList();

                for (Users i : girlsList) {
                    chatMessage.setMessage("@*%REL)#$%OAD");
                    chatMessage.setRecipient(i.getUsername());
                    chatMessage.setSender(i.getUsername());
                    template.convertAndSendToUser(i.getUsername(), "/queue/messages", chatMessage);
                    onlineDao.setOnline(i.getId());
                }

            }

        } catch (HibernateException e) {
        }

    }

}
