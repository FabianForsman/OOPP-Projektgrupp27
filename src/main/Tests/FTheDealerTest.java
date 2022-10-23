import Model.CardGames.Cards.Card;
import Model.CardGames.Cards.DeckOfCards;
import Model.CardGames.FTheDealer.FTheDealerModel;
import Model.CardGames.HigherLower.HigherLowerModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FTheDealerTest {


    @Test
    void testLowerCard(){
        FTheDealerModel game = new FTheDealerModel();
        Card card = new DeckOfCards().drawCard();
        Card drawnCard = new DeckOfCards().drawCard();
        game.selectCard(drawnCard);
        if (card.getRankValue() < drawnCard.getRankValue()) {
            assertTrue(game.higherOrLower() =="Correct is Lower" );
        } else{
            assertFalse(game.higherOrLower() == "Correct is Higher");
        }
        //ska kolla ifall kortet är lägre och det kommer ge en till guess
    }

    @Test
    void testPlayerChoice(){

    }
    @Test
    void testProcessPlayerChoice(){

    }

    @Test
    void testHigherCard(){
        FTheDealerModel game = new FTheDealerModel();
        Card card = new DeckOfCards().drawCard();
        Card drawnCard = new DeckOfCards().drawCard();
        //ska kolla ifall kortet är högre och det kommer ge en till guess
    }


    @Test
    void testCheckIfHigher(){
        FTheDealerModel game = new FTheDealerModel();

    }


}
