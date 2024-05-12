package com.example.basketballgame2d.MouseHandler;

import com.example.basketballgame2d.Ball.Ball;
import com.example.basketballgame2d.Ball.ThrowBall;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MouseHandler implements EventHandler<MouseEvent>{
    Ball ball;
    Circle circle;
    public MouseHandler(Ball ball, Circle circle){
        this.circle = circle;
        this.ball = ball;
    }
    @Override
    public void handle(MouseEvent e) {
        ThrowBall throwBall = new ThrowBall();
        throwBall.execute(this.ball,e.getX(),e.getY());

        KeyValue keyValue = new KeyValue(circle.translateXProperty(), 200);

        // over the course of 5 seconds
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), keyValue);
        Timeline timeline = new Timeline(keyFrame);
        timeline.play();
        System.out.println("curser at position  x : "+e.getX()+"y : "+e.getY());
    }



}
