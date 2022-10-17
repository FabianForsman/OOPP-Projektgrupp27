package Model.DiceGames.Opus;
import Model.DiceGames.Dice.Die;

import java.awt.event.*;

public class OpusKeyAdapter extends KeyAdapter{
    Die die;
    OpusModel gamePanel;

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_L, KeyEvent.VK_A -> die.rollDie();
            case KeyEvent.VK_Q -> gamePanel.quitGame();

        }

    }

}
