package Controllers.Treman;
import Controllers.SceneHandler;
import Model.DiceGames.Treman.Actions.ChallengeAction;
import Model.DiceGames.Treman.Actions.EqualsAction;
import Model.DiceGames.Treman.Actions.NewTremanAction;
import Model.DiceGames.Treman.Actions.PassAction;
import Model.DiceGames.Treman.TremanModel;
import Model.Player.IPlayer;
import Model.Player.Players;
import javafx.scene.control.*;
import javafx.scene.image.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;


public class TremanController{
    private Label currentTremanLabel;
    private Label currentPlayerLabel;
    private Label actionMessageLabel;

    TremanModel model;

    //public abstract void update(ArrayList<Image> fields);
    Random random = new Random();

    private final SceneHandler handler;

    /*public void injectMainController(UIController mainController){
        this.parentController = mainController;
    }*/

    public TremanController(SceneHandler handler) {
        model = new TremanModel();
        this.handler = handler;
    }

    public String getTremanName() {
        return model.getTremanName();
    }

    public void initializeLabels(Label currentTremanLabel, Label currentPlayerLabel, Label actionMessageLabel) {
        this.currentTremanLabel = currentTremanLabel;
        this.currentPlayerLabel = currentPlayerLabel;
        this.actionMessageLabel = actionMessageLabel;
    }

    public void roll(ImageView img1, ImageView img2) {
        rollAnimation(img1, img2);
        rollDice();
        displayActionMessage();
    }

    public String getFXMLName() {
        return "treman";
    }


    public void displayActionMessage() {
        actionMessageLabel.setText(model.getRule());
    }

    public void displaySelectedPlayer(String name, Label label) {
        label.setText(name);
    }

    public void displaySelectedPlayer(String name, ListView<String> playersListView) {
        playersListView.getItems().add(name);

    }

    public void removeSelectedPlayers(ListView selectedPlayersListView) {
        selectedPlayersListView.getItems().clear();
        selectedPlayersListView.setVisible(false);
    }

    //For roll-button for the challenged player.
    public void displayChallengeButton(Button challengeRollButton) {
        challengeRollButton.setDisable(false);
        challengeRollButton.setVisible(true);
    }

    public void removeChallengeButton(Button challengeRollButton) {
        challengeRollButton.setDisable(true);
        challengeRollButton.setVisible(false);
    }

    //Select multiple players in playerComboBox
    public void selectPlayer(ListView<String> listView) {
        String name = listView.getSelectionModel().getSelectedItem();
        IPlayer selectedPlayer = Players.getInstance().getPlayer(name);

        if(model.getAction() instanceof ChallengeAction action) {
            action.setChallengedPlayer(selectedPlayer);
            displaySelectedPlayer(name, listView);
            closePlayerListView(listView);
        }
        else if(model.getAction() instanceof EqualsAction action) {
            action.addPlayerToPlayerList(selectedPlayer);
            displaySelectedPlayer(name, currentTremanLabel);
            if(action.getPlayerList().size() >= 2) {
                closePlayerListView(listView);
            }
        }
        else if(model.getAction() instanceof NewTremanAction action) {
            action.setNewTreman(selectedPlayer);
            displaySelectedPlayer(name, currentTremanLabel);
        }
        else if(model.getAction() instanceof PassAction action) {
            displaySelectedPlayer(name, currentPlayerLabel);
        }
    }

    //For rollDiceButton
    public void rollDice() {
        model.getDice().rollAllDice();
        //removeSelectedPlayers();
    }

    // For challengeButton
    public void rollDie(int i) {
        model.getDice().rollDie(model.getDie(i));
    }


    public void setFirstDieImage(ImageView dieImage){
        model.getDie(1).updateCurrentImagePath();
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
        model.getDie(2).updateCurrentImagePath();
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

    //action performed saker

    //denna ska ske när knappen trycks så kommer skiten att ha en animation


    public void rollAnimation(ImageView img1, ImageView img2) {
        try {
            for (int i = 0; i < 10; i++) {
                FileInputStream stream1 = new FileInputStream("src/main/resources/resources_img/dice/die" + (random.nextInt(6) + 1) + ".png");
                FileInputStream stream2 = new FileInputStream("src/main/resources/resources_img/dice/die" + (random.nextInt(6) + 1) + ".png");
                Image image1 = new Image(stream1);
                Image image2 = new Image(stream2);
                img1.setImage(image1);
                img2.setImage(image2);
                Thread.sleep(20);
            }
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
