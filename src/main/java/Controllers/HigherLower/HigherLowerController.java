package Controllers.HigherLower;

import Model.CardGames.Cards.Card;
import Model.CardGames.HigherLower.HigherLowerModel;
import com.example.hydrohomies.UIController;

import java.util.ArrayList;

public class HigherLowerController {

    public HigherLowerController(UIController parentController) {

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
