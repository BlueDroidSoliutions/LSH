///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.livesexhouse.chat;
//
//import java.security.Principal;
//
//import javax.inject.Inject;
//
//import org.springframework.messaging.Message;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class ActiveUserController {
//  
//  private ActiveUserService activeUserService;
//
//  
//  public ActiveUserController(ActiveUserService activeUserService) {
//    this.activeUserService = activeUserService;
//  }
//  
//  @MessageMapping("/activeUsers")
//  public void activeUsers(Message<Object> message) {
//    Principal user = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
//    activeUserService.mark(user.getName());
//  }
//
//}