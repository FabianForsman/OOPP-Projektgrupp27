package Controllers;
import Controllers.SceneHandler;
import Model.DiceGames.Treman.Actions.*;
import Model.DiceGames.Treman.TremanModel;
import Model.Player.IPlayer;
import Model.Player.Players;
import javafx.scene.control.*;
import javafx.scene.image.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Random;


public class TremanController implements IController{
    private Label currentTremanLabel;
    private Label currentPlayerLabel;
    private Label actionMessageLabel;

    private Button rollDiceButton;
    private Button challengeRollButton;
    private Button confirmSelectedPlayersButton;
    private Button removePlayerButton;
    private Button addPlayerButton;

    private IAction currentAction;


    private ListView<String> selectedPlayersListView;
    private ListView<String> playerListView;
    TremanModel model;

    //public abstract void update(ArrayList<Image> fields);
    private Random random = new Random();

    SceneHandler handler;

    /*public void injectMainController(UIController mainController){
        this.parentController = mainController;
    }*/

    public TremanController(SceneHandler handler) {
        model = new TremanModel();
        this.handler = handler;
        currentAction = model.getAction();
    }

    public String getTremanName() {
        return model.getTremanName();
    }

    public void initializeLabels(Label currentTremanLabel, Label currentPlayerLabel, Label actionMessageLabel) {
        this.currentTremanLabel = currentTremanLabel;
        this.currentPlayerLabel = currentPlayerLabel;
        this.actionMessageLabel = actionMessageLabel;
    }

    public void initializeButtons(Button challengeRollButton,
                                  Button rollDiceButton,
                                  Button confirmSelectedPlayersButton,
                                  Button removePlayerButton,
                                  Button addPlayerButton) {
        this.challengeRollButton = challengeRollButton;
        this.rollDiceButton = rollDiceButton;
        this.confirmSelectedPlayersButton = confirmSelectedPlayersButton;
        this.removePlayerButton = removePlayerButton;
        this.addPlayerButton = addPlayerButton;
    }

    public void initializeListViews(ListView<String> playerListView, ListView<String> selectedPlayersListView) {
        this.playerListView = playerListView;
        this.selectedPlayersListView = selectedPlayersListView;
    }

    public void roll(ImageView img1, ImageView img2) {
        //rollAnimation(img1, img2);
        rollDice();
        currentAction = model.getAction();
        checkAction();
        displayActionMessage(model.getRule());
    }

    // For challengeButton
    public void rollDieChallenge(int i) {
        rollRightDie(i);
        int val1 = model.getDice().getDieValue(0);
        int val2 = model.getDice().getDieValue(1);
        displayActionMessage(((ChallengeAction) currentAction).getDrinkingCalculation(val1, val2));
        removeButton(challengeRollButton);
        setNormalRollingStatus();
    }

    public void rollRightDie(int i) {
        model.getDice().rollDie(model.getDie(i));
    }

    @Override
    public String getFXMLName() {
        return "treman";
    }

    public void checkAction() {
        System.out.println("checkAction() called");
        if(currentAction instanceof ChallengeAction){
            System.out.println("Found ChallengeAction");
            setSelectingPlayerStatus();
        } else if(currentAction instanceof EqualsAction) {
            System.out.println("Found EqualsAction");
            setSelectingPlayerStatus();
        } else if(currentAction instanceof PassAction) {
            System.out.println("Found PassAction");
            passAction();
        } else if(currentAction instanceof NewTremanAction) {
            System.out.println("Found NewTremanAction");
            setSelectingPlayerStatus();
        } else if(currentAction instanceof NoAction) {
            System.out.println("Found NoAction");

        } else {
            System.out.println("wtf?");
        }
    }

    public void challengeAction() {
        displayButton(challengeRollButton);
    }

    public void equalsAction() {
        IPlayer selectedPlayer1 = Players.getInstance().getPlayer(selectedPlayersListView.getItems().get(0));
        IPlayer selectedPlayer2 = Players.getInstance().getPlayer(selectedPlayersListView.getItems().get(1));
        ((EqualsAction) currentAction).addPlayerToPlayerList(selectedPlayer1);
        ((EqualsAction) currentAction).addPlayerToPlayerList(selectedPlayer2);
        String result = ((EqualsAction) currentAction).getResult(model.getDie(0).getVal());
        actionMessageLabel.setText(result);
    }

    public void passAction() {
        ((PassAction) currentAction).passTurn();
        displaySelectedPlayer(Players.getInstance().getCurrentPlayerName(), currentPlayerLabel);
    }

    public void newTremanAction() {
        IPlayer selectedPlayer = Players.getInstance().getPlayer(selectedPlayersListView.getItems().get(0));
        ((NewTremanAction) currentAction).setNewTreman(selectedPlayer);
        displaySelectedPlayer(selectedPlayer.getName(), currentTremanLabel);
        String result = ((NewTremanAction) currentAction).getResult();
        actionMessageLabel.setText(result);
    }

