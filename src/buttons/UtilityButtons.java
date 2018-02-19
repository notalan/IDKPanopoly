package buttons;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UtilityButtons extends PropertyButtons{
    public List<Component> showButtons()
    {
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());
        buttonList.add(makeBuy());
        buttonList.add(makeAuction());
        buttonList.add(makePayRent());
        buttonList.add(makeSell());
        buttonList.add(makeMortgage());
        return buttonList;
    }
}
