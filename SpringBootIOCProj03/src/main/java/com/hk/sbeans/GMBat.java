package com.hk.sbeans;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component("gmBat")
public class GMBat implements  ICricketBat{


    public GMBat(){
        System.out.println("GMBat:: 0 param Constructor");
    }

    @Override
    public int scoreRuns() {
        System.out.println("GMBat.scoreRuns()");
        return new Random().nextInt(250);
    }
}
