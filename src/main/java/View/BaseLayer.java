package View;

import Controllers.BaseLayerController;
import Model.Player.IPlayer;
import Model.Player.Players;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;


import java.awt.*;
import java.io.IOException;

public class BaseLayer extends AbstractView {

    BaseLayerController controller;
    Players playerlist;

    @FXML
    ListView playerListView;

    public BaseLayer(BaseLayerController controller) throws IOException {
        super(controller.getFXMLName());
        this.controller = controller;
    }


    @FXML
    public void openChooseGame(){
        controller.openChooseGame();
    }

    @FXML private void addPlayer(ActionEvent e, IPlayer player) {
        //controller.addPlayer(player);
    }

    private void updatePlayerList() {

    }





}
