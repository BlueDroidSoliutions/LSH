/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.chat;

import javax.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 *
 * @author roller
 */
public class ChatSchedulingConfigurer implements SchedulingConfigurer{
    
@Bean
  public ThreadPoolTaskScheduler taskScheduler() {
     return new ThreadPoolTaskScheduler();
  }
  
 
  @Bean
  @Inject
  public ActiveUserPinger activeUserPinger(SimpMessagingTemplate template, ActiveUserService activeUserService) {
    return new ActiveUserPinger(template, activeUserService);
  }

  @Override
  public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    taskRegistrar.setTaskScheduler(taskScheduler());
  }

 
}
