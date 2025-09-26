package com.hk.sbeans;


import org.springframework.stereotype.Component;

import java.util.Random;

@Component("obBall")
public final class OxBrigeBall implements ICricketBall {

    public OxBrigeBall() {
        System.out.println("OxBrigeBall:: 0-param constructor");
    }

    @Override
    public String bowling() {
        System.out.println("OxBrigeBall.bowling()");
        return new Random().nextInt(11)+"-"+new Random().nextInt(5)+"-"+new Random().nextInt(11);
    }
}
