package Model.CardGames.FTheDealer;

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

    /*
    method to tell you if the dealers card is higher or lower when
    you guess a value.
     */

    public boolean dealerCardIsHigher(int existingCardValue, int placedCardValue){
        if(existingCardValue < placedCardValue){
            System.out.println("card is higher");
            return true;

        }else{
            //dealerCardIsLower
            System.out.println("card is lower");
            return false;
        }

    }
    public void firstGuess(){
        if (/* du gissar fel */){
            System.out.println("Incorrect! Guess again, dealer says " + dealerCardIsHigher(???));
            secondGuess();
        }else {
            System.out.println("Correct! Dealer takes 5 sips");
            /*Ny runda*/
        }
    }

    public void secondGuess(){
        if(/*du gissar fel*/){
            System.out.println("Incorrect! Take /* diffen mellan det sista kortet" +
                    "och det som faktiskt var draget*/ sips!!");
        }else {
            System.out.println("Correct! Dealer takes 3 sips");
        }
    }

    public void dealCard (){
        chosenCard.DisplayCard();
        System.out.println("The dealer has a card. Guess a value");
    }
    //tänker att man drar upp ett kort från högen och när dealern ska bytas så kommer player ändras på högen istället för tvärt om



    //PlayerGuess(){tar in ett nummer som ska korrespondera ett kort}
    public void playerGuess(String Card){
        dealCard();

    }


    //DealerCard(){vet inte om detta bara blir en lista eller godtyckligt men ska vara den kortleken spelet utgår ifrån}


    //ChangeDealer(){efter tre felgissningar av spelarna (bortsett från dealer) byt till spelaren som fick klunkar för att de gissade fel}
    public void changeDealer(){
        //kanske ska använda sig av next turn då efter man gjort fel/rätt gissningar
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
