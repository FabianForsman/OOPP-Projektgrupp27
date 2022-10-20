package Controllers.Treman;
import Model.DiceGames.Treman.Actions.ChallengeAction;
import Model.DiceGames.Treman.Actions.EqualsAction;
import Model.DiceGames.Treman.Actions.NewTremanAction;
import Model.DiceGames.Treman.TremanModel;
import Model.Player.IPlayer;
import Model.Player.Players;
import View.TremanView;
import com.example.hydrohomies.HydroApplication;
import com.example.hydrohomies.UIController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


public class TremanController implements Initializable{
    TremanModel model;
    TremanView view;

    Random random = new Random();
    private UIController parentController;

    @FXML public ImageView diceTremanMenuButtonImageView;
    @FXML public  Label challengeLabel;
    @FXML public ImageView diceRightTremanImageView;
    @FXML public ImageView diceLeftTremanImageView;

    @FXML public ComboBox<IPlayer> playerComboBox;
    @FXML public ListView<String> playerListView;
    @FXML public ListView<String> selectedPlayersListView;

    @FXML public Button tremanRollButton;
    @FXML public Button challengeRollButton;
    @FXML public Button rollDiceButton;
    @FXML public AnchorPane playerListPane;
    @FXML public AnchorPane boardPane;
    @FXML public AnchorPane tremanGameAnchorPane;

    @FXML public ImageView topLeftDice;
    @FXML public ImageView firstDieImage = new ImageView();
    @FXML public ImageView secondDieImage;

    @FXML public Label actionMessageLabel;
    @FXML public Label currentPlayerLabel;
    @FXML public Label currentTremanLabel;


    public TremanController(UIController parentController) {
        this.parentController = parentController;
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Treman.fxml"));
        //fxmlLoader.setRoot(tremanGameAnchorPane);
        //fxmlLoader.setController(this);
        model = new TremanModel();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populatePlayerList();

    }


    public void displayActionMessage() {
        actionMessageLabel.setText(model.getRule());
    }

    public void setCurrentPlayerLabel(String name) {
        currentPlayerLabel.setText(name);
    }

    public void setCurrentChallengedPlayerLabel(String name) {
        // currentChallengedPlayerLabel.setText(name);
    }

    public void setCurrentTremanLabel(String name) {
        currentTremanLabel.setText(name);
    }

    public void displaySelectedPlayer(String name) {
        selectedPlayersListView.getItems().add(name);
        selectedPlayersListView.setVisible(true);
    }

    public void removeSelectedPlayers() {
        selectedPlayersListView.getItems().clear();
        selectedPlayersListView.setVisible(false);
    }

    @FXML //For roll-button for the challenged player.
    public void displayChallengeButton() {
        challengeRollButton.setVisible(true);
    }

    public void removeChallengeButton() {
        challengeRollButton.setVisible(false);
    }

    @FXML //Select multiple players in playerComboBox
    public void selectPlayer(IPlayer player) {
        if(model.getAction() instanceof ChallengeAction action) {
            action.setChallengedPlayer(player);
            String name = action.getChallengedPlayer().getName();
            displaySelectedPlayer(name);
            closePlayerListView();
        }
        else if(model.getAction() instanceof EqualsAction action) {
            action.addPlayerToPlayerList(player);
            String name = player.getName();
            displaySelectedPlayer(name);
            if(action.getPlayerList().size() >= 2) {
                closePlayerListView();
            }
        }
        else if(model.getAction() instanceof NewTremanAction action) {
            action.setNewTreman(player);
            String name = model.getTreman().getName();
            setCurrentTremanLabel(name);
        }
    }

    @FXML //For rollDiceButton
    public void rollDice() {
        model.getDice().rollAllDice();
        displayActionMessage();
        removeSelectedPlayers();
    }

    @FXML // For challengeButton
    public void rollDie(int i) {
        model.getDice().rollDie(model.getDie(i));
    }


    @FXML // Setting the correct image for the first die based on roll
    public void setFirstDieImage(){
        model.getDie(1).updateCurrentImagePath();
        InputStream stream = null;
        try {
            stream = new FileInputStream(model.getDie(0).getCurrentImagePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(stream);
        firstDieImage.setImage(image);

    }


    @FXML // Setting the correct image for the second die based on roll
    public void setSecondDieImage(){
        model.getDie(2).updateCurrentImagePath();
        InputStream stream = null;
        try {
            stream = new FileInputStream(model.getDie(1).getCurrentImagePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(stream);
        secondDieImage.setImage(image);
    }

    @FXML // Opens the window with the player list
    public void openPlayerListView(){
        playerListPane.toFront();
    }

    @FXML // Closes the window with the player list
    public void closePlayerListView(){
        boardPane.toFront();
    }

    public void populatePlayerList(){
        playerComboBox.getItems().clear();
        for(IPlayer player : Players.getInstance().getPlayersList()) {
            playerComboBox.getItems().add(player);
        }


    }

    //action performed saker

    //denna ska ske när knappen trycks så kommer skiten att ha en animation

    @FXML
    public void roll2(ActionEvent e2) {
        System.out.println("roll2 worked");
        for(int i = 0; i < 10; i++) {
            InputStream stream = null;
            try {
                stream = new FileInputStream("src/main/resources/resources_img/dice/die1.png");
            } catch (FileNotFoundException a) {
                a.printStackTrace();
            }
            Image image = new Image(stream);
            diceLeftTremanImageView.setImage(image);
            diceRightTremanImageView.setImage(image);
        }
    }


    @FXML public void roll(ActionEvent e) {


        Thread thread = new Thread() {
            {
                System.out.println("Thread Running");
                for(int i = 0; i < 15; i++){
                    InputStream stream = null;
                    try {
                        stream = new FileInputStream("src/main/resources/resources_img/dice/die1.png");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    Image image = new Image(stream);
                    diceLeftTremanImageView.setImage(image);
                    diceRightTremanImageView.setImage(image);
                }
            }
        };

        thread.start();

        /* när det kommer en etta eller en utmaning (två av varje tal) så kör denna*/
        //model för när utmaning körs någon jävla om två av samma displayas kör den här koden
        //basically en observer som signaliserar
        //playerListView(); to front eller något samt labelen to front
        //sen ska man initiera att det går att trycka på knapparna osv osv genom en actionevent

    }

    @FXML public void roll3(ActionEvent e) {


        Thread thread = new Thread() {
            public void run() {
                System.out.println("Thread Running");
                try {
                    for (int i = 0; i < 15; i++){
                        InputStream stream = new FileInputStream("src/main/resources/resources_img/dice/die1.png");
                        Image image = new Image(stream);
                        diceLeftTremanImageView.setImage(image);
                        diceRightTremanImageView.setImage(image);
                        Thread.sleep(50);
                    }

                } catch (FileNotFoundException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        thread.start();
    }

}
