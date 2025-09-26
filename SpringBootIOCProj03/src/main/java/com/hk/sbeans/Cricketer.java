package com.hk.sbeans;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("cktr")
public class Cricketer {

    @Autowired
    @Qualifier("bat")
    private ICricketBat bat;

    @Autowired
    @Qualifier("ball")
    private ICricketBall ball;

    public Cricketer() {
        System.out.println("Cricketer :: 0 param Constructor");
    }

    public String batting(String name){
        //use dependent
        int score = bat.scoreRuns();
        return  name +"Batsman score is ::"+ score;
    }

    public String bowlingInfo(String name){
        //use dependent
        String bolwingScore = ball.bowling();
        return name +" Bowler statics are ::"+ bolwingScore;
    }


}
