package Model.CardGames.FTheDealer;

import Model.CardGames.Cards.DeckOfCards;
import Model.CardGames.Cards.Card;
import Model.Game;
import Model.Player.IPlayer;
import Model.Player.Players;

public class FTheDealerModel extends Game {
    private final DeckOfCards deck = new DeckOfCards();
    private final Card correctCard;
    private Card guessedCard;
    private int incorrectGuesses = 0;
    private int incorrectPlayers = 0;
    private FTheDealerBoard board;
    private static IPlayer dealer;

    public FTheDealerModel() {
        Players.getInstance().setRandomCurrentPlayer();
        dealer = Players.getInstance().getRandomPlayer();
        board = new FTheDealerBoard();
        deck.shuffle();
        correctCard = deck.drawCard();
    }

    public void selectCard(Card card) {
        guessedCard = card;
        checkIfCorrectGuess();
    }

    private void checkIfCorrectGuess() {
        if (board.checkIfCorrectCard(guessedCard, correctCard)) {
            placeCardOnBoard();
        } else {
            incorrectGuesses++;
        }
    }

    private String drinkCalculatorPlayer(Card card) {
        return String.valueOf(Math.abs(correctCard.getRankValue() - card.getRankValue()));
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

    private void checkIfTooManyGuesses(int i) {
        if (i > 2) {
            Players.getInstance().passTurnLeft();
        }
    }


    private void placeCardOnBoard() {
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

    private Card drawCard() {
        return deck.drawCard();
    }

    public String higherOrLower() {
        if (guessedCard.getRankValue() < correctCard.getRankValue()) {
            incorrectGuesses++;
            return "Correct is lower!";
        } else if (guessedCard.getRankValue() > correctCard.getRankValue()) {
            incorrectGuesses++;
            return "Correct card is higher!";
        } else
            return "Correct! " + drinkCalculator(guessedCard);
    }

    @Override
    public void restartGame() {

    }

    @Override
    public void quitGame() {

    }
}