package com.example.hydrohomies;

import Model.Player.Player;
import Model.Player.Players;
import View.ViewFactory;
import com.example.hydrohomies.SceneBuilderRunLogic.HydroHomieDataHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

public class HydroApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception{


        sceneHandler = new SceneHandler(stage);

        TremanController tremanC = new TremanController(sceneHandler);
        BaseLayerController baseC = new BaseLayerController(sceneHandler);
        GameChooseController gameChooseC = new GameChooseController(sceneHandler);
        HigherLowerController higherLowerC = new HigherLowerController(sceneHandler);
        FTheDealerController fTheDealerC = new FTheDealerController(sceneHandler);

        sceneHandler.addView(ViewFactory.createTremanView(tremanC), "treman");
        sceneHandler.addView(ViewFactory.createBaseLayerView(baseC), "base-layer");
        sceneHandler.addView(ViewFactory.createGameChooseView(gameChooseC), "gamechoose");
        sceneHandler.addView(ViewFactory.createHigherLowerView(higherLowerC), "higherlower");
        //sceneHandler.addView(ViewFactory.createFTheDealerView(fTheDealerC),"fthedealer");

        //sceneHandler.addScene(HyroSceneFactory.rentingPage(new MyListingsController(sceneHandler)), "rentingpage");


        //gitblame
        sceneHandler.switchTo("base-layer");

    }
    public static FXMLLoader loadFXML(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(HydroApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    public static void main(String[] args) {
        Players.getInstance().addPlayer(new Player("p1"));
        Players.getInstance().addPlayer(new Player("p2"));
        launch(args);

    }

}