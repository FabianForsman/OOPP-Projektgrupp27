package View;

import Controllers.FTheDealerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;


import java.io.IOException;

public class FTheDealerView extends AbstractGameView {
    private FTheDealerController controller;
    private FXMLLoader fxmlLoader;

    @FXML public Label LabelFTDResponse;
    @FXML public Label LabelFTDTurnCardsMessage;

    @FXML private AnchorPane fTheDealerAnchorPane;

    public FTheDealerView(FTheDealerController controller) throws IOException {
        super(controller.getFXMLName());
        this.controller = controller;
    }

    @Override
    public void update() {
        controller.displayChoiceResponse(LabelFTDResponse);
        controller.checkIfFourCards(LabelFTDTurnCardsMessage);
    }




}

