package com.hk.sbeans;


import org.springframework.stereotype.Component;

import java.util.Random;

@Component("ssBall")
public final class SSBall implements ICricketBall {

    public SSBall() {
        System.out.println("SSBall:: 0-param constructor");
    }

    @Override
    public String bowling() {
        System.out.println("SSBall.bowling()");
        return new Random().nextInt(11)+"-"+new Random().nextInt(5)+"-"+new Random().nextInt(11);
    }
}
