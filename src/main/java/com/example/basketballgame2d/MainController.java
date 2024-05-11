package com.example.basketballgame2d;

import com.example.basketballgame2d.Ball.Ball;
import com.example.basketballgame2d.Cerceau.Cerceau;
import com.example.basketballgame2d.MouseHandler.MouseHandler;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;


// Initializable is an interface that is called when the controller is initialized.
public class MainController implements Initializable {

    public Ball ball;
    public Cerceau cerceau;
    public MouseHandler mouseHandler;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ball = new Ball();
        cerceau = new Cerceau(Constants.CERCEAU_INIT_X, Constants.CERCEAU_INIT_Y);

    }


}