package View;

import Controllers.BaseLayerController;
import Controllers.FTheDealer.FTheDealerController;
import Controllers.GameChooseController;
import Controllers.HigherLower.HigherLowerController;
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

    public static HigherLowerView createHigherLowerView(HigherLowerController controller) throws IOException{
        return new HigherLowerView(controller);
    }

    public static FTheDealerView createFTheDealerView(FTheDealerController controller) throws IOException{
        return new FTheDealerView(controller);
    }



}
