package transactions;


import player.Player;
import property.Property;

public class MortgageTransaction {
    MortgageTransaction(Player player, Property prop){
        player.receiveIncome(prop.getMortgageAmount());
        prop.mortgageProperty();
    }
}
