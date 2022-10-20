package View;

import Controllers.Treman.TremanController;
import com.example.hydrohomies.UIController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StartPageView extends AnchorPane {
    @FXML public AnchorPane tremanGameAnchorPane;

    private UIController parentController;

    public StartPageView(TremanController controller) {
        this.parentController = parentController;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartPage.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(controller);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
