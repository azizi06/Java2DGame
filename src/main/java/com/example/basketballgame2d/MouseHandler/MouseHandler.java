package com.example.basketballgame2d.MouseHandler;

import com.example.basketballgame2d.Ball.Ball;
import com.example.basketballgame2d.Ball.ThrowBall;
import javafx.event.Event;
import javafx.event.EventHandler;

public class MouseHandler implements EventHandler {
    Ball ball;
    MouseHandler(Ball ball){
        this.ball = ball;
    }
    @Override
    public void handle(Event event) {
        ThrowBall throwBall = new ThrowBall();
        throwBall.execute(this.ball);
    }



}
