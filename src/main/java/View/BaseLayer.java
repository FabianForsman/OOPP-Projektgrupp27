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

public class BaseLayer extends AnchorPane {

    @FXML public Button startGameButton;
    @FXML public AnchorPane baseAnchorPane, stickAnchorPane;

    private UIController parentController;

    public BaseLayer(UIController parentController){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("base-layer.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        }








    //den här måste vara kvar av någon anledning för att
    //programmet vägrar koppla till UIController av någon anledning?
}
