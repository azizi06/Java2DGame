package com.example.basketballgame2d.MouseHandler;

import com.example.basketballgame2d.Ball.Ball;
import com.example.basketballgame2d.Ball.ThrowBall;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseHandler implements EventHandler<MouseEvent>{
    Ball ball;
    public MouseHandler(Ball ball){
        this.ball = ball;
    }
    @Override
    public void handle(MouseEvent e) {
        ThrowBall throwBall = new ThrowBall();
        throwBall.execute(this.ball);
        System.out.println("curser at position  x : "+e.getX()+"y : "+e.getY());
    }



}
