package com.hk.sbeans;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component("ssBat")
public class SSBat implements  ICricketBat{

    public SSBat(){
        System.out.println("SSBat:: 0 param Constructor");
    }

    @Override
    public int scoreRuns() {
        System.out.println("SSBat.scoreRuns()");
        return new Random().nextInt(250);
    }
}