package View;

import Controllers.OpusController;

import java.io.IOException;

public class OpusView extends AbstractGameView{
    OpusController controller;

    public OpusView(OpusController controller) throws IOException {
        super(controller.getFXMLName());
        this.controller = controller;
    }

    @Override
    public void update() {

    }
}
