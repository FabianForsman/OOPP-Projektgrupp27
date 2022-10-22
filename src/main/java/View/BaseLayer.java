package View;

import com.example.hydrohomies.UIController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.IOException;

public class BaseLayer extends AbstractView {

    BaseLayerController controller;

    public BaseLayer(BaseLayerController controller) throws IOException {
        super(controller.getFXMLName());
        this.controller = controller;
    }


    @FXML
    public void openChooseGame(){
        controller.openChooseGame();
    }


}
