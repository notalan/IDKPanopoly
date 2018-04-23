package buttons;

import player.Player;
import property.*;

import java.awt.*;
import java.util.List;

public class ChooseButtons {

    public List<Component> showButtons(Tile currentTile, Player currentPlayer, Player[] list) {

        if (currentTile instanceof ImproveProperty) {
            return new PropertyButtons().showButtons((ImproveProperty) currentTile, currentPlayer);
        }
        else if(currentTile instanceof Go)
        {
            return new GoButtons().showButtons(currentPlayer);
        }
        else if(currentTile instanceof Jail)
        {
            return new JailButtons().showButtons(currentPlayer);
        }
        else if(currentTile instanceof  CardTIle)
        {
            return new CommunityChestButtons().showButtons(currentPlayer, list);
        }
        else if(currentTile instanceof  CardTIle)
        {
            return new ChanceButtons().showButtons(currentPlayer, list);
        }
        else if(currentTile instanceof TaxTiles)
        {
            return new TaxButtons().showButtons((TaxTiles)currentTile, currentPlayer);
        }
        else if(currentTile instanceof StationTile)
        {
            return new GoButtons().showButtons(currentPlayer);
        }

        return null;
    }
}
