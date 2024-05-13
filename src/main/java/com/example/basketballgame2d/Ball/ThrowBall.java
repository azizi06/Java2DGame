package com.example.basketballgame2d.Ball;

import com.example.basketballgame2d.Constants;

public class ThrowBall {
    public  void execute(Ball ball,Double x,Double y){
        try {
            if(x< Constants.Ball_int_PositionX-190){
            ball.TrowBall(x,y);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
