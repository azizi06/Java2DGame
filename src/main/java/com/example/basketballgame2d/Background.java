package com.example.basketballgame2d;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


public class Background {
    public static StackPane createImageBackground(String imagePath, double width, double height) {
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        return new StackPane(imageView);
    }
}
