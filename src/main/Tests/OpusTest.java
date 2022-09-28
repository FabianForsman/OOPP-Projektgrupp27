import Model.DiceGames.Opus.OpusGamePanel;
import Model.Player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
public class OpusTest {
    ArrayList<Player> playerList = new ArrayList<>();
    OpusGamePanel panel = new OpusGamePanel("test");

    Player p1 = new Player("p1");
    Player p2 = new Player("p2");
    Player p3 = new Player("p3");


    @Test
    public void testSetCurrentPlayer() {
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        panel.setCurrentPlayer(p2);




    }
}
