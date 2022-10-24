package com.example.hydrohomies;

import Controllers.*;
import Model.Player.Player;
import Model.Player.Players;
import View.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;


public class HydroApplication extends Application {


    SceneHandler sceneHandler;

    @Override
    public void start(Stage stage) throws Exception{
        sceneHandler = new SceneHandler(stage);
        BaseLayerController baseC = new BaseLayerController(sceneHandler);
        GameChooseController gameChooseC = new GameChooseController(sceneHandler);
        TremanController tremanC = new TremanController(sceneHandler);
        HigherLowerController higherLowerC = new HigherLowerController(sceneHandler);
        FTheDealerController fTheDealerC = new FTheDealerController(sceneHandler);
        OpusController opusC = new OpusController(sceneHandler);

        sceneHandler.addView(ViewFactory.createBaseLayerView(baseC), "base-layer");
        sceneHandler.addView(ViewFactory.createGameChooseView(gameChooseC), "gamechoose");
        sceneHandler.addView(ViewFactory.createTremanView(tremanC), "treman");
        sceneHandler.addView(ViewFactory.createHigherLowerView(higherLowerC), "higherlower");
        sceneHandler.addView(ViewFactory.createFTheDealerView(fTheDealerC),"fthedealer");
        sceneHandler.addView(ViewFactory.createOpusView(opusC), "opus");

        sceneHandler.switchToMenu("base-layer");
    }


    public static FXMLLoader loadFXML(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(HydroApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    public static void main(String[] args) {
        //Players.getInstance().addPlayer(new Player("p1"));
        //Players.getInstance().addPlayer(new Player("p2"));
        launch(args);

    }

}