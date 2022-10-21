package com.example.hydrohomies;

import View.*;
import Controllers.Treman.TremanController;
import View.GameChoose;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;



public class UIController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    // public HigherLowerController higherLowerController = new HigherLowerController(this);
    // public FTheDealerController fTheDealerController = new FTheDealerController(this);
    // public OpusController opusController = new OpusController(this);

    @FXML private Button startGameButton;
    @FXML private Label  chooseGameLabel;
    @FXML private AnchorPane rootAnchorPane;

    @FXML private TremanController tremanController;
    @FXML private GameChoose gameChoose;

    @FXML private void openChooseGame(@NotNull ActionEvent action) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Treman.fxml"));
        stage = (Stage) ((Node)action.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}
