package transactions;
import player.Player;
import property.*;
public class LuxuryTransaction {
    public LuxuryTransaction(Player player, TaxTiles prop){
        player.pay(prop.getFlatLuxaryTaxAmount());
    }
}
