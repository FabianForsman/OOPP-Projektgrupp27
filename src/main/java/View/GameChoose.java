package View;

import Controllers.Treman.TremanController;
import com.example.hydrohomies.UIController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GameChoose extends AnchorPane {
    private UIController parentController;

    public GameChoose(UIController parentController, GameChoose gameChoose ) {
        this.parentController = parentController;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameChoose.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(gameChoose);

    }


}
