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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author roller
 */
public class Params {

    public Object[] allParam(int[] categoryFilter, int[] roomFilter, int[] memberFilter, int[] seasonFilter, int[] durationFilter, int sort, String date, int numbOfSeason, List<MemberHouse> memberHouse, List<VideoRoom> videoRoom, List<VideoCategories> videoCategories, int maxSeason, String search) {
        String params = "";

        for (int i = 0; i < categoryFilter.length; i++) {
            if (categoryFilter[i] != 0) {
                params = params + 8 + "=" + categoryFilter[i] + "&&";
            }
        }

        for (int i = 0; i < memberFilter.length; i++) {
            if (memberFilter[i] != 0) {
                params = params + 7 + "=" + memberFilter[i] + "&&";
            }
        }

        for (int i = 0; i < roomFilter.length; i++) {
            if (roomFilter[i] != 0) {
                params = params + 4 + "=" + roomFilter[i] + "&&";
            }
        }

        if (!search.equals("0")) {
            params = params + 10 + "=" + search + "&&";
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
        String paramsWithoutSort = "";

        if (date.length() > 3) {
            paramsWithoutSort = "&&" + params + "3=" + date;
            params = "&&" + params + 2 + "=" + sort + "&&3=" + date;
        } else {
            paramsWithoutSort = "&&" + params;
            params = "&&" + params + 2 + "=" + sort;
        }

        List<String> individualPar = new ArrayList<>();

        String test = params + "&&";
        String[] parts = test.subSequence(2, test.length()).toString().split("&&");

        for (String s : parts) {

            //date
            if (s.charAt(0) == '3') {
                if (s.substring(2, s.length()).length() > 3) {
                    individualPar.add(date + "," + params.replace("&&" + s, "").substring(2));
                }
            }

            //category
            if (s.charAt(0) == '8') {
                for (VideoCategories vc : videoCategories) {
                    if (vc.getId().equals(Integer.valueOf(s.substring(2, s.length())))) {
                        System.out.println("s: " + s);
                        individualPar.add(vc.getName() + "," + params.replace(s + "&&", "").substring(2));
                    }
                }
            }

            //room
            if (s.charAt(0) == '4') {
                for (VideoRoom vr : videoRoom) {
                    if (vr.getId().equals(Integer.valueOf(s.substring(2, s.length())))) {
                        individualPar.add(vr.getName() + "," + params.replace(s + "&&", "").substring(2));
                    }
                }
            }

            //member
            if (s.charAt(0) == '7') {
                for (MemberHouse mh : memberHouse) {
                    if (mh.getId().equals(Integer.valueOf(s.substring(2, s.length())))) {
                        individualPar.add(mh.getName() + "," + params.replace(s + "&&", "").substring(2));
                    }
                }
            }

            //season
            if (s.charAt(0) == '5') {
                for (int i = 0; i < seasonFilter.length; i++) {
                    for (int in = 1; in <= maxSeason; in++) {
                        if (in == Integer.valueOf(s.substring(2, s.length()))) {
                            individualPar.add("Season " + in + "," + params.replace(s + "&&", "").substring(2));
                            System.out.println("FF " + "Season " + in + "," + params.replace(s + "&&", "").substring(2));
                        }
                    }
                }
            }

            //search
            if (s.charAt(0) == '1' && s.charAt(1) == '0' && s.charAt(3) != '0') {
                String sear = "";
                sear = s.subSequence(0, s.length() - 1).toString();
                individualPar.add("Search: " + search.replace('-', ' ') + "," + params.replace(s + "&&", "").substring(2));
            }

            //duration
            if (s.charAt(0) == '6') {
                for (int i = 0; i < durationFilter.length; i++) {
                    for (int in = 1; in <= maxSeason; in++) {
                        if (Integer.valueOf(s.substring(2, s.length())) == 1) {
                            individualPar.add("Less than 5 min" + "," + params.replace(s + "&&", "").substring(2));
                        }

                        if (Integer.valueOf(s.substring(2, s.length())) == 2) {
                            individualPar.add("5 min to 15 min" + "," + params.replace(s + "&&", "").substring(2));
                        }

                        if (Integer.valueOf(s.substring(2, s.length())) == 3) {
                            individualPar.add("15 min to 30 min" + "," + params.replace(s + "&&", "").substring(2));
                        }

                        if (Integer.valueOf(s.substring(2, s.length())) == 4) {
                            individualPar.add("More than 30 min" + "," + params.replace(s + "&&", "").substring(2));
                        }
                    }

                }
            }

        }

        Set<String> hs2 = new HashSet<>();
        hs2.addAll(individualPar);
        individualPar.clear();
        individualPar.addAll(hs2);

//        System.out.println("params "+params);
//        System.out.println("paramsWithoutSort "+paramsWithoutSort);
//        
//        for(String g : individualPar)
//            System.out.println(g);
        return new Object[]{params, paramsWithoutSort, individualPar};
    }

}
