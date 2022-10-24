package View;

import Controllers.HigherLowerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HigherLowerView extends AbstractGameView {

    private HigherLowerController controller;

    /**
     * Constructor for HigherLowerView. Passes the controllers name to AbstractGameView.
     * @param controller
     * @throws IOException
     */
    public HigherLowerView(HigherLowerController controller) throws IOException {
        super(controller.getFXMLName());
        this.controller = controller;
    }

    @Override
    public void update() {

    }
}
