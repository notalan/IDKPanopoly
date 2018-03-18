package transactions;
import player.Player;
import property.Property;

public class RentTransaction {
    public RentTransaction(Player player, Property prop){
        player.payRent(prop.getRent());
        prop.owner().receiveIncome(prop.getRent());
    }
}
