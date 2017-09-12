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
public class Redirect {

    public String re(String s) {

        int sleshAfterWww = s.indexOf("/", s.indexOf("www"));

        String r = "";

        if (sleshAfterWww == -1) {
            r = "redirect:index";
        } else if (sleshAfterWww == s.length() - 1) {
            r = "redirect:index";
        } else {
            r = "redirect:" + s.substring(s.indexOf(".com") + 5, s.length());
        }

        return r;

    }

}
