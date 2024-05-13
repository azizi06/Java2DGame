package com.example.basketballgame2d;

import com.example.basketballgame2d.Ball.Ball;
import com.example.basketballgame2d.Cerceau.Cerceau;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class CollisionChecker {
    public static boolean checkCollision(Circle circle, Ball ball) {
        // Calculate the distance between the centers of the circle and the ball
        double distanceX = circle.getCenterX() - ball.getPositionX();
        double distanceY = circle.getCenterY() - ball.getPositionY();
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        // Check if the distance is less than the sum of the radii
        return distance < circle.getRadius() + Constants.BALL_HIEGHT / 2;
    }

}
