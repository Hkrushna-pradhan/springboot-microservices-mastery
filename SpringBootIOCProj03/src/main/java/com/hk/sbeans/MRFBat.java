package com.hk.sbeans;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component("mrfBat")
public class MRFBat implements  ICricketBat{

    public MRFBat(){
        System.out.println("MRFBat:: 0 param Constructor");
    }

    @Override
    public int scoreRuns() {
        System.out.println("MRFBat.scoreRuns()");
        return new Random().nextInt(250);
    }
}
