package Controllers;

import View.AbstractView;
import View.IView;
import javafx.stage.Stage;

import java.util.HashMap;

public class SceneHandler {

    private final Stage root;
    private final HashMap<String, AbstractView> views = new HashMap<>();

    public SceneHandler(Stage stage){
        root = stage;
    }

    public void switchTo(String newViewName) {
        AbstractView newScene = views.get(newViewName.toLowerCase());
        switchScene(newScene);
    }

    public void switchScene(AbstractView view){
        root.setScene(view.getHydroScene());
        root.centerOnScreen();
        root.show();
    }

    public void addView(AbstractView view, String viewName){
        this.views.put(viewName.toLowerCase(), view);
    }
}
