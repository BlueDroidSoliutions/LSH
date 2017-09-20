/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.chat;

import java.util.Set;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

public class ActiveUserPinger {

  private SimpMessagingTemplate template;
  private ActiveUserService activeUserService;

  public ActiveUserPinger(SimpMessagingTemplate template, ActiveUserService activeUserService) {
    this.template = template;
    this.activeUserService = activeUserService;
  }
  
  @Scheduled(fixedDelay = 2000)
  public void pingUsers() {
    Set<String> activeUsers = activeUserService.getActiveUsers();
    template.convertAndSend("/topic/active", activeUsers);
  }

}