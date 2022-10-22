package View;

import Controllers.HigherLower.HigherLowerController;
import Controllers.SceneHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HigherLowerView extends AbstractView {

    private HigherLowerController controller;
    private FXMLLoader fxmlLoader;



    @FXML public AnchorPane cardGameAnchorPane;


    public HigherLowerView(HigherLowerController controller) throws IOException {
        super(controller.getFXMLName());
        this.controller = controller;
    }
}
