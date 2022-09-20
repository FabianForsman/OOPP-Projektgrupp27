package Model.DiceGames.Treman;

import Model.DiceGames.Dice.Dice;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TremanRules {
    private static final String snakeEyes = "Two ones, Snake Eyes! Take two or give them away.";
    private static final String equals = "Two of the same! Give them away.";
    private static final String noseTouch = "Touch your nose! Last one takes one.";
    private static final String treman = "Treman! Treman, take one. ";
    private static final String newTreman = "New treman! Give the hat to someone else.";
    private static final String noSix = "Six is good, but not here.";
    private static final String endTurn = " Pass the dice along.";
    private static final String sevenAhead = "Seven ahead. Person in front of you takes one.";
    private static final String notSoGreat = "Eight not so great.";
    private static final String nineBehind = "Nine behind. Person behind you takes one.";
    private static final String cheers = "Cheers! Everyone takes one.";
    private static final String hell = "Hell!";

    private static TremanRules instance;

    TremanRules(){}

    public static TremanRules getInstance() {
        if(instance == null) {
            instance = new TremanRules();
        }
        return instance;
    }

    public String getRule(Dice dice) {
        /*
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("GameRules.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        */

        int die1 = dice.getDie(0).getVal();
        int die2 = dice.getDie(1).getVal();
        String returnString = "";
        boolean tremanFlag = false;

        if (die1 == 3 && die2 == 3) {
            return newTreman;
        }

        if (die1 == 3 || die2 == 3) {
            returnString += treman;
            tremanFlag = true;
        }

        if (die1 == die2) {
            if (die1 == 1) {
                return returnString + snakeEyes;
            } else {
                return returnString + equals;
            }
        }

        if (die1 == 1 && die2== 4 || die1 == 4 && die2== 1) {
            return returnString + noseTouch;
        }

        if (returnString.equals("") && (die1+ die2 == 6)) {
            return returnString + noSix + endTurn;
        }

        if(die1 + die2 == 8) {
            if (!tremanFlag) {
                return returnString + notSoGreat + endTurn;
            }
            return returnString;
        }
        switch(die1 + die2) {
            case 7: return returnString + sevenAhead;
            case 9: return returnString + nineBehind;
            case 10: return cheers;
            case 11: return hell + endTurn;
        }

        if(!returnString.equals("")) {
            return returnString;
        } else{
            return "No rule found.";
        }
    }

}
