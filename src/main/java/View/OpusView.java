package View;

import Controllers.OpusController;

import java.io.IOException;

/**
 * Daniel Malmgren
 */

public class OpusView extends AbstractGameView{
    OpusController controller;

    /**
     * Constructor for OpusView. Passes the controllers name to AbstractGameView.
     * @param controller
     * @throws IOException
     */
    public OpusView(OpusController controller) throws IOException {
        super(controller.getFXMLName());
        this.controller = controller;
    }

    @Override
    public void update() {

    }
}
