package com.hk.sbeans;


import org.springframework.stereotype.Component;

import java.util.Random;

@Component("dukeBall")
public final class DukeBall implements ICricketBall {

    public DukeBall() {
        System.out.println("DukeBall:: 0-param constructor");
    }

    @Override
    public String bowling() {
        System.out.println("DukeBall.bowling()");
        return new Random().nextInt(11)+"-"+new Random().nextInt(5)+"-"+new Random().nextInt(11);
    }
}
