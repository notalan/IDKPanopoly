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
<<<<<<< Updated upstream
            return new GoButtons().showButtons(currentPlayer);
        }
        else if(currentTile instanceof Jail)
        {
            return new JailButtons().showButtons(currentPlayer);
        }
        else if(currentTile instanceof  CardTIle)
        {
            return new CommunityChestButtons().showButtons(currentPlayer);
        }
        else if(currentTile instanceof  CardTIle)
        {
            return new ChanceButtons().showButtons(currentPlayer);
=======
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
>>>>>>> Stashed changes
        }
        else if(currentTile instanceof TaxTiles)
        {
<<<<<<< Updated upstream
            return new TaxButtons().showButtons((TaxTiles)currentTile, currentPlayer);
=======
            return new UtilityButtons().showButtons((Property) currentTile, currentPlayer);
>>>>>>> Stashed changes
        }
        else if(currentTile instanceof StationTile)
        {
<<<<<<< Updated upstream
            return new GoButtons().showButtons(currentPlayer);
=======
            return new TaxButtons().showButtons(currentTile);
>>>>>>> Stashed changes
        }

        return null;
    }
}
