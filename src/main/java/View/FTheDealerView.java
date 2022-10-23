package View;

import Controllers.FTheDealerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FTheDealerView extends AbstractGameView {
    private FTheDealerController controller;
    private FXMLLoader fxmlLoader;

    @FXML private AnchorPane fTheDealerAnchorPane;

    public FTheDealerView(FTheDealerController controller) throws IOException {
        super(controller.getFXMLName());
        this.controller = controller;
    }

    @Override
    public void update() {

    }
}
