package buttons;

import java.awt.*;
import java.util.List;

public class ChooseButtons {

    public List<Component> showButtons() {

        boolean isProperty = false, isJail = true, isGo = false,
                isCommunityChest = false, isChance = false,
                isUtility = false, isIncomeTax = false, isFreeParking = false,
                isGoToJail = false, isLuxuryTax = false;

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
        else if(isCommunityChest)
        {
            return new CommunityChestButtons().showButtons();
        }
        else if(isChance)
        {
            return new ChanceButtons().showButtons();
        }
        else if(isUtility)
        {
            return new UtilityButtons().showButtons();
        }
        else if(isIncomeTax)
        {
            return new IncomeTaxButtons().showButtons();
        }
        else if(isLuxuryTax)
        {
            return new LuxuryTaxButtons().showButtons();
        }
        else if(isFreeParking)
        {
            return new FreeParkingButtons().showButtons();
        }
        else if(isGoToJail)
        {
            return new GoToJailButtons().showButtons();
        }

        return null;
    }
}
