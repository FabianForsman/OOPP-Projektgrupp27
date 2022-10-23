package View;

import java.io.IOException;

public abstract class AbstractGameView extends AbstractView{

    public AbstractGameView(String fxmlName) throws IOException {
        super(fxmlName);
    }

    public abstract void update();

}
