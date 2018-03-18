package transactions;
import player.Player;
import property.*;
public class SellHotelTransaction {
    public SellHotelTransaction(Player player, ImproveProperty prop){
        player.receiveIncome(prop.housePrice()/2);
        prop.sellHotel();
    }
}
