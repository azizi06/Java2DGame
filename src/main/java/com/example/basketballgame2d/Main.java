package com.example.basketballgame2d;

import com.example.basketballgame2d.Cerceau.Cerceau;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    private Parent creatContent(){
        return  null;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        stage.setTitle(Constants.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}