/*
    Taking the un-mortgaging value at 10% original mortgage income
 */
package transactions;
import player.Player;
import property.*;

import javax.swing.*;

public class UnmortgageTransaction{
    public UnmortgageTransaction(Player player, Property prop ){
        if(player.balance() < prop.getMortgageAmount() * 1.1)
        {
            JOptionPane.showMessageDialog(null, "Insufficient balance to unmortgage property.");
        }
        else
        {
            player.pay(prop.getMortgageAmount() * 1.1);//using getRent bc there's no real need to make a new function
            player.removeMortgage(prop);
            prop.unMortgageProperty();
        }
    }
}
