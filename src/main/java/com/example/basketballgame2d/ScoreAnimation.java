package com.example.basketballgame2d;

import com.example.basketballgame2d.Cerceau.Cerceau;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ScoreAnimation {


    @FXML
    Image scoreImage = new Image(getClass().getResourceAsStream("/com/example/basketballgame2d/assets/TrickShot.png"));
//    @FXML
//    ImageView scoreSprite;

    @FXML
    Text scoreSprite; // Needs to be changed


    Cerceau cerceau;
    public ScoreAnimation(Cerceau cerceau){
//        scoreSprite = new ImageView(scoreImage);
        scoreSprite = new Text("Trick Shot");
        this.cerceau = cerceau;
    }
    public void score() { // Le message s'affiche quand le ballon passe à travers le cerceau a la position du cerceau (manquera que l'animation)
        scoreSprite.setX(cerceau.getPositionX());
        scoreSprite.setY(cerceau.getPositionY());
    }
}
