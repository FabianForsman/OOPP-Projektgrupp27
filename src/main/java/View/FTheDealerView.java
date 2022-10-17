package View;


import Model.CardGames.FTheDealer.FTheDealerGame;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FTheDealerView implements IView {
    FTheDealerGame model;

    @FXML public Label LabelFTDResponse;
    @FXML public Label LabelFTDTurnCardsMessage;


    public FTheDealerView(FTheDealerGame currentModel) {
        model = currentModel;
    }

    @Override
    public void update(){
        displayChoiceResponse();
        checkIfFourCards();
    }

    public void displayChoiceResponse() {
        LabelFTDResponse.setText(model.higherOrLower());
    }

    public void checkIfFourCards() {
        LabelFTDTurnCardsMessage.setText(model.checkIfFourCards());
    }
}


