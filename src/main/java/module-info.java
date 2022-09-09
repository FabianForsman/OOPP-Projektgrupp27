module com.example.hydrohomies {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hydrohomies to javafx.fxml;
    exports com.example.hydrohomies;
}