package View;

import Controllers.FTheDealer.FTheDealerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FTheDealerView extends AbstractView {
    private FTheDealerController controller;
    private FXMLLoader fxmlLoader;

    @FXML private AnchorPane fTheDealerAnchorPane;

    public FTheDealerView(FTheDealerController controller) throws IOException {
        super(controller.getFXMLName());
        this.controller = controller;
    }
}
