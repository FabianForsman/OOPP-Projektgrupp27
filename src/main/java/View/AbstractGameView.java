package View;

import java.io.IOException;

public abstract class AbstractGameView extends AbstractView{

    /**
     * Constructor for the abstract class AbstractGameView
     * @param fxmlName
     * @throws IOException
     */
    protected AbstractGameView(String fxmlName) throws IOException {
        super(fxmlName);
    }

    public abstract void update();

}
