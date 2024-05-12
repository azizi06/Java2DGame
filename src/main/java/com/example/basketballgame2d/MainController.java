package com.example.basketballgame2d;

import com.example.basketballgame2d.Ball.Ball;
import com.example.basketballgame2d.Cerceau.Cerceau;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private boolean running = false;
    private long lastUpdateTime;

    @FXML
    AnchorPane anchorPane;
    public Ball ball;
    public Cerceau cerceau;
    public ScoreAnimation scoreAnimation;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ball = new Ball();
        cerceau = new Cerceau(Constants.CERCEAU_INIT_X, Constants.CERCEAU_INIT_Y);
        scoreAnimation = new ScoreAnimation(cerceau);
        System.out.println("In Game Loop");

        startGameLoop();
    }

    private void startGameLoop() {
        running = true;
        lastUpdateTime = System.nanoTime();

        Thread gameThread = new Thread(() -> {
            while (running) {
                long now = System.nanoTime();
                long elapsedTime = now - lastUpdateTime;
                lastUpdateTime = now;

                update(elapsedTime);

                Platform.runLater(this::render);

                try {
                    Thread.sleep(10); // For FrameRate
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        gameThread.start();
    }

    private void update(long elapsedTime) {
        if(CollisionChecker.checkCollision(ball, cerceau)) {
            goesThrough(null); // Za3ma marka donc position t3 cerceau ttbdel
        }
    }

    private void render() {

        displayBall();
        displayCerceau();
    }

    public void stop() {
        running = false;
    }

    public void randomCerceau() {
        winAnimation();

        cerceau.put_random_position();
        cerceau.getCerceauSprite().setX(cerceau.getPositionX());
        cerceau.getCerceauSprite().setY(cerceau.getPositionY());
    }

    public void displayCerceau() {
        Platform.runLater(() -> {
            anchorPane.getChildren().remove(cerceau.getCerceauSprite());
            anchorPane.getChildren().add(cerceau.getCerceauSprite());
        });
    }

    public void goesThrough(MouseEvent event) { // Use when the ball goes through the cerceau

        winAnimation();

        cerceau.put_random_position();
        cerceau.getCerceauSprite().setX(cerceau.getPositionX());
        cerceau.getCerceauSprite().setY(cerceau.getPositionY());
    }

    public void displayBall() {
        Platform.runLater(() -> {
            anchorPane.getChildren().remove(ball.getBallSprite());
            anchorPane.getChildren().add(ball.getBallSprite());
        });
    }

    public void winAnimation(){
        scoreAnimation.score();
        Platform.runLater(() -> {
            anchorPane.getChildren().remove(scoreAnimation.scoreSprite);
            anchorPane.getChildren().add(scoreAnimation.scoreSprite);
        });
    }
}
