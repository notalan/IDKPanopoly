package transactions;
import player.Player;
import property.*;
public class SellHouseTransaction {
    SellHouseTransaction(Player player, ImproveProperty prop){
        player.receiveIncome(prop.housePrice()/2);
        prop.sellHouse();
    }
}
