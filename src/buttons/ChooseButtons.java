package buttons;

import property.*;

import java.awt.*;
import java.util.List;

public class ChooseButtons {

    public List<Component> showButtons(Tile currentTile) {

        if (currentTile instanceof ImproveProperty) {
            return new PropertyButtons().showButtons();
        }
        else if(currentTile instanceof Go)
        {
            return new GoButtons().showButtons();
        }
        else if(currentTile instanceof Jail)
        {
            return new JailButtons().showButtons();
        }
        else if(currentTile instanceof  CardTIle)
        {
            return new CommunityChestButtons().showButtons();
        }
        else if(currentTile instanceof  CardTIle)
        {
            return new ChanceButtons().showButtons();
        }
        else if(currentTile instanceof Property)
        {
            return new UtilityButtons().showButtons();
        }
        else if(currentTile instanceof TaxTiles)
        {
            return new TaxButtons().showButtons();
        }

        return null;
    }
}
