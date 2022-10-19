package Controllers.FTheDealer;

import Model.CardGames.FTheDealer.FTheDealerModel;
import Model.DiceGames.Treman.TremanModel;
import com.example.hydrohomies.UIController;

public class FTheDealerController {
    UIController parentController;
    FTheDealerModel model;

    public FTheDealerController(UIController parentController) {
        this.parentController = parentController;
        model = new FTheDealerModel();
    }
}
