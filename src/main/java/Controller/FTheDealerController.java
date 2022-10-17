package Controller;

public class FTheDealerController {
    package Controller;

import Model.CardGames.Cards.Card;
import Model.CardGames.FTheDealer.FTheDealerGame;
import View.FTheDealerView;
import javafx.fxml.FXML;

    public class FTheDealerController {

        FTheDealerGame model;
        FTheDealerView view;

        public FTheDealerController(FTheDealerGame currentModel, FTheDealerView currentView) {
            model = currentModel;
            view = currentView;
        };

        @FXML
        public void chooseSpot(Card card) {
            model.selectSpot(card);
            view.update();
        }


    }
}
