package com.livesexhouse.controller;

import java.security.SecureRandom;
import java.math.BigInteger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class NameGenerator {

    @Autowired
    SessionFactory sessionFactory;

    private SecureRandom random = new SecureRandom();

    public String nextKey() {
        return new BigInteger(512, random).toString(32);
    }

    public String nextBigKey() {
        return new BigInteger(512, random).toString(64);
    }

}
