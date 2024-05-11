package com.example.basketballgame2d.Cerceau;

import com.example.basketballgame2d.Constants;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cerceau {
    private int positionX, positionY;
    public ImageView cerceauSprite;

    public Cerceau(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        // Load the image using a resource-relative path
        Image image = new Image(getClass().getResourceAsStream("/com/example/basketballgame2d/assets/hoop.png"));
        cerceauSprite = new ImageView(image);
        System.out.println("Cerceau created at position: " + positionX + ", " + positionY);
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void put_random_position() {
        this.positionX = (int) (Math.random() * Constants.WINDOW_WIDTH);
        this.positionY = (int) (Math.random() * Constants.WINDOW_HEIGHT);
    }
}
