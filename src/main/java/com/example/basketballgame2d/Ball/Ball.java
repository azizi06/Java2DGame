package com.example.basketballgame2d.Ball;

import com.example.basketballgame2d.Constants;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import javafx.scene.shape.*;
public class Ball {
    private  Double positionX = Double.parseDouble( Constants.WINDOW_WIDTH - 200+"");
    private Double positionY = Double.parseDouble(Constants.WINDOW_HEIGHT - 220+"");
  private ImageView ballSprite ;
  private Image img = new Image(getClass().getResourceAsStream("/com/example/basketballgame2d/assets/ball.png"));



   public Ball(){
       this.ballSprite = new ImageView(img);
       ballSprite.setX(getPositionX());
       ballSprite.setY(getPositionY());
       ballSprite.setFitHeight(Constants.BALL_HIEGHT);
       ballSprite.setFitWidth(Constants.BALL_WIDTH);

   }

    public ImageView getBallSprite() {
        return ballSprite;
    }
    public void TrowBall(Double x,Double y){
       // TranslateTransition translateTransition = new TranslateTransition();
       // translateTransition.setNode(ballSprite);
       // translateTransition.setByX(-x);
       // translateTransition.setByY(-y);
       // translateTransition.setCycleCount(1);
      //  translateTransition.play();
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(ballSprite);
        rotate.setDuration(Duration.millis(200));
        rotate.setCycleCount(2);
        rotate.play();

        PathTransition transition = new PathTransition();
        Arc arc = new Arc();
        arc.setCenterX(Constants.WINDOW_WIDTH - 200);
        arc.setCenterY(Constants.WINDOW_HEIGHT - 220);
        arc.setRadiusX(x-this.positionX);
        arc.setRadiusY(y-this.getPositionY());
        arc.setStartAngle(45.0f);
        arc.setTranslateX(100);
        arc.setTranslateY(100);
       // arc.setLength(10);

        Arc arc2 = new Arc(getPositionX(), getPositionY(), 100.0f, 100.0f, 0.0f, 100.0f);
        arc2.setTranslateX(100);
        arc2.setTranslateY(100);





        Path path = new Path();

        MoveTo moveTo = new MoveTo();
        moveTo.setX(getPositionX());
        moveTo.setY(getPositionY());

        ArcTo arcTo = new ArcTo();
        arcTo.setX(x-200);
        arcTo.setY(y-20);
        arcTo.setRadiusX(x-this.getPositionX());
        arcTo.setRadiusY(y);

        path.getElements().add(moveTo);
        path.getElements().add(arcTo);




        arc.setType(ArcType.ROUND);
        transition.setDuration(Duration.seconds(2));
        transition.setOrientation( PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition.setCycleCount(1);
        transition.setPath(path);

        transition.setNode(ballSprite);
        transition.play();

     //  this.ballSprite

    }
    public  void  CollisionWhithHoop(){

    }
    public Double getPositionX() {
        return positionX;
    }

    public Double getPositionY() {
        return  this.positionY;
    }
}
