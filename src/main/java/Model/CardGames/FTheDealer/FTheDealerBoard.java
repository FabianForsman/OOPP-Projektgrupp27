package Model.CardGames.FTheDealer;

import Model.CardGames.Cards.Card;

import java.util.ArrayList;
/**
 * Author: Julia Giaro
 * */
public class FTheDealerBoard {
    private final ArrayList<ArrayList<Card>> board = new ArrayList<>(13);

    public FTheDealerBoard() {
        generateBoard();
    }

    public boolean checkIfCorrectCard(int guessedCard, Card correctCard) {
        return guessedCard == correctCard.getRankValue();
    }

    private void generateBoard() {
        for (int i = 0; i < 13; i++) {
            board.add(new ArrayList<>(4));
        }
    }

    public void addToBoard(Card card) {
        for(int i = 0; i < 13; i++) {
            if (card.getRankValue() - 1 == i) {
                board.get(i).add(card);
                break;
            }
        }
    }

    public boolean checkIfFourCards(int index) {
        return board.get(index-1).size() == 4;
    }

    public ArrayList<ArrayList<Card>> getBoard(){
        return board;
    }
}