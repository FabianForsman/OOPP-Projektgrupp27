package com.example.hydrohomies;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;


public class UIController  {

    @FXML public Button startCardGameButton, startDiceGameButton, startInformationButton, allItemsButton, exitButton;  //startPage
    @FXML public Label  chooseGameLabel;
    @FXML public AnchorPane startGameAnchorPane, diceGameAnchorPane, cardGameAnchorpane, opusGameAnchorPane, tremanGameAnchorPane, higherLowerAnchorPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tremanGameAnchorPane.toFront();
    }

}
