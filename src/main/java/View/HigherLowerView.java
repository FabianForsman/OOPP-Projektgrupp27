package View;

import Controllers.HigherLower.HigherLowerController;
import Controllers.SceneHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class HigherLowerView {

    private HigherLowerController controller;
    private FXMLLoader fxmlLoader;



    @FXML public AnchorPane cardGameAnchorPane;


    public HigherLowerView(HigherLowerController controller){
       // super(controller.getFXMLName());
        this.controller = controller;
    }
}
