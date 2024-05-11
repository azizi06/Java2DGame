package com.example.basketballgame2d;

public interface CollisionChecker {
    public default void checkCollisions(){
        System.out.println("Collision Checker Class");
    }
}
