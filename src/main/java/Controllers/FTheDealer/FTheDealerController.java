package Controllers.FTheDealer;

import Controllers.SceneHandler;
import Model.CardGames.FTheDealer.FTheDealerModel;
import Model.DiceGames.Treman.TremanModel;
import com.example.hydrohomies.UIController;

public class FTheDealerController {
    private SceneHandler handler;
    FTheDealerModel model;


    public FTheDealerController(SceneHandler handler) {
        model = new FTheDealerModel();
        this.handler = handler;
    }


    public String getFXMLName(){return "fthedealer";}
}
