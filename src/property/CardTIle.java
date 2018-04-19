package property;

import player.Player;

public class CardTIle extends Tile implements Actionable, Cardable {

    public CardTIle(int xco, int yco) {
        super.XCO = xco;
        super.YCO = yco;
    }

    @Override
    public boolean performActionOn(Player p) {
        // ignore this. Cant be done until cards is done

//        if (card = int)
//            return __
//
//        if (card = boolean)
//            return ___
//
        return false;
    }

    @Override
    public String explainAction() {
        return null;
    }

    @Override
    public Actionable getCardAction() {
        return null;
    }
}
