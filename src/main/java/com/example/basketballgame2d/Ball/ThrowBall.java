package com.example.basketballgame2d.Ball;

public class ThrowBall {
    public  void execute(Ball ball,Double x,Double y){
        try {
            ball.TrowBall(x,y);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
