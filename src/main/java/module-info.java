module com.example.hydrohomies {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hydrohomies to javafx.fxml;
    exports com.example.hydrohomies;
    exports Model.Player;
    opens Model.Player to javafx.fxml;
    exports Model.Game;
}