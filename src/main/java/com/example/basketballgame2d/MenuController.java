package com.example.basketballgame2d;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MenuController implements Initializable {

    @FXML
    AnchorPane anchorPane;
    @FXML
    Button startButton;
    @FXML
    Button settingsButton;



    public void say_hi() {
        Main.startGame();
    }

    @java.lang.Override
    public void initialize(java.net.URL url, java.util.ResourceBundle resourceBundle) {

    }
}
