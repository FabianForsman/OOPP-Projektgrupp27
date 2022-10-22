package View;

import com.example.hydrohomies.HydroApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public abstract class AbstractView extends AnchorPane implements IView {

    final Scene scene;



    protected AbstractView(String fxmlName) throws IOException {
        FXMLLoader loader = HydroApplication.loadFXML(fxmlName);
        loader.setController(this);
        Parent root = loader.load();
        this.scene = new Scene(root);
    }

    @Override
    public Scene getHydroScene() {
        return this.scene;
    }
}