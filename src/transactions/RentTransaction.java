package transactions;
import player.Player;
import property.ImproveProperty;

public class RentTransaction {
    public RentTransaction(Player player, ImproveProperty prop){
        player.pay(prop.getRent());
        prop.owner().receiveIncome(prop.getRent());
    }
}
