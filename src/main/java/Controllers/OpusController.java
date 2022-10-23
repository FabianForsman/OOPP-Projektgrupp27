package Controllers;

import Model.DiceGames.Opus.OpusModel;

public class OpusController implements IController{


    private SceneHandler handler;
    OpusModel model;

    public OpusController(SceneHandler handler) {
        model = new OpusModel();
        this.handler = handler;

    }

    public void roll(){
        //model.
    }


    @Override
    public String getFXMLName() {
        return null;
    }
}
