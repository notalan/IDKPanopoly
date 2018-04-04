package transactions;

import player.Player;
import property.ImproveProperty;

public class BuildHotelTransaction {
    public BuildHotelTransaction(Player player, ImproveProperty prop){
        player.pay(prop.housePrice());
        prop.buildHotel();
    }
}
