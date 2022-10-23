package com.example.hydrohomies;

import Controllers.Treman.TremanController;
import Controllers.GameChooseController;
import Model.Player.IPlayer;
import Model.Player.Players;
import View.TremanView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;


public class UIController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Players playerlist;

    @FXML private Button startGameButton;
    @FXML private Label  chooseGameLabel;
    @FXML private AnchorPane rootAnchorPane;

    private TremanController tremanController;
    private TremanView tremanView;
    @FXML private GameChooseController gameChoose;

    @FXML private void openChooseGame( ActionEvent action) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("Treman.fxml")));
        stage = (Stage) ((Node)action.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //tremanController = new TremanController();
        //tremanView = new TremanView(this, tremanController);
    }



}
