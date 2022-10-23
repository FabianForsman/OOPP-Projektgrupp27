package Controllers;

import Controllers.SceneHandler;
import Model.CardGames.FTheDealer.FTheDealerModel;
import Model.CardGames.Cards.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.*;

public class FTheDealerController implements IController {
    private SceneHandler handler;
    FTheDealerModel model;


    public void chooseSpot(Card card) {
        //model.selectSpot(card);
        //view.update();
    }

    public FTheDealerController(SceneHandler handler) {
        model = new FTheDealerModel();
        this.handler = handler;
    }

    public void displayChoiceResponse(Label LabelFTDResponse) {
        LabelFTDResponse.setText(model.higherOrLower());
    }

    public void checkIfFourCards(Label LabelFTDTurnCardsMessage) {
        LabelFTDTurnCardsMessage.setText(model.checkIfFourCards());
    }


    public void displayBoard(){

    }

    @Override
    public String getFXMLName(){return "fthedealer";}
}
