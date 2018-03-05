package transactions;
import player.Player;
import property.*;
public class SellHotelTransaction {
    SellHotelTransaction(Player player, ImproveProperty prop){
        player.receiveIncome(prop.housePrice()/2);
        prop.sellHotel();
    }
}
