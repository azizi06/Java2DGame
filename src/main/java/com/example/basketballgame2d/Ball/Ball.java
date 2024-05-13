package com.example.basketballgame2d.Ball;

import com.example.basketballgame2d.Constants;
import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import javafx.scene.shape.*;
public class Ball {

    private  Double positionX = Constants.Ball_int_PositionX;
    private Double positionY = Constants.Ball_int_PositionY;
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



    public void MoveRight(){
       ballSprite.setX(ballSprite.getX()+2);
    }
    public  void  TrowBall2(Double x,Double y){

    }



    public Shape getBallShape(){
        Circle circle = new Circle();
        circle.setCenterX(getPositionX());
        circle.setCenterY(getPositionY());
        circle.setRadius(Constants.BALL_HIEGHT / 2);
        return circle;
    }
    public void TrowBall(Double x,Double y){

        Timeline timeline = new Timeline();

        RotateTransition rotate = new RotateTransition();
        rotate.setNode(ballSprite);
        rotate.setDuration(Duration.millis(200));



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

        Path path = new Path();

        MoveTo moveTo = new MoveTo();
        moveTo.setX(getPositionX());
        moveTo.setY(getPositionY());

        ArcTo arcTo = new ArcTo();
        arcTo.setX(x-Constants.Ball_Shoot_Xvaraition);
        arcTo.setY(y-Constants.Ball_Shoot_Yvaraition);

        arcTo.setRadiusX(Math.abs(x-Constants.Ball_int_PositionX));
        arcTo.setRadiusY(y);
        arcTo.setXAxisRotation(25);
        arcTo.setSweepFlag(false);


        arcTo.setRadiusX(x-this.getPositionX());
        arcTo.setRadiusY(y);





        path.getElements().add(moveTo);
        path.getElements().add(arcTo);
        path.getElements().add(new VLineTo(Constants.WINDOW_HEIGHT));
     //   path.getElements().add(arcTo);







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

    public Double getPositionY(){
        return  this.positionY;
    }
}

