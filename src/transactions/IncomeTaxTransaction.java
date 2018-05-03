/*
    If choice == true then take flat, otherwise take percentage.
 */
package transactions;
import player.Player;
import property.*;
public class IncomeTaxTransaction {
    public IncomeTaxTransaction(Player player, TaxTiles prop, boolean choice, FreeParking freeParkingP){
        if(choice) {
            player.pay(prop.getFlatIncomeTaxAmount());
            freeParkingP.freeParkingPool += prop.getFlatIncomeTaxAmount();
        }
        else
        {
            player.pay(player.balance() * prop.getIncomeTaxPercentage());
            freeParkingP.freeParkingPool += player.balance() * prop.getIncomeTaxPercentage();
        }

    }
}
