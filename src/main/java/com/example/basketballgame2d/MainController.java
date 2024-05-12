package com.example.basketballgame2d;

import com.example.basketballgame2d.Ball.Ball;
import com.example.basketballgame2d.Cerceau.Cerceau;
import com.example.basketballgame2d.MouseHandler.MouseHandler;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ball = new Ball();
        cerceau = new Cerceau(Constants.CERCEAU_INIT_X, Constants.CERCEAU_INIT_Y);
     //   anchorPane.addEventHandler(new MouseHandler(ball));

    anchorPane.addEventHandler(new EventType<MouseEvent>(),new MouseHandler(ball));
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
               // System.out.println("In Game Loop");

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
            goesThrough(null);
        }
    }

    private void render() {

        displayBall();
        displayCerceau();
    }

    public void stop() {
        running = false;
    }

    public void displayCerceau() {
        Platform.runLater(() -> {
            anchorPane.getChildren().remove(cerceau.getCerceauSprite());
            anchorPane.getChildren().add(cerceau.getCerceauSprite());
        });
    }

    public void goesThrough(MouseEvent event) { // Use when the ball goes through the cerceau
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
    @FXML
    private  void eventHandler(MouseEvent e){
         MouseHandler mouse = new MouseHandler(ball);
         mouse.handle(e);

    }
}
