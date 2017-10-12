package com.livesexhouse.controller;

import com.livesexhouse.DAO.ChatDAO;
import com.livesexhouse.DAO.ChatMembersDao;
import com.livesexhouse.DAO.GirlDao;
import com.livesexhouse.DAO.OnlineDao;
import com.livesexhouse.DAO.UserDao;
import com.livesexhouse.chat.ChatMessage;
import com.livesexhouse.model.Chat;
import com.livesexhouse.model.Girls;
import com.livesexhouse.model.Users;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private SimpMessagingTemplate template;

    @Inject
    public MessageController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Autowired
    ChatDAO chatDAO;

    @Autowired
    GirlDao girlDao;

    @Autowired
    OnlineDao onlineDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ChatMembersDao chatMembersDao;

    private Chat chat = new Chat();
    private Date date = new Date();

    // 1. servisni za rekvestove
    @MessageMapping("/service")
    public void service(Message<Object> message, @Payload ChatMessage chatMessage) throws Exception {

        try {
            if (message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class) != null) {

                Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);

                boolean b = true;

                date = new Date();

                chat.setFromUser(principal.getName());
                chat.setMsg(chatMessage.getMessage());
                chat.setService(1);
                chat.setToUser(chatMessage.getRecipient());
                chat.setDate(date);

                chatMessage.setSender(principal.getName());
                String recipient = chatMessage.getRecipient();

                
                
                
                
                
                
                
                if (chatMessage.getMessage().contains("ttiipp")) {
                    System.out.println("t1");
                    
                    String[] parts = chatMessage.getMessage().split(" ");
                    String part = parts[1];
                    int tip = Integer.valueOf(part);
                    
                    System.out.println("tip"+tip);
                    
                    Users u = new Users();
                    Users ug = new Users();
                    
                    
                    u=userDao.findByUsername(principal.getName());
                    ug=userDao.findById(Integer.valueOf(chatMessage.getRecipient()));
                    
                    
                    
                    
                    if(ug.getUsername()!= null && u.getUsername()!=null){
                        if(u.getTokens()-tip < 0){
                            chatMessage.setMessage("You do not have enough tokens, try a smaller amount");
                            chatMessage.setRecipient(principal.getName());
                            chatMessage.setSender(ug.getUsername());
                            template.convertAndSendToUser(principal.getName(), "/queue/messages", chatMessage);
                        } else {
                            u.setTokens(u.getTokens()-tip);
                            girlDao.update(u);
                            
                            ug.setTokens(ug.getTokens()+tip);
                            girlDao.update(ug);
                            chatMessage.setMessage("You have new "+tip+" token from "+u.getUsername());
                            chatMessage.setRecipient(ug.getUsername());
                            chatMessage.setSender(ug.getUsername());
                            template.convertAndSendToUser(principal.getName(), "/queue/messages", chatMessage);
                        }
                    }
                    
                }
                
                
                
                
                
                
                
                
                
                
                
                if (chatMessage.getMessage().equals("invitePrivatePrice")) {
                    chatMessage.setMessage("Are you sure you want to invite this girl to private chat?\nHer tariff is " + girlDao.pricePrivate(chatMessage.getRecipient()) + " tokens per minute.");
                    chat.setToUser(principal.getName());
                    recipient = principal.getName();
                }

                // ako je devojka poslala invite
                if (chatMessage.getMessage().equals("inviteGroupPriceJoin")) {
                    chatMessage.setMessage("Are you sure you want to join this group chat?\nHer tariff is " + girlDao.priceGroup(chatMessage.getRecipient()) + " tokens per minute.");
                    chat.setToUser(principal.getName());
                    recipient = principal.getName();
                }

                // ako user salje invite
                if (chatMessage.getMessage().equals("inviteGroupPrice")) {
                    Users u = new Users();
                    Girls g = new Girls();
                    g = girlDao.findByUsername(recipient);
                    u = userDao.findByUsername(principal.getName());

                    int girlGroupPrice = g.getGroupTariff();
                    int userTokens = u.getTokens();

                    if (userTokens < girlGroupPrice) {
                        chatMessage.setMessage("You do not have enough tokens");
                        chatMessage.setSender(u.getUsername());
                        template.convertAndSendToUser(principal.getName(), "/queue/messages", chatMessage);
                    } else {
                        chatMessage.setMessage("Are you sure you want to invite this girl to group chat?\nHer tariff is " + girlDao.priceGroup(chatMessage.getRecipient()) + " tokens per minute.");
                        chat.setToUser(principal.getName());
                        recipient = principal.getName();
                    }
                }

                // ako user salje invite posle potvrde
                if (chatMessage.getMessage().equals("inviteGroupFromUser")) {
                    Users u = new Users();
                    Girls g = new Girls();
                    g = girlDao.findByUsername(recipient);
                    u = userDao.findByUsername(principal.getName());

                    int girlGroupPrice = g.getGroupTariff();
                    int userTokens = u.getTokens();

                    if (userTokens > girlGroupPrice) {
                        chatMessage.setMessage(u.getUsername() + " sent invitation for group chat to you.\nDo you accept?");
                        chatMessage.setRecipient(g.getName());
                        chatMessage.setSender(g.getName());
                        template.convertAndSendToUser(g.getName(), "/queue/messages", chatMessage);
                        b = false;
                    }
                }

                // ako je devojka prihvatila invitaciju od usera, ubacujemo tog usera u listu chatMembersa i saljemo svima status
                if (chatMessage.getMessage().contains("iAcceptGroupFromUser")) {

                    String[] parts = chatMessage.getMessage().split(" ");
                    String part = parts[1];

                    Users u = new Users();
                    Girls g = new Girls();
                    g = girlDao.findByUsername(principal.getName());
                    u = userDao.findByUsername(parts[1]);

                    chatMembersDao.setUser(u.getId(), g.getId());

                    chatMessage.setSender(g.getName());

                    chatMessage.setMessage(g.getName() + " want group chat, to accept click join group chat");
                    template.convertAndSend("/queue/messages/" + g.getName(), chatMessage);

                    int activeUsersInGroup = chatMembersDao.count(g.getId());
                    int girlMinPersons = g.getGroupMinPerson();

                    chatMessage.setMessage("Users for group chat " + activeUsersInGroup + "/" + girlMinPersons);
                    template.convertAndSend("/queue/messages/" + g.getName(), chatMessage);
                    template.convertAndSendToUser(g.getName(), "/queue/messages", chatMessage);
                    chatMessage.setSender(u.getUsername());
                    chatMessage.setRecipient(u.getUsername());
                    chatMessage.setMessage(g.getName() + " accepted your invitation for group chat, please wait for other users");
                    template.convertAndSendToUser(u.getUsername(), "/queue/messages", chatMessage);
                    b = false;
                }

                // ako devojka prihvati private u tom trenutku salje da je u privatnom
                if (chatMessage.getMessage().equals("privateNow")) {
                    Users u = new Users();
                    u = userDao.findByUsername(principal.getName());
                    if (u.getEnabled() == 2) {
                        onlineDao.setPrivate(u.getId());
                        b = false;
                        chatMessage.setSender(principal.getName());
                        chatMessage.setMessage("The girl is in private mode");
                        template.convertAndSend("/queue/messages/" + u.getUsername(), chatMessage);
                    }

                }

                // ako devojka prihvati group u tom trenutku salje da je u grupnom
                if (chatMessage.getMessage().equals("groupNow")) {
                    Users u = new Users();
                    u = userDao.findByUsername(principal.getName());
                    if (u.getEnabled() == 2) {
                        onlineDao.setGroup(u.getId());
                        b = false;
                    }
                }

                if (chatMessage.getMessage().equals("acceptGroupFromUser")) {
                    Users u = new Users();
                    Girls g = new Girls();
                    g = girlDao.findByUsername(recipient);
                    u = userDao.findByUsername(principal.getName());
                    int girlGroupPrice = g.getGroupTariff();
                    int userTokens = u.getTokens();

                    if (userTokens < girlGroupPrice) {
                        chatMessage.setMessage("You do not have enough tokens");
                        chatMessage.setSender(u.getUsername());
                        template.convertAndSendToUser(principal.getName(), "/queue/messages", chatMessage);
                    } else {
                        int girlMinPersons = g.getGroupMinPerson();
                        chatMembersDao.setUser(u.getId(), g.getId());
                        int activeUsersInGroup = chatMembersDao.count(g.getId());

                        if (girlMinPersons <= activeUsersInGroup) {
                            //spreman chat
                            System.out.println("############# spreman");
                            chatMessage.setSender(g.getName());
                            chatMessage.setMessage("groupChatIsReady");
                            chatMembersDao.setUser(g.getId(), g.getId());
                            template.convertAndSend("/queue/messages/" + g.getName(), chatMessage);
//                        template.convertAndSendToUser(g.getId().toString(), "/queue/messages", chatMessage);
//                        chatMessage.setRecipient(g.getName());
//                        template.convertAndSendToUser(g.getName(), "/queue/messages", chatMessage);

                            chatMessage.setMessage("groupChatIsReady");
                            chatMessage.setRecipient(g.getName());
                            chatMessage.setSender(g.getName());
                            template.convertAndSendToUser(g.getName(), "/queue/messages", chatMessage);

                            System.out.println("############# spreman2");

                        } else {
                            //salje se userima koliko ima aktivnih korisnika
                            chatMessage.setSender(g.getName());
                            chatMessage.setMessage("Users for group chat " + activeUsersInGroup + "/" + girlMinPersons);
                            template.convertAndSend("/queue/messages/" + g.getName(), chatMessage);
                            template.convertAndSendToUser(g.getName(), "/queue/messages", chatMessage);

                        }

                    }

                    b = false;
                }

                // kada devojka izadje iz privatnog
                if (chatMessage.getMessage().equals("onlineNow")) {
                    Users u = new Users();
                    u = userDao.findByUsername(principal.getName());
                    if (u.getEnabled() == 2) {
                        onlineDao.setOnline(u.getId());
                        b = false;
                    }
                }

                
                // kada devojka posalje invite za group
                if (chatMessage.getMessage().equals("inviteGroup")) {
                    Users u = new Users();
                    u = userDao.findByUsername(principal.getName());
                    if (u.getEnabled() == 2) {
                        b = false;
                        chatMessage.setSender(u.getUsername());

                        chatMessage.setMessage(u.getUsername() + " want group chat, to accept click join group chat");
                        template.convertAndSend("/queue/messages/" + principal.getName(), chatMessage);

                    }
                }

//                chatDAO.save(chat);

//              
                if (b) {
                    template.convertAndSendToUser(recipient, "/queue/messages", chatMessage);
                }

                System.out.println("*****************");
                System.out.println("service");
                System.out.println("FROM: " + chatMessage.getSender());
                System.out.println("TO: " + chatMessage.getRecipient());
                System.out.println("MSG: " + chatMessage.getMessage());
                System.out.println("*****************");

            }
        } catch (MessagingException e) {

        }

    }

    // 2. chat 1 na 1
    @MessageMapping("/private")
    public void greeting(Message<Object> message, @Payload ChatMessage chatMessage) throws Exception {

        try {
            if (message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class) != null) {

                Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);

                String authedSender = principal.getName();

                chatMessage.setSender(authedSender);
                String recipient = chatMessage.getRecipient();
                if (!authedSender.equals(recipient)) {
                    template.convertAndSendToUser(authedSender, "/queue/messages", chatMessage);
                }

                template.convertAndSendToUser(recipient, "/queue/messages", chatMessage);
                System.out.println("*****************");
                System.out.println("private");
                System.out.println("FROM: " + authedSender);
                System.out.println("TO: " + recipient);
                System.out.println("MSG: " + chatMessage.getMessage());
                System.out.println("*****************");

                date = new Date();

                chat.setFromUser(principal.getName());
                chat.setMsg(chatMessage.getMessage());
                chat.setService(2);
                chat.setToUser(chatMessage.getRecipient());

                chat.setDate(date);
//                chatDAO.save(chat);
            }
        } catch (MessagingException e) {

        }

    }

    // 3. public sa devojkama i ukucanima
    @MessageMapping("/public")
    public void c2(Message<Object> message, @Payload ChatMessage chatMessage) throws Exception {

        try {
            if (message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class) != null) {

                Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);

                String authedSender = principal.getName();

                chatMessage.setSender(authedSender);
                String recipient = chatMessage.getRecipient();
//            if (!authedSender.equals(recipient)) {
//                template.convertAndSendToUser(authedSender, "/queue/messages", chatMessage);
//            } 

                template.convertAndSend("/queue/messages/" + recipient, chatMessage);

                System.out.println("*****************");
                System.out.println("public");
                System.out.println("FROM: " + authedSender);
                System.out.println("TO: " + recipient);
                System.out.println("MSG: " + chatMessage.getMessage());
                System.out.println("*****************");

                date = new Date();

                chat.setFromUser(principal.getName());
                chat.setMsg(chatMessage.getMessage());
                chat.setService(3);
                chat.setToUser(chatMessage.getRecipient());
                chat.setDate(date);
//                chatDAO.save(chat);

            }
        } catch (MessagingException e) {

        }

    }

    // 4. grupni livestream
    @MessageMapping("/liveStream")
    public void ls(Message<Object> message, @Payload ChatMessage chatMessage) throws Exception {
        try {
            if (message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class) != null) {

                Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);

                String authedSender = principal.getName();

                chatMessage.setSender(authedSender);
                String recipient = chatMessage.getRecipient();

                template.convertAndSend("/queue/messages/" + recipient, chatMessage);

                System.out.println("*****************");
                System.out.println("liveStream");
                System.out.println("FROM: " + authedSender);
                System.out.println("TO: " + recipient);
                System.out.println("MSG: " + chatMessage.getMessage());
                System.out.println("*****************");

                date = new Date();

                chat.setFromUser(principal.getName());
                chat.setMsg(chatMessage.getMessage());
                chat.setService(4);
                chat.setToUser(chatMessage.getRecipient());

                chat.setDate(date);
//                chatDAO.save(chat);

            }
        } catch (MessagingException e) {

        }

    }

    // 5. grupni
    @MessageMapping("/group")
    public void group(Message<Object> message, @Payload ChatMessage chatMessage) throws Exception {
        try {
            if (message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class) != null) {

                Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);

                String authedSender = principal.getName();

                chatMessage.setSender(authedSender);
                String recipient = chatMessage.getRecipient();
//            if (!authedSender.equals(recipient)) {
//                template.convertAndSendToUser(authedSender, "/queue/messages", chatMessage);
//            }

                List<String> allUsers = new ArrayList();

                Users u = new Users();
                Girls g = new Girls();

                u = userDao.findByUsername(principal.getName());
                g = girlDao.findByUsername(chatMessage.getRecipient());
                int girlMinPersons = g.getGroupMinPerson();
                chatMembersDao.setUser(u.getId(), g.getId());
                int activeUsersInGroup = chatMembersDao.count(g.getId());

                chatMessage.setMessage(principal.getName() + ": " + chatMessage.getMessage());

                if (girlMinPersons <= activeUsersInGroup) {
                    // chat je ok
                    // select all user i salji poruku od devojke

                    allUsers = chatMembersDao.selectAllUsers(g.getId());

                    chatMessage.setSender(g.getName());

                    for (String s : allUsers) {
                        if (!principal.getName().equals(s)) {
                            chatMessage.setRecipient(s);
                            template.convertAndSendToUser(s, "/queue/messages", chatMessage);
                        }
                    }

                } else {

                    // cat poruka svima da nema dovoljno usera
                    chatMembersDao.deleteFromGirl(g.getId());

                    allUsers = chatMembersDao.selectAllUsers(g.getId());

                    chatMessage.setSender(g.getName());

                }

                template.convertAndSendToUser(recipient, "/queue/messages", chatMessage);
                System.out.println("*****************");
                System.out.println("group");
                System.out.println("FROM: " + authedSender);
                System.out.println("TO: " + recipient);
                System.out.println("MSG: " + chatMessage.getMessage());
                System.out.println("*****************");

                date = new Date();

                chat.setFromUser(principal.getName());
                chat.setMsg(chatMessage.getMessage());
                chat.setService(5);
                chat.setToUser(chatMessage.getRecipient());

                chat.setDate(date);
//                chatDAO.save(chat);
            }
        } catch (MessagingException e) {

        }

    }

}
