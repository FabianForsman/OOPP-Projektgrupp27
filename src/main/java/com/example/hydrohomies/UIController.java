package com.example.hydrohomies;

import Controllers.FTheDealer.FTheDealerController;
import Controllers.HigherLower.HigherLowerController;
import Controllers.Treman.TremanController;
import Model.DiceGames.Treman.TremanModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;


public class UIController implements Initializable {

    public TremanController tremanController = new TremanController(this);
    // public HigherLowerController higherLowerController = new HigherLowerController(this);
    // public FTheDealerController fTheDealerController = new FTheDealerController(this);
    // public OpusController opusController = new OpusController(this);

    @FXML public Button startCardGameButton, startDiceGameButton;  //startPage
    @FXML public Label  chooseGameLabel;
    @FXML public AnchorPane startGameAnchorPane, diceGameAnchorPane, cardGameAnchorpane, opusGameAnchorPane, tremanGameAnchorPane, higherLowerAnchorPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tremanGameAnchorPane.toFront();
    }

    public void roll(ActionEvent actionEvent) {
        tremanController.roll(actionEvent);
    }

    @FXML
    public void roll2(ActionEvent actionEvent) { tremanController.roll2(actionEvent);}
}
