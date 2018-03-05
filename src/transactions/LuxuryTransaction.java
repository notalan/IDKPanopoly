package transactions;
import player.Player;
import property.*;
public class LuxuryTransaction {
    LuxuryTransaction(Player player, TaxTiles prop){
        player.payRent(prop.getFlatLuxaryTaxAmount());
    }
}
