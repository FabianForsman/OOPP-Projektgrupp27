package com.example.hydrohomies.SceneBuilderRunLogic;

import Model.DiceGames.Dice.Dice;
import Model.Player.Player;


public class HydroHomieDataHandler {
    private static HydroHomieDataHandler instance = null;
    private Player player;
    private Dice dice;
    
    public static HydroHomieDataHandler getInstance() {
        if (instance == null) {
            instance = new HydroHomieDataHandler();
            instance.init();
        }

        return instance;
    }

    private void init() {
    }

    public void shutDown(){};
    // måste väll ha kort, spelare, special spelare, kanske arrays på skit?
    // eller tänker vi att vi ska hämta skiten från varje separat grej och utforma controller logic där?

}
