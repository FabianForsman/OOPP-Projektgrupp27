
package Model.CardGames.HigherLower;
import Model.CardGames.Cards.Card;
import Model.CardGames.Cards.DeckOfCards;
import Model.Game;

import java.util.ArrayList;

public class HigherLowerGame extends Game {

    private final ArrayList<ArrayList<Card>> startingBoard = new ArrayList<>();
    private final DeckOfCards deck = new DeckOfCards();
    private final Card currentCard;
    private boolean gameAborted;
    private int correctGuesses = 0;

    public HigherLowerGame(){
        currentCard = deck.drawCard();
        deck.shuffle();
    }

    public enum Direction{
        LEFT,
        RIGHT
    }

    public void setBoard(){
        for(int i = 0; i < 4; i++){
            ArrayList<Card> startingCard = new ArrayList<>();
            startingCard.add(this.deck.drawCard());
            this.startingBoard.add(startingCard);
        }
    }

    private void resetRow(int row){
        for(Card card : startingBoard.get(row)){
            startingBoard.get(row).remove(card);
        }
    }


    public Card playerChoice(int rowIndex, Direction direction){
        ArrayList<Card> row = startingBoard.get(rowIndex);

        if (direction == Direction.LEFT){
            return row.get(0);

        } else{
            return row.get(row.size() - 1);
        }
    }


    private boolean checkIfHigher(int existingCardValue, int placedCardValue){
        return existingCardValue < placedCardValue;
    }


    public int getCorrectGuesses(){
        return this.correctGuesses;
    }

    public void setCorrectGuesses(int n){
        this.correctGuesses = n;
    }


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
            return sendLossMessage(startingBoard.get(rowIndex).size());
        }
    }


    public int getTotalCardsInRow(int rowIndex){
        return this.startingBoard.get(rowIndex).size();
    }

    public void placeCard(Card card, int rowIndex, Direction direction){
        if(direction == Direction.LEFT) {
            startingBoard.get(rowIndex).add(0, card);
        } else {
            startingBoard.get(rowIndex).add(startingBoard.size()-1, card);
        }
    }

    public String sendLossMessage(int rowSize){
        return "Incorrect! Drink " + rowSize + " sips!";
    }

    public ArrayList<ArrayList<Card>> getStartingBoard(){
        return  this.startingBoard;
    }

    @Override
    public void restartGame() {

    }


    @Override
    public void nextTurn() {

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

