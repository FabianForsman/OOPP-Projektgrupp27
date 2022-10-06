package Controllers.HigherLower;

import Model.CardGames.Cards.Card;
import Model.CardGames.HigherLower.HigherLowerGame;

import java.util.ArrayList;

public class HigherLowerController {

    private HigherLowerGame game = new HigherLowerGame();


    public void showStartingBoard() {
        for (ArrayList<Card> row : game.getStartingBoard()) {
            for (Card card : row) {
                System.out.println(card.getRankValue());
            }
        }
    }


}
