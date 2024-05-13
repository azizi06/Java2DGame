package com.example.basketballgame2d;

import com.example.basketballgame2d.Ball.Ball;
import com.example.basketballgame2d.Cerceau.Cerceau;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class CollisionChecker {
    public static boolean checkCollision(Shape shape, Ball ball) {
        double distanceX = shape.getBoundsInLocal().getCenterX() - ball.getPositionX();
        double distanceY = shape.getBoundsInLocal().getCenterY() - ball.getPositionY();
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        double shapeRadius = Math.max(shape.getBoundsInLocal().getWidth(), shape.getBoundsInLocal().getHeight()) / 2;
        double ballRadius = Math.max(ball.getBallShape().getBoundsInLocal().getWidth(), ball.getBallShape().getBoundsInLocal().getHeight()) / 2;

        return distance <= shapeRadius + ballRadius;
    }

}
