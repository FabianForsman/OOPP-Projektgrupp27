package Controllers;

import Model.DiceGames.Treman.TremanModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BaseLayerController {
    SceneHandler handler;

    private Button addButton, removeButton;
    private Label chooseGameLabel;
    private AnchorPane rootAnchorPane;
    private TextField playerNameTextField;
    private ListView playerListView;

    private Button startGameButton;


    public BaseLayerController(SceneHandler handler) {
        this.handler = handler;
    }

    public void initializeButtons(Button startGameButton) {
        this.startGameButton = startGameButton;
    }

    public String getFXMLName() {
        return "base-layer";
    }


    public void openChooseGame() {
        handler.switchToMenu("GameChoose");
    }


    public void addPlayer(ListView<String> playerListView, TextField playerName){
        String name = playerName.getText();
        int playerListSize = Players.getInstance().getListSize();
        if(name.equals("")) {
            playerName.setText("Enter a name!");
        } else if (playerListSize < 8){
            if(!playerListView.getItems().contains(name)){
                playerListView.getItems().add(name);
                Players.getInstance().addPlayer(new Player(name));
            } else {
                playerName.setText("Player already exists, try again");
            }
        }
    }

    public void removeSelectedPlayer(ListView<String> playerListView){
        String playerName = playerListView.getSelectionModel().getSelectedItem();
        IPlayer selectedPlayer = Players.getInstance().getPlayer(playerName);
        playerListView.getItems().remove(playerName);

        Players.getInstance().removePlayer(selectedPlayer);
    }



    public void checkIfPlayerAmountAllowed(){
        int playerListSize = Players.getInstance().getListSize();
        if(playerListSize > 1){
            startGameButton.setVisible(true);
            startGameButton.setDisable(false);
        }
    }


}
