package Model.CardGames.FTheDealer;

import Model.CardGames.Cards.Card;

import java.util.ArrayList;

public class FTheDealerBoard {
    private final ArrayList<ArrayList<Card>> board = new ArrayList<>(13);

    public FTheDealerBoard() {
        generateBoard();
    }

    public boolean checkIfCorrectCard(Card card, Card correctCard) {
        return card == correctCard;
    }

    private void generateBoard() {
        for (int i = 0; i < 13; i++) {
            board.add(new ArrayList<>(4));
        }
    }

    public void addToBoard(Card card) {
        for(int i = 0; i < 13; i++) {
            if (card.getRankValue() == i) {
                board.get(i).add(card);
                break;
            }
        }
    }

    public boolean checkIfFourCards(Card card) {
        int index = card.getRankValue() - 1;
        return board.get(index).size() == 4;
    }
}