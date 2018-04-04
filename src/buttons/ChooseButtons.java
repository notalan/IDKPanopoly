package buttons;

import player.Player;
import property.*;

import java.awt.*;
import java.util.List;

public class ChooseButtons {

    public List<Component> showButtons(Tile currentTile, Player currentPlayer) {

        if (currentTile instanceof ImproveProperty) {
            return new PropertyButtons().showButtons((ImproveProperty) currentTile, currentPlayer);
        }
        else if(currentTile instanceof Go)
        {
            return new GoButtons().showButtons(currentTile);
        }
        else if(currentTile instanceof Jail)
        {
            return new JailButtons().showButtons(currentTile);
        }
        else if(currentTile instanceof  CardTIle)
        {
            return new CommunityChestButtons().showButtons(currentTile);
        }
        else if(currentTile instanceof  CardTIle)
        {
            return new ChanceButtons().showButtons(currentTile);
        }
        else if(currentTile instanceof Property)
        {
            return new UtilityButtons().showButtons((Property) currentTile, currentPlayer);
        }
        else if(currentTile instanceof TaxTiles)
        {
            return new TaxButtons().showButtons(currentTile);
        }

        return null;
    }
}
