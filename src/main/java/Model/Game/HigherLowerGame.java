
package Model.Game;
import Model.Cards.Card;
import Model.Cards.DeckOfCards;

import java.util.ArrayList;

public class HigherLowerGame extends CardGame{

    ArrayList<Card> startingBoard = new ArrayList<>();
    DeckOfCards deck = new DeckOfCards();

    public HigherLowerGame(String rules){
        super(rules, new DeckOfCards());

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

