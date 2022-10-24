package Model.CardGames.FTheDealer;

import Model.CardGames.Cards.DeckOfCards;
import Model.CardGames.Cards.Card;
import Model.Game;
import Model.Player.Players;

import java.util.ArrayList;

public class FTheDealerModel extends Game {
    private final DeckOfCards deck = new DeckOfCards();
    private final Card dealerCard;
    private int guessedSpot;
    private int incorrectGuesses = 0;
    private int incorrectPlayers = 0;
    private FTheDealerBoard board;

    public FTheDealerModel() {
        Players.getInstance().setRandomCurrentPlayer();
        board = new FTheDealerBoard();
        deck.shuffle();
        dealerCard = deck.drawCard();
    }

    public void selectTableSpot(int index) {
        guessedSpot = index;
    }

    public Card getDealerCard(){
        return dealerCard;
    }

    private void checkIfCorrectGuess() {
        if (board.checkIfCorrectCard(guessedSpot, dealerCard)) {
            placeCardOnBoard();
        } else {
            incorrectGuesses++;
        }
    }

    private String drinkCalculatorPlayer() {
        return String.valueOf(Math.abs(dealerCard.getRankValue() - guessedSpot));
    }

    public String drinkCalculator() {
        if (incorrectGuesses == 0) {
            return Players.getInstance().getCurrentPlayerName() + " hands out 5 drinks.";
        } else if (incorrectGuesses == 1) {
            return Players.getInstance().getCurrentPlayerName() + " hands out 3 drinks.";
        } else {
            placeCardOnBoard();
            incorrectGuesses = 0;
        }
        return "Too many incorrect guesses. " +
                Players.getInstance().getCurrentPlayer().getName() +
                " takes " + drinkCalculatorPlayer() + ".";
    }

    private void checkIfTooManyGuesses(int i) {
        if (i > 2) {
            Players.getInstance().passTurnLeft();
        }
    }


    public void placeCardOnBoard() {
        board.addToBoard(dealerCard);
    }

    public ArrayList<ArrayList<Card>> getBoard(){
        return board.getBoard();
    }

    public String checkIfFourCards() {
        if (board.checkIfFourCards(guessedSpot)) {
            return "4 of the same! Turning " + guessedSpot +
                    " over.";
        }
        return "";
    }

    private Card drawCard() {
        return deck.drawCard();
    }

    public String higherOrLower() {
        if (guessedSpot > dealerCard.getRankValue()) {
            incorrectGuesses++;
            return "Correct card is lower!";
        } else if (guessedSpot < dealerCard.getRankValue()) {
            incorrectGuesses++;
            return "Correct card is higher!";
        } else
            return "Correct! " + drinkCalculator();
    }

    @Override
    public void restartGame() {

    }

    @Override
    public void quitGame() {

    }
    public int getGuessedSpot(){
        return guessedSpot;
    }
    public String getDrinkCalculatorPlayer(){return drinkCalculatorPlayer();}

    public void setIncorrectGuesses(int incorrectGuesses){
        this.incorrectGuesses = incorrectGuesses;
    }


}