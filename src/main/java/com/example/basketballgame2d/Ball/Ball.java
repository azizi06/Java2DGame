package com.example.basketballgame2d.Ball;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ball {
    private  int positionX,getPositionY;
  private ImageView ballSprite ;
  private Image img = new Image(getClass().getResourceAsStream("/com/example/basketballgame2d/assets/ball.png"));


   public Ball(){
       this.ballSprite = new ImageView(img);
       ballSprite.setX(100);
       ballSprite.setY(100);

   }

    public ImageView getBallSprite() {
        return ballSprite;
    }
}
