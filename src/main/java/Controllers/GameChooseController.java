package Controllers;


import Model.CardGames.FTheDealer.FTheDealerModel;
import Model.DiceGames.Treman.TremanModel;
import javafx.scene.layout.AnchorPane;

public class GameChooseController extends AnchorPane implements IController {
    private final SceneHandler handler;

    public GameChooseController(SceneHandler handler) {
        this.handler = handler;
    }

    @Override
    public String getFXMLName() {
        return "GameChoose";
    }

    public void switchToTreman(){
        TremanModel.setRandomTreman();
        TremanModel.setRandomCurrentPlayer();
        handler.switchToGame("treman");
    }

    public void switchToOpus(){
        FTheDealerModel.setRandomCurrentPlayer();
        handler.switchToGame("opus");
    }

    public void switchToHigherLower(){handler.switchToGame("higherlower");}

    public void switchToFTheDealer(){handler.switchToGame("fthedealer");}
}
