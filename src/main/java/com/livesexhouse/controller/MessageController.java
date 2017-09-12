package com.livesexhouse.controller;

import com.livesexhouse.chat.ChatMessage;
import java.security.Principal;

import javax.inject.Inject;

import org.springframework.messaging.Message;
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

    
    
    // servisni za rekvestove
    @MessageMapping("/service")
    public void service(Message<Object> message, @Payload ChatMessage chatMessage) throws Exception {

        
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
            System.out.println("FROM: "+authedSender);
            System.out.println("TO: " + recipient);
            System.out.println("MSG: "+ chatMessage.getMessage());
            System.out.println("*****************");
        
        }
    }
    
    
    
    // 1 na 1
    @MessageMapping("/chat")
    public void greeting(Message<Object> message, @Payload ChatMessage chatMessage) throws Exception {

        
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
            System.out.println("FROM: "+authedSender);
            System.out.println("TO: " + recipient);
            System.out.println("MSG: "+ chatMessage.getMessage());
            System.out.println("*****************");
        }
    }
    
    // grupni sa devojkama i ukucanima
    @MessageMapping("/group")
    public void c2(Message<Object> message, @Payload ChatMessage chatMessage) throws Exception {

        
        if (message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class) != null) {

            Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);

            String authedSender = principal.getName();

            chatMessage.setSender(authedSender);
            String recipient = chatMessage.getRecipient();
//            if (!authedSender.equals(recipient)) {
//                template.convertAndSendToUser(authedSender, "/queue/messages", chatMessage);
//            } 

            template.convertAndSend( "/queue/messages/"+recipient, chatMessage);
            
            System.out.println("*****************");
            System.out.println("FROM: "+authedSender);
            System.out.println("TO: " + recipient);
            System.out.println("MSG: "+ chatMessage.getMessage());
            System.out.println("*****************");
            
        }

    }

    
    // grupni livestream
     @MessageMapping("/liveStream")
    public void ls(Message<Object> message, @Payload ChatMessage chatMessage) throws Exception {

        
        if (message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class) != null) {

            Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);

            String authedSender = principal.getName();

            chatMessage.setSender(authedSender);
            String recipient = chatMessage.getRecipient();


            template.convertAndSend( "/queue/messages/"+recipient, chatMessage);
            
            System.out.println("*****************");
            System.out.println("FROM: "+authedSender);
            System.out.println("TO: " + recipient);
            System.out.println("MSG: "+ chatMessage.getMessage());
            System.out.println("*****************");
            
        }  

    }
    
    
    
    
    
    
    
}
