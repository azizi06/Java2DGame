package com.example.basketballgame2d;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static FXMLLoader MenufxmlLoader = new FXMLLoader(Main.class.getResource("Menu.fxml"));
    private static FXMLLoader GamefxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
    private static Stage menuStage;

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(MenufxmlLoader.load(), Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        stage.setTitle(Constants.WINDOW_TITLE);
        stage.setScene(scene);
        menuStage = stage;
        stage.show();
    }

    public static void startGame() {
        try {
            menuStage.close();

            // Open the game stage

            Stage stage = new Stage();
            Scene scene = new Scene(GamefxmlLoader.load(), Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
            stage.setTitle(Constants.WINDOW_TITLE);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
