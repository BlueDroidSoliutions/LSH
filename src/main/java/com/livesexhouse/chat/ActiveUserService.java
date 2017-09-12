//package com.livesexhouse.chat;
//
//import java.util.Set;
//import java.util.concurrent.atomic.AtomicLong;
//
//import com.google.common.cache.CacheBuilder;
//import com.google.common.cache.CacheLoader;
//import com.google.common.cache.LoadingCache;
//import com.google.common.collect.Sets;
//import java.util.HashSet;
//import javax.persistence.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//
//public class ActiveUserService {
//    
// @Autowired
//    SessionFactory sessionFactory;
//  
//// Session session = sessionFactory.openSession();
// 
// 
//  private final LoadingCache<String, UserStats> statsByUser = CacheBuilder.newBuilder().build(new CacheLoader<String, UserStats>() {
//     
//
//    @Override
//    public UserStats load(String key) throws Exception {
//      return new UserStats();
//    }
//   
//    
//    
//  });
//  
////  private final Session session = sessionFactory.openSession();
//  
//  
//  
////  private final Query query = sessionFactory.getCurrentSession().getNamedQuery("Users.findByEnabled2");
////  private final Set<String> mm = new HashSet<String>();
//  
//  
//  
//  // public ActiveUserService(){
//      
//  // }
//  
//  
//  
//  public void mark(String username) {
//      statsByUser.getUnchecked(username).mark();
//      
//      
//  }
//  
//  public Set<String> getActiveUsers() {
////      System.out.println(sessionFactory);
//      
//      
//      
//     
//      
//    Set<String> active = Sets.newTreeSet();
//      
//    for (String user : statsByUser.asMap().keySet()) {
//      // has the user checked in within the last 5000 seconds?
//      
//      
//            
//            
//                  
//      if ((System.currentTimeMillis() - statsByUser.getUnchecked(user).lastAccess()) < 500000) {
//          
//          if(user.contains("ggg"))
//        active.add(user);
//        
//      }
//    }
//   
////    Set<String> mm = (Set<String>) query.getResultList();
//    
//    
//    return active;
//  }
//  
// 
//  
//  
//  private static class UserStats {
//    
//    private AtomicLong lastAccess = new AtomicLong(System.currentTimeMillis());
//    
//    private void mark() {
//      lastAccess.set(System.currentTimeMillis());
//    }
//    
//    private long lastAccess() {
//      return lastAccess.get();
//    }
//    
//  }
//  
//  
// 
//  
//  
//
//}
