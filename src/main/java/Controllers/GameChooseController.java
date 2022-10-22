package Controllers;


import javafx.scene.layout.AnchorPane;

public class GameChooseController extends AnchorPane {
    private SceneHandler handler;

    public GameChooseController(SceneHandler handler) {
        this.handler = handler;
    }

    public String getFXMLName() {
        return "GameChoose";
    }

    public void switchToTreman(){
        handler.switchToGame("treman");
    }

    public void switchToOpus(){handler.switchToGame("opus");}

    public void switchToHigherLower(){handler.switchToGame("higherlower");}

    public void switchToFTheDealer(){handler.switchToGame("fthedealer");}


}
