package com.example.basketballgame2d.Cerceau;

import com.example.basketballgame2d.Constants;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

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
        Random random = new Random();
        this.setPositionY(random.nextInt(Constants.WINDOW_HEIGHT  /3));
        this.setPositionX(random.nextInt(Constants.WINDOW_WIDTH - 250));
        System.out.println("Cerceau moved to position: " + positionX + ", " + positionY);
    }


    public ImageView getCerceauSprite() {
        return cerceauSprite;
    }
}
