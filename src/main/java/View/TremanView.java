package View;

import Controllers.Treman.TremanController;
import com.example.hydrohomies.UIController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Random;

public class TremanView extends AnchorPane {
    @FXML public AnchorPane tremanGameAnchorPane;

    private UIController parentController;
    private TremanController tremanController;
    public TremanView(UIController parentController, TremanController tremanController ) {
        this.parentController = parentController;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Treman.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(tremanController);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
