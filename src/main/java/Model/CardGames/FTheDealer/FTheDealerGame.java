package Model.CardGames.FTheDealer;

import Model.CardGames.Cards.Card;
import Model.CardGames.Cards.DeckOfCards;
import Model.CardGames.Cards.IDeckOfCards;
import Model.Game;
import Model.Player.IPlayer;
import Model.Player.Players;

public class FTheDealerGame extends Game {
    private final IDeckOfCards deck = new DeckOfCards();
    private final Card correctCard;
    private Card guessedCard;
    private int incorrectGuesses = 0;
    private int incorrectPlayers = 0;
    private FTheDealerBoard board;
    public static IPlayer dealer;

    public FTheDealerGame() {
        Players.getInstance().setRandomCurrentPlayer();
        dealer = Players.getInstance().getRandomPlayer();
        board = new FTheDealerBoard();
        deck.shuffle();
        correctCard = deck.drawCard();
    }


    public void selectSpot(Card card) {
        guessedCard = card;
        checkIfCorrectGuess();
    }

    public void checkIfCorrectGuess() {
        if (board.checkIfCorrectCard(guessedCard, correctCard)) {
            placeCardOnBoard();
        } else {
            incorrectGuesses++;
        }
    }

    public String drinkCalculatorPlayer(Card card) {
        return String.valueOf(Math.abs(correctCard.getRankValue()-card.getRankValue()));
    }

    public String drinkCalculator(Card card) {
        if (incorrectGuesses == 0) {
            return dealer + " takes 5.";
        } else if (incorrectGuesses == 1) {
            return dealer + " takes 3.";
        }
        incorrectGuesses = 0;

        return "Too many incorrect guesses. " +
                Players.getInstance().getCurrentPlayer().getName() +
                " takes " + drinkCalculatorPlayer(card) + ".";
    }

    public void checkIfTooManyGuesses(int i) {
        if (i > 2) {
            Players.getInstance().passTurnLeft();
        }
    }



    public void placeCardOnBoard() {
        board.addToBoard(guessedCard);
        Players.getInstance().passTurnLeft();
    }

    public String checkIfFourCards() {
        if (board.checkIfFourCards(guessedCard)) {
            return "4 of the same! Turning " + guessedCard.getRank() +
                    " of " + guessedCard.getSuit() + " over.";
        }
        return "";
    }

    public Card drawCard() {
        return deck.drawCard();
    }

    public String higherOrLower() {
        if(guessedCard.getRankValue() < correctCard.getRankValue()) {
            incorrectGuesses++;
            return "Correct is lower!";
        } else if (guessedCard.getRankValue() > correctCard.getRankValue()) {
            incorrectGuesses++;
            return "Correct card is higher!";
        } else
            return "Correct! " + drinkCalculator(guessedCard);
    }


    @Override
    public void nextTurn() {

    }

    @Override
    public void restartGame() {

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