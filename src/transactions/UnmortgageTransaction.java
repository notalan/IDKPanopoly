/*
    Taking the un-mortgaging value at 10% original mortgage income
 */
package transactions;
import player.Player;
import property.*;
public class UnmortgageTransaction{
    public UnmortgageTransaction(Player player, Property prop ){
        player.pay(prop.getMortgageAmount() * 1.1);//using getRent bc there's no real need to make a new function
        player.removeMortgage(prop);
        prop.unMortgageProperty();
    }
}
