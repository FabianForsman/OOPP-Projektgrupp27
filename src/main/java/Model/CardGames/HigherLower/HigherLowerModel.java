
package Model.CardGames.HigherLower;
import Model.CardGames.Cards.Card;
import Model.CardGames.Cards.DeckOfCards;
import Model.Game;

import java.util.ArrayList;

public class HigherLowerModel extends Game {

    private final ArrayList<ArrayList<Card>> startingBoard = new ArrayList<>();
    private final DeckOfCards deck = new DeckOfCards();
    private final Card currentCard;

    private int correctGuesses = 0;

    /**
     * Constructor for HigherLowerModel
     */
    public HigherLowerModel(){
        currentCard = deck.drawCard();
        deck.shuffle();
    }

    /**
     * Enum for which direction one wants to pass the dice.
     */
    public enum Direction{
        LEFT,
        RIGHT
    }

    /**
     * Initializes the board for higher-lower. Places 4 cards in a row.
     */
    public void setBoard(){
        for(int i = 0; i < 4; i++){
            ArrayList<Card> startingCardStack = new ArrayList<>();
            startingCardStack.add(this.deck.drawCard());
            this.startingBoard.add(startingCardStack);
        }
    }

    /**
     * Resets the given row by removing all cards.
     * @param row
     */
    public void resetRow(int row){
        ArrayList<Card> currentRow = startingBoard.get(row);
        while (currentRow.size() > 0){
            deck.returnCardToDeck(currentRow.get(0));
            currentRow.remove(0);
        }
    }

    /**
     * Gets the card to the most-right or most-left of the arraylist. This is used to find the value to check
     * if the player can place their card on top of it.
     * @param rowIndex
     * @param direction
     * @return
     */
    public Card playerChoice(int rowIndex, Direction direction){
        ArrayList<Card> row = startingBoard.get(rowIndex);

        if (direction == Direction.RIGHT){
            return row.get(0);

        } else{
            return row.get(row.size() - 1);
        }
    }

    /**
     * Checks if the card can be placed. Placed card has to be higher than the selected card to place upon.
     * @param existingCardValue
     * @param placedCardValue
     * @return
     */
    public boolean checkIfHigher(int existingCardValue, int placedCardValue){
        return existingCardValue < placedCardValue;
    }


    public int getCorrectGuesses(){
        return this.correctGuesses;
    }

    public void setCorrectGuesses(int n){
        this.correctGuesses = n;
    }

    /**
     * Processes whether the player guessed correctly or not using previously defined methods.
     * @param placedCard
     * @param rowIndex
     * @param direction
     * @return
     */
    public String processPlayerChoice(Card placedCard, int rowIndex, Direction direction){
        Card existingCard = playerChoice(rowIndex, direction);
        if (checkIfHigher(existingCard.getRankValue(), placedCard.getRankValue())){
            placeCard(placedCard, rowIndex, direction);
            setCorrectGuesses(correctGuesses++);
            if (correctGuesses < 3){
                return "Correct, make your next choice";
            } else{
                setCorrectGuesses(0);
                return "Correct, next players turn";
            }
        } else{
            setCorrectGuesses(0);
            return sendLossMessage(rowIndex);
        }
    }

    public int getTotalCardsInRow(int rowIndex){
        return this.startingBoard.get(rowIndex).size();
    }

    /**
     * Places a card on a row, at one of its ends.
     * @param card
     * @param rowIndex
     * @param direction
     */
    public void placeCard(Card card, int rowIndex, Direction direction){
        if(direction == Direction.RIGHT) {
            startingBoard.get(rowIndex).add(0, card);
        } else {
            startingBoard.get(rowIndex).add(card);
        }
    }

    public String sendLossMessage(int rowIndex){
        return "Incorrect! Drink " + getTotalCardsInRow(rowIndex) + " sips!";
    }

    public ArrayList<ArrayList<Card>> getStartingBoard(){
        return this.startingBoard;
    }
}

