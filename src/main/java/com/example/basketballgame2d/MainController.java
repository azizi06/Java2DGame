package com.example.basketballgame2d;

import com.example.basketballgame2d.Ball.Ball;
import com.example.basketballgame2d.Cerceau.Cerceau;
import com.example.basketballgame2d.MouseHandler.MouseHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


// Initializable is an interface that is called when the controller is initialized.
public class MainController implements Initializable {
    @FXML
    AnchorPane anchorPane;


    public Ball ball;
    public Cerceau cerceau;
    public MouseHandler mouseHandler;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*                      Ball                      */

        ball = new Ball();
        displayBall();

        /*                      Cerceau                      */


        cerceau = new Cerceau(Constants.CERCEAU_INIT_X, Constants.CERCEAU_INIT_Y);
        displayCerceau(null);


    }


    public void displayCerceau(MouseEvent event){
        anchorPane.getChildren().remove(cerceau.cerceauSprite);
        anchorPane.getChildren().add(cerceau.cerceauSprite);
        changeCerceauPosition();
    }


    public void changeCerceauPosition(){ // Use when the ball goes through the cerceau
        cerceau.put_random_position();
        cerceau.cerceauSprite.setX(cerceau.getPositionX());
        cerceau.cerceauSprite.setY(cerceau.getPositionY());
    }


    public  void  displayBall(){
        anchorPane.getChildren().add(ball.getBallSprite());
    }

}