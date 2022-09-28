
package Model.CardGames.Game;
import Model.CardGames.Cards.Card;
import Model.CardGames.Cards.DeckOfCards;
import Model.Game;

import java.util.ArrayList;

public class HigherLowerGame extends Game {

    private ArrayList<ArrayList<Card>> startingBoard = new ArrayList<>();
    private DeckOfCards deck = new DeckOfCards();
    private Card currentCard;
    private boolean choiceMade = false;
    private boolean gameAborted;

    public HigherLowerGame(String rules){
        super(rules);
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
    public void setCurrentPlayer() {

    }

    public void showStartingBoard(){
        for(ArrayList<Card> row : startingBoard){
            for(Card card : row){
                System.out.println(card.getRankValue());
            }
        }
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
        setBoard();
        while(!gameAborted){
            startRound();
        }

    }

    @Override
    public void startRound() {
        int correctGuesses = 0;
        showStartingBoard();
        Card currentCard = this.deck.drawCard();
        //Scanner input = new Scanner(System.in);
        //String chosenDirection = input.nextLine();
        //int chosenRow = input.nextInt();
        Card chosenCard = playerChoice(3, Direction.LEFT);
        System.out.println(currentCard.getRankValue());
        System.out.println(chosenCard.getRankValue());
        boolean isHigher = checkIfHigher(chosenCard.getRankValue(), currentCard.getRankValue());
        if(!isHigher){
            System.out.println("Drink " + startingBoard.get(3).size() + " sips!");
        } else {
            System.out.println("You guessed Correctly!");
            correctGuesses++;
        }

        if (correctGuesses == 3){
            setNextPlayer();
        }
    }


}

