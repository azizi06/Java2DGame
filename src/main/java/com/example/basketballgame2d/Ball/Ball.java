package com.example.basketballgame2d.Ball;

import com.example.basketballgame2d.Constants;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ball {
    private  int positionX,getPositionY;
  private ImageView ballSprite ;
  private Image img = new Image(getClass().getResourceAsStream("/com/example/basketballgame2d/assets/ball.png"));



   public Ball(){
       this.ballSprite = new ImageView(img);
       ballSprite.setX(Constants.WINDOW_WIDTH - 200);
       ballSprite.setY(Constants.WINDOW_HEIGHT - 220 );
       ballSprite.setFitHeight(Constants.BALL_HIEGHT);
       ballSprite.setFitWidth(Constants.BALL_WIDTH);

   }

    public ImageView getBallSprite() {
        return ballSprite;
    }
    public void TrowBall(Double x,Double y){
     //  this.ballSprite

    }
}
