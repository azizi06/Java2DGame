module com.example.basketballgame2d {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.basketballgame2d to javafx.fxml;
    exports com.example.basketballgame2d;
}