package View;

import Controllers.*;

import java.io.IOException;

public class ViewFactory {

    public static TremanView createTremanView(TremanController controller) throws IOException {
        return new TremanView(controller);
    }

    public static BaseLayerView createBaseLayerView(BaseLayerController controller) throws IOException{
        return new BaseLayerView(controller);
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

    public static OpusView createOpusView(OpusController controller) throws IOException {
        return new OpusView(controller);
    }

}
