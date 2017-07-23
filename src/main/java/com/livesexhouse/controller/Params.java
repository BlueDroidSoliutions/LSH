/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.controller;

import com.livesexhouse.model.MemberHouse;
import com.livesexhouse.model.VideoCategories;
import com.livesexhouse.model.VideoRoom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author roller
 */
public class Params {
    
    
    
    
    public Object[] allParam(int[] categoryFilter, int[] roomFilter, int[] memberFilter, int[] seasonFilter, int[] durationFilter, int sort, String date, int numbOfSeason,List<MemberHouse> memberHouse,List<VideoRoom> videoRoom, List<VideoCategories> videoCategories){
       String params = "";
       
            for (int i = 0; i < categoryFilter.length; i++) {
                if (categoryFilter[i] != 0) {
                    params = params + 8 + "=" + categoryFilter[i] + "&&";
                }
            }

            for (int i = 0; i < roomFilter.length; i++) {
                if (roomFilter[i] != 0) {
                    params = params + 4 + "=" + roomFilter[i] + "&&";
                }
            }

            for (int i = 0; i < memberFilter.length; i++) {
                if (memberFilter[i] != 0) {
                    params = params + 7 + "=" + memberFilter[i] + "&&";
                }
            }

            for (int i = 0; i < seasonFilter.length; i++) {
                if (seasonFilter[i] != 0) {
                    params = params + 5 + "=" + seasonFilter[i] + "&&";
                }
            }

            for (int i = 0; i < durationFilter.length; i++) {
                if (durationFilter[i] != 0) {
                    params = params + 6 + "=" + durationFilter[i] + "&&";
                }
            }
            String paramsWithoutSort = "&&"+params + "3=" + date;
            params = "&&"+params + 2 + "=" + sort + "&&3=" + date;
            
        
        List<String> individualPar = new ArrayList<>();
        
        
        String test = params + "&&";
        String[] parts = test.subSequence(2, test.length()).toString().split("&&");
        for(String s : parts){
            
            if(s.charAt(0) == '8'){
                for(VideoCategories vc : videoCategories){
                    if(vc.getId().equals(Integer.valueOf(s.substring(2, s.length())))){
                        individualPar.add(vc.getName()+","+params.replace(s+"&&","").substring(2));
                    }
                }
            }
            
            if(s.charAt(0) == '4'){
                for(VideoRoom vr : videoRoom){
                    if(vr.getId().equals(Integer.valueOf(s.substring(2, s.length())))){
                        individualPar.add(vr.getName()+","+params.replace(s+"&&","").substring(2));
                    }
                }
            }

            if(s.charAt(0) == '7'){
                for(MemberHouse mh : memberHouse){
                    if(mh.getId().equals(Integer.valueOf(s.substring(2, s.length())))){
                        individualPar.add(mh.getName()+","+params.replace(s+"&&","").substring(2));
                    }
                }
            }
       
            
            if(s.charAt(0) == '5'){
               for (int i = 0; i < seasonFilter.length; i++) {
                        individualPar.add("Season "+(i+1)+","+params.replace(s+"&&","").substring(2));
                }
            }
            
            if(s.charAt(0) == '6'){
               for (int i = 0; i < durationFilter.length; i++) {
                   
                        if(Integer.valueOf(s.substring(2, s.length())) == 1){
                            individualPar.add("Less than 5 min"+","+params.replace(s+"&&","").substring(2));
                        }
                        
                        if(Integer.valueOf(s.substring(2, s.length())) == 2){
                            individualPar.add("5 min to 15 min"+","+params.replace(s+"&&","").substring(2));
                        }
                        
                        if(Integer.valueOf(s.substring(2, s.length())) == 3){
                            individualPar.add("15 min to 30 min"+","+params.replace(s+"&&","").substring(2));
                        }
                        
                        if(Integer.valueOf(s.substring(2, s.length())) == 4){
                            individualPar.add("More than 30 min"+","+params.replace(s+"&&","").substring(2));
                        }
                   
                        
                }
            }
            
            
        }
        
        
       
        
        return new Object[]{params,paramsWithoutSort,individualPar};
    }
    
    
    
    
    
    
}
