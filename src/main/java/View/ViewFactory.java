package View;

import Controllers.*;

import java.io.IOException;

public class ViewFactory {

    /**
     * Part of the ViewFactory. Creates the TremanView with its given controller.
     * @param controller
     * @return
     * @throws IOException
     */
    public static TremanView createTremanView(TremanController controller) throws IOException {
        return new TremanView(controller);
    }

    /**
     * Part of the ViewFactory. Creates the BaseLayerView with its given controller.
     * @param controller
     * @return
     * @throws IOException
     */
    public static BaseLayerView createBaseLayerView(BaseLayerController controller) throws IOException{
        return new BaseLayerView(controller);
    }

    /**
     * Part of the ViewFactory. Creates the GameChooseView with its given controller.
     * @param controller
     * @return
     * @throws IOException
     */
    public static GameChooseView createGameChooseView(GameChooseController controller) throws IOException {
        return new GameChooseView(controller);
    }

    /**
     * Part of the ViewFactory. Creates the HigherLowerView with its given controller.
     * @param controller
     * @return
     * @throws IOException
     */
    public static HigherLowerView createHigherLowerView(HigherLowerController controller) throws IOException{
        return new HigherLowerView(controller);
    }

    /**
     * Part of the ViewFactory. Creates the FTheDealerView with its given controller.
     * @param controller
     * @return
     * @throws IOException
     */
    public static FTheDealerView createFTheDealerView(FTheDealerController controller) throws IOException{
        return new FTheDealerView(controller);
    }

    /**
     * Part of the ViewFactory. Creates the OpusView with its given controller.
     * @param controller
     * @return
     * @throws IOException
     */

    public static OpusView createOpusView(OpusController controller) throws IOException {
        return new OpusView(controller);
    }

}
