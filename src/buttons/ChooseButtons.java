package buttons;

import java.awt.*;
import java.util.List;

public class ChooseButtons {

    public List<Component> showButtons() {

        boolean isProperty = false, isJail = true, isGo = false;

        if (isProperty) {
            return new PropertyButtons().showButtons();
        }
        else if(isGo)
        {
            return new GoButtons().showButtons();
        }
        else if(isJail)
        {
            return new JailButtons().showButtons();
        }

        return null;
    }
}
