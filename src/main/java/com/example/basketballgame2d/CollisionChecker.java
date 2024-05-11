package com.example.basketballgame2d;

import com.example.basketballgame2d.Ball.Ball;
import com.example.basketballgame2d.Cerceau.Cerceau;

public class CollisionChecker {
    static boolean checkCollision(Ball ball, Cerceau cerceau) {
        return ball.getPositionX() + ball.getBallSprite().getFitWidth() >= cerceau.getPositionX() &&
                ball.getPositionX() <= cerceau.getPositionX() + cerceau.getCerceauSprite().getFitWidth() &&
                ball.getPositionY() + ball.getBallSprite().getFitHeight() >= cerceau.getPositionY() &&
                ball.getPositionY() <= cerceau.getPositionY() + cerceau.getCerceauSprite().getFitHeight();
    }

}
