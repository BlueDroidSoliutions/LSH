//
//package com.livesexhouse.chat;
//
//
//import java.util.List;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.converter.MessageConverter;
//import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
//import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
//import org.springframework.messaging.simp.config.ChannelRegistration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
//
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry ser) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void configureWebSocketTransport(WebSocketTransportRegistration wstr) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void configureClientInboundChannel(ChannelRegistration cr) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void configureClientOutboundChannel(ChannelRegistration cr) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean configureMessageConverters(List<MessageConverter> list) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry mbr) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//  @Override
//  public void configureMessageBroker(MessageBrokerRegistry config) {
//    config.enableSimpleBroker("/queue", "/topic");
//    config.setApplicationDestinationPrefixes("/app");
//  }
//
//  @Override
//  public void registerStompEndpoints(StompEndpointRegistry registry) {
//    registry.addEndpoint("/chat", "/activeUsers").withSockJS();
//  }
//
//  @Override
//  public void configureClientInboundChannel(ChannelRegistration channelRegistration) {
//  }
//
//  @Override
//  public void configureClientOutboundChannel(ChannelRegistration channelRegistration) {
//  }
//
//  @Override
//  public boolean configureMessageConverters(List<MessageConverter> converters) {
//    return true;
//  }
//  
//  @Bean
//  public ActiveUserService activeUserService() {
//    return new ActiveUserService();
//  }
//
//    @Override
//    public void configureWebSocketTransport(WebSocketTransportRegistration wstr) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}