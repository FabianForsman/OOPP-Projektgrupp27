package Controllers.HigherLower;

import Controllers.SceneHandler;
import Model.CardGames.Cards.Card;
import Model.CardGames.HigherLower.HigherLowerModel;

import java.util.ArrayList;

public class HigherLowerController {
    private SceneHandler handler;
    HigherLowerModel model;

    public HigherLowerController(SceneHandler handler) {
        model = new HigherLowerModel();
        this.handler =handler;

    }

    private HigherLowerModel game = new HigherLowerModel();


    public void showStartingBoard() {
        for (ArrayList<Card> row : game.getStartingBoard()) {
            for (Card card : row) {
                System.out.println(card.getRankValue());
            }
        }
    }
    public String getFXMLName() {
        return "higherlower";
    }

}
