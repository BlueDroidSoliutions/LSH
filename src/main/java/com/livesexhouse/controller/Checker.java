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
public class Checker {

    public boolean check(String search) {
        boolean b = false;
        if ((!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "admin"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "administrator"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "root"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "insert"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "@"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, ":="))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "="))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, ":"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "union"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "select"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "user"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "`"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "\""))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "$"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, ";"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "+"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "%"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "'"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "join"))) {
            b = true;
        }
        return b;
    }
    
    public boolean checkEmail(String search) {
        boolean b = false;
        if ((!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "admin"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "administrator"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "root"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "insert"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "@"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, ":="))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "="))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, ":"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "union"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "select"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "user"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "'"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "\""))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "$"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, ";"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "$"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "+"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "%"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "'"))
                && (!org.apache.commons.lang.StringUtils.containsIgnoreCase(search, "join"))) {
            b = true;
        }
        return b;
    }

    
    
    
    
    
    
}
