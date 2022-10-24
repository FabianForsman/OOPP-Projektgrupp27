package View;

import Controllers.BaseLayerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.IOException;

/**
 * Author: Fabian Forsman
 * Author: Daniel Malmgren
 */

public class BaseLayerView extends AbstractView {

    private BaseLayerController controller;
    @FXML ListView<String> playerListView;
    @FXML TextField playerNameTextField;
    @FXML Button startGameButton;

    /**
     * Constructor for BaseLayerView. Sets its controller and initializes necessary view-objects.
     * Passes the controllers name to AbstractView
     * @param controller
     * @throws IOException
     */
    public BaseLayerView(BaseLayerController controller) throws IOException {
        super(controller.getFXMLName());
        this.controller = controller;
        initialize();
        startGameButton.setVisible(false);
        startGameButton.setDisable(true);    }

    /**
     * Initializes necessary view-objects.
     */
    private void initialize(){
        controller.initializeButtons(startGameButton);

    }

    @FXML
    public void openChooseGame(){
        controller.openChooseGame();
    }

    @FXML
    private void addPlayer(ActionEvent e) {
        controller.checkIfPlayerAmountAllowed();
        controller.addPlayer(playerListView, playerNameTextField);
    }

    @FXML
    private void removePlayer(ActionEvent e){
        controller.removeSelectedPlayer(playerListView);
    }

}
