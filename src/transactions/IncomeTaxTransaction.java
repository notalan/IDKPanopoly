/*
    If choice == true then take flat, otherwise take percentage.
 */
package transactions;
import player.Player;
import property.*;
public class IncomeTaxTransaction {
    public IncomeTaxTransaction(Player player, TaxTiles prop, boolean choice){
        if(choice)
            player.payRent(prop.getFlatIncomeTaxAmount());
        else
            player.payRent(player.balance() * prop.getIncomeTaxPercentage());
    }
}
