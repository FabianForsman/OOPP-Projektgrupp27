package com.example.hydrohomies;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HydroApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HydroApplication.class.getResource("base-layer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("HydroHomie");
        stage.setScene(scene);
        stage.show();*/
    }

    public static void main(String[] args) {
        System.out.println("Starting Program.");
        //launch();
    }

    public void onStartCardGameButtonClick(ActionEvent event) {
    }

    public void onStartDiceGameButtonClick(ActionEvent event) {
    }

    public void closeProgram(ActionEvent event) {
    }
}