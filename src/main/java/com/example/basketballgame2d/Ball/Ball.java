package com.example.basketballgame2d.Ball;

import com.example.basketballgame2d.Constants;
import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
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
    public void TrowBall(Double x,Double y) throws InterruptedException {
        Timeline timeline = new Timeline();

        RotateTransition rotate = new RotateTransition();
        rotate.setNode(ballSprite);
        rotate.setDuration(Duration.millis(2000));
        rotate.setByAngle(-380);
        rotate.setAutoReverse(false);

      //  rotate.setFromAngle(360);
        rotate.setAxis(Rotate.Z_AXIS);


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
        arcTo.setRadiusX(Math.abs(500));
        arcTo.setRadiusY(200);
        arcTo.setXAxisRotation(10);
        arcTo.setSweepFlag(false);





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
        //transition.play();
       // rotate.play();
        SequentialTransition sq = new SequentialTransition(ballSprite,rotate,transition);
        ParallelTransition pr = new ParallelTransition();
        pr.setCycleCount(1);
        pr.getChildren().addAll(transition,rotate);
        pr.play();

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