    public void setSelectingPlayerStatus() {
        displayListView(selectedPlayersListView);
        removeButton(rollDiceButton);
        displayButton(confirmSelectedPlayersButton);
        displayButton(addPlayerButton);
        displayButton(removePlayerButton);
    }

    public void setNormalRollingStatus() {
        removeListView(selectedPlayersListView);
        removeButton(challengeRollButton);
        displayButton(rollDiceButton);
        removeButton(confirmSelectedPlayersButton);
        removeButton(removePlayerButton);
        removeButton(addPlayerButton);
    }

    public void displayActionMessage(String text) {
        actionMessageLabel.setText(text);
    }
//detta kan ge buggar
    public void confirmSelectedPlayers() {
        if(selectedPlayersListView.getItems().size() == 1 && currentAction instanceof ChallengeAction) {
            String name = selectedPlayersListView.getItems().get(0);
            IPlayer selectedPlayer = Players.getInstance().getPlayer(name);
            ((ChallengeAction) currentAction).setChallengedPlayer(selectedPlayer);
            challengeAction();

        } else if(selectedPlayersListView.getItems().size() == 1 && currentAction instanceof NewTremanAction) {
            /*String name = selectedPlayersListView.getItems().get(0);
            IPlayer selectedPlayer = Players.getInstance().getPlayer(name);
            ((NewTremanAction) currentAction).setNewTreman(selectedPlayer);*/
            newTremanAction();
            setNormalRollingStatus();
        } else if(selectedPlayersListView.getItems().size() == 2) {
            equalsAction();
            setNormalRollingStatus();
        }
    }


    public void displaySelectedPlayer(String name, Label label) {
        label.setText(name);
    }

    public void displaySelectedPlayer(String name, ListView<String> playersListView) {
        playersListView.getItems().add(name);

    }

    //For roll-button for the challenged player.
    public void displayButton(Button button) {
        button.setDisable(false);
        button.setVisible(true);
    }

    public void removeButton(Button button) {
        button.setDisable(true);
        button.setVisible(false);
    }

    public void displayListView(ListView<String> listView) {
        listView.setDisable(false);
        listView.setVisible(true);
    }

    public void removeListView(ListView<String> listView) {
        listView.getItems().clear();
        listView.setDisable(true);
        listView.setVisible(false);
    }

    //Select players in playerListView and add it to selectedPlayersListView
    public void selectPlayer(ListView<String> listView) {
        String name = listView.getSelectionModel().getSelectedItem();
        IPlayer selectedPlayer = Players.getInstance().getPlayer(name);
        displaySelectedPlayer(name, selectedPlayersListView);
        /*
        if(currentAction instanceof EqualsAction) {
            ((EqualsAction) currentAction).addPlayerToPlayerList(selectedPlayer);
        }
        else if(currentAction instanceof NewTremanAction action) {
            action.setNewTreman(selectedPlayer);
            displaySelectedPlayer(name, currentTremanLabel);
        }*/
    }

    public void removePlayer(ListView<String> listView) {
        String name = listView.getSelectionModel().getSelectedItem();
        listView.getItems().remove(name);
    }

    //For rollDiceButton
    public void rollDice() {
        model.getDice().rollAllDice();
        //removeSelectedPlayers();
    }




    public void setFirstDieImage(ImageView dieImage){
        model.getDie(0).updateCurrentImagePath();
        InputStream stream = null;
        try {
            stream = new FileInputStream(model.getDie(0).getCurrentImagePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(stream);
        dieImage.setImage(image);

    }


    // Setting the correct image for the second die based on roll
    public void setSecondDieImage(ImageView dieImage){
        model.getDie(1).updateCurrentImagePath();
        InputStream stream = null;
        try {
            stream = new FileInputStream(model.getDie(1).getCurrentImagePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(stream);
        dieImage.setImage(image);
    }

    // Opens the window with the player list
    public void openPlayerListView(ListView<String> listview){
        listview.setDisable(false);
        listview.setVisible(true);
    }

    // Removes the list of players
    public void closePlayerListView(ListView<String> listView) {
        listView.setDisable(true);
        listView.setVisible(false);
    }

    public void populatePlayerList(ListView<String> listView){
        listView.getItems().clear();
        for(IPlayer player : Players.getInstance().getPlayersList()) {
            listView.getItems().add(player.getName());
        }
    }

    public void rollaAnimation(ImageView img1, ImageView img2) {
        try {
            for (int i = 0; i < 10; i++) {
                FileInputStream stream = new FileInputStream("src/main/resources/resources_img/dice/die" + (random.nextInt(6) + 1) + ".png");
                Image image = new Image(stream);
                img1.setImage(image);}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
