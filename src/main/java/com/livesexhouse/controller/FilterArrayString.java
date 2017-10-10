/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.controller;

/**
 *
 * @author roller
 */
public class FilterArrayString {

    public String arr2str(int[] in, Integer numb) {
        StringBuilder sb = new StringBuilder();
        try {

            for (int i = 0; i < in.length; i++) {

                sb.append(numb.toString());
                sb.append("=");
                sb.append(in[i]);
                if (i + 1 != in.length) {
                    sb.append("&&");
                }

            }
        } catch (Exception e) {

        }

        return sb.toString();
    }

}
