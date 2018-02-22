package transactions;
import player.Player;
import property.Property;

public class RentTransaction {
    RentTransaction(Player player, Property prop){
        player.payRent(prop.getRent());
        prop.owner().receiveIncome(prop.getRent());
    }
}
