package com.example.basketballgame2d;

import com.example.basketballgame2d.Ball.Ball;
import com.example.basketballgame2d.Cerceau.Cerceau;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class CollisionChecker {
    public static boolean checkCollision(Circle circle, Ball ball) {
        double distanceX = circle.getCenterX() - ball.getPositionX();
        double distanceY = circle.getCenterY() - ball.getPositionY();
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        return distance < circle.getRadius() + Constants.BALL_HIEGHT / 2;
    }

    public static boolean checkCollision(Shape shape, Ball ball) {
        double distanceX = shape.getBoundsInLocal().getCenterX() - ball.getPositionX();
        double distanceY = shape.getBoundsInLocal().getCenterY() - ball.getPositionY();
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        return distanceX == 0 && distanceY == 0;
    }

}
