package transactions;
import player.Player;
import property.*;
public class LuxuryTransaction {
    public LuxuryTransaction(Player player, TaxTiles prop, FreeParking freeParkingP){
        player.pay(prop.getFlatLuxaryTaxAmount());
        freeParkingP.freeParkingPool+=prop.getFlatLuxaryTaxAmount();
    }
}
