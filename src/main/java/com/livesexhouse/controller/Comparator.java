/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.controller;

import com.livesexhouse.model.VideoCategories;
import com.livesexhouse.model.VideoCategoryCountClip;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author roller
 */
public class Comparator {

    public List<VideoCategoryCountClip> sort(List<VideoCategoryCountClip> list) {

        Collections.sort(list, new java.util.Comparator<VideoCategoryCountClip>() {
            @Override
            public int compare(VideoCategoryCountClip v1, VideoCategoryCountClip v2) {
                return v1.getName().compareTo(v2.getName());
            }
        });

        return list;
    }

    public List<VideoCategories> sortCategory(List<VideoCategories> list) {

        Collections.sort(list, new java.util.Comparator<VideoCategories>() {
            @Override
            public int compare(VideoCategories v1, VideoCategories v2) {
                return v1.getName().compareTo(v2.getName());
            }
        });

        return list;
    }

}
