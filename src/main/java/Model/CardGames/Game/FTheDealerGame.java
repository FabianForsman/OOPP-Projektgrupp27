package Model.CardGames.Game;

import Model.CardGames.Cards.Card;
import Model.CardGames.Cards.DeckOfCards;
import Model.Game;

import java.util.ArrayList;

public class FTheDealerGame extends Game {

    private final ArrayList<ArrayList<Card>> startingDeck = new ArrayList<>();
    private final DeckOfCards deck = new DeckOfCards();
    private final Card chosenCard;
    private int incorrectGuesses = 0;


    public FTheDealerGame() {
        chosenCard = deck.drawCard();
        deck.shuffle();
    }

    public String dealCard (){
        return null;
    }


    //PlayerGuess(){tar in ett nummer som ska korrespondera ett kort}
    public Card playerGuess(String Card){
        return null;
    }


    //DealerCard(){vet inte om detta bara blir en lista eller godtyckligt men ska vara den kortleken spelet utgår ifrån}


    //ChangeDealer(){efter tre felgissningar av spelarna (bortsett från dealer) byt till spelaren som fick klunkar för att de gissade fel}
    public void changeDealer(){
        //kanske ska använda sig av next turn då efter man gjort fel/rätt gissningar
    }



    public boolean DealerCardIsHigher(int existingCardValue, int placedCardValue){
        if(existingCardValue < placedCardValue){
            return true;
        }else{
            //dealerCardIsLower
            return false;
        }

    }

    //Drink() going to depend on if 1. it is the dealer or not 2.if it is the dealer, depending on if the player gets the right card on the first try(5) or on the second(3) 3. and if it is the player they should drink the difference between the card they said and the one the dealer dealt.
    //PlaceCardWhenPlayed() instead of putting it away it puts the card in its representing number pile so it can be seen by all players, has a loop that when a pile has 4 of the same  card in it, it will flip to indicate that its full.
    //


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
