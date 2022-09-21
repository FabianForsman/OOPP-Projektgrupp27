
package Model.CardGames.Game;
import Model.CardGames.Cards.Card;
import Model.CardGames.Cards.DeckOfCards;

import java.util.ArrayList;

public class HigherLowerGame extends Game{

    ArrayList<ArrayList<Card>> startingBoard = new ArrayList<>();
    DeckOfCards deck = new DeckOfCards();
    Card currentCard;
    boolean choiceMade = false;

    public HigherLowerGame(String rules){
        super(rules);
        currentCard = deck.drawCard();
    }

    private enum Direction{
        LEFT,
        RIGHT
    }

    public void setBoard(){
        for(int i = 0; i < 4; i++){
            this.startingBoard.get(i).add(this.deck.drawCard());
        }
    }

    public Card playerChoice(int rowIndex, Direction direction){
        ArrayList<Card> row = startingBoard.get(rowIndex);
        this.choiceMade = true;
        if (direction == direction.LEFT){
            return row.get(0);

        } else{
            return row.get(row.size() - 1);
        }
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
        Card currentCard = this.deck.drawCard();
        Card chosenCard = playerChoice(3, Direction.LEFT);
        boolean isHigher = checkIfHigher(chosenCard.getRankValue(), currentCard.getRankValue());


    }


}

