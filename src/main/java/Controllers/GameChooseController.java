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
        handler.switchTo("treman");
    }

    public void switchToOpus(){handler.switchTo("opus");}

    public void switchToHigherLower(){handler.switchTo("higherlower");}

    public void switchToFTheDealer(){handler.switchTo("fthedealer");}


}
