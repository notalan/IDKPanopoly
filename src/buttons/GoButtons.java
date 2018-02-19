package buttons;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GoButtons extends Button{

    public List<Component> showButtons()
    {
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());

        return buttonList;
    }
}
