package com.example.basketballgame2d;

import com.example.basketballgame2d.Ball.Ball;
import com.example.basketballgame2d.Cerceau.Cerceau;
import com.example.basketballgame2d.MouseHandler.MouseHandler;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private boolean running = false;
    private long lastUpdateTime;

    @FXML
    AnchorPane anchorPane;
    @FXML
    Line line;
    @FXML
    private Circle collisionCircle;

    public Ball ball;
    public Circle circle = new Circle(50, 150, 50, Color.RED);



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
        render();
        if(CollisionChecker.checkCollision(circle, ball)) {
            System.out.println("Collision detected");

        }


    }

    private void render() {


        displayCerceau();
        displayBall();

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

    private void updateLinePosition() {
        line.setEndX(cerceau.getPositionX());
        line.setEndY(cerceau.getPositionY());
        line.setStartX(cerceau.getPositionX() + 30);
        line.setStartX(cerceau.getPositionY());

    }

    public void displayCerceau() {
        Platform.runLater(() -> {
            collisionCircle.setCenterX(cerceau.getPositionX() - 250);
            collisionCircle.setCenterY(cerceau.getPositionY() - 100);
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
          //  anchorPane.getChildren().add(circle);
        });
    }

    public void winAnimation(){
        scoreAnimation.score();
        Platform.runLater(() -> {
            anchorPane.getChildren().remove(scoreAnimation.scoreSprite);
            anchorPane.getChildren().add(scoreAnimation.scoreSprite);
        });
    }
    public  void eventHandler(MouseEvent e){
        MouseHandler mouse = new MouseHandler(ball,circle);
        mouse.handle(e);


    }
}
