package View;

import Controllers.GameChooseController;

import com.example.hydrohomies.UIController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;

public class GameChooseView extends AbstractView{

    @FXML public AnchorPane gameChooseAnchorPane;
    @FXML private Button tremanGameStartButton;
    @FXML private Button opusGameStartButton;
    @FXML private Button higherLowerStartButton;
    @FXML private Button fTheDealerStartButton;




    private GameChooseController gameChooseController;
    private FXMLLoader fxmlLoader;

    public GameChooseView(GameChooseController controller) throws IOException {
        super(controller.getFXMLName());
        this.gameChooseController = controller;
    }


    @FXML
    public void switchToTreman(){
        gameChooseController.switchToTreman();
    }

    @FXML
    public void switchToOpus(){gameChooseController.switchToOpus();}

    @FXML
    public void switchToHigherLower(){gameChooseController.switchToHigherLower();}

    @FXML
    public void switchToFTheDealer(){gameChooseController.switchToFTheDealer();}
}