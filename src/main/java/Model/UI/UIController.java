package Model.UI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class UIController implements Initializable {

    @FXML public Button startCardGameButton, startDiceGameButton, startInformationButton, allItemsButton;  //startPage
    @FXML public Label  chooseGameLabel;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
