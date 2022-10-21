package View;

import Controllers.BaseLayerController;
import Controllers.GameChooseController;
import Controllers.Treman.TremanController;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    public static TremanView createTremanView(TremanController controller) throws IOException {
        return new TremanView(controller);
    }

    public static BaseLayer createBaseLayerView(BaseLayerController controller) throws IOException{
        return new BaseLayer(controller);
    }


    public static GameChooseView createGameChooseView(GameChooseController controller) throws IOException {
        return new GameChooseView(controller);
    }



}
