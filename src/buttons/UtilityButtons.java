package buttons;

import player.Player;
import property.Property;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UtilityButtons extends PropertyButtons{
    public List<Component> showButtons(Property currentTile, Player currentPlayer)
    {
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());
        if (!currentTile.hasOwner())
        {
            buttonList.add(makeBuy());
            buttonList.add(makeAuction());
        }

        if(currentTile.hasOwner() && currentTile.owner().equals(currentPlayer.name()))
        {
            buttonList.add(makeSell());
            buttonList.add(makeMortgage());
        }

        if(currentTile.hasOwner() && !currentTile.owner().equals(currentPlayer.name()))
        {
            buttonList.add(makePayRent());
        }

        return buttonList;
    }
}
