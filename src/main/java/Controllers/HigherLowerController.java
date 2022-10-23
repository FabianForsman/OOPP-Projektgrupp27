package Controllers;

import Controllers.SceneHandler;
import Model.CardGames.Cards.Card;
import Model.CardGames.HigherLower.HigherLowerModel;

import java.util.ArrayList;

public class HigherLowerController implements IController {
    private SceneHandler handler;
    HigherLowerModel model;

    public HigherLowerController(SceneHandler handler) {
        model = new HigherLowerModel();
        this.handler =handler;

    }

    private HigherLowerModel game = new HigherLowerModel();


    public void showStartingBoard() {
        for (ArrayList<Card> row : model.getStartingBoard()) {
            for (Card card : row) {
                System.out.println(card.getRankValue());
            }
        }
    }

    @Override
    public String getFXMLName() {
        return "higherlower";
    }

}
