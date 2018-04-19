package buttons;

import player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GoButtons extends Buttons{
    public List<Component> showButtons(Player currentPlayer) {
        PLAYER = currentPlayer;
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());

        return buttonList;
    }

}
