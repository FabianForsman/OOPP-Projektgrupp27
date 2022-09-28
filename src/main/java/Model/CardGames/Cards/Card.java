package Model.CardGames.Cards;

enum Suits {
    HEARTS,
    DIAMONDS,
    SPADES,
    CLUBS
}

enum Ranks {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING
}


public class Card {

    private final Suits suit;
    private final Ranks rank;

    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    //Temp function to test cards.
    public void DisplayCard() {
        System.out.println(suit + " " + rank + " " + (rank.ordinal() + 1));
    }

    public Suits getSuit() {
        return suit;
    }

    public Ranks getRank() {
        return rank;
    }

    public int getRankValue() {return rank.ordinal()+1;}

}
