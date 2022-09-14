
package Model.CardGames.Game;
import Model.CardGames.Cards.Card;
import Model.CardGames.Cards.DeckOfCards;

import java.util.ArrayList;

public class HigherLowerGame extends Game{

    ArrayList<Card> startingBoard = new ArrayList<>();
    DeckOfCards deck = new DeckOfCards();

    public HigherLowerGame(String rules){
        super(rules);

    }

    public void setBoard(){
        for(int i = 0; i < 5; i++){
            this.startingBoard.add(deck.drawCard());
        }
    }

    public void placeCard(){
        Card drawnCard = this.deck.drawCard();

    }

    private boolean checkIfHigher(int existingCardValue, int placedCardValue){
        return existingCardValue < placedCardValue;
    }

    @Override
    public void nextTurn() {

    }

    @Override
    public void nextRound() {

    }

    @Override
    public void quitGame() {

    }

    @Override
    public void startGame() {

    }

    @Override
    public void startRound() {

    }


}

