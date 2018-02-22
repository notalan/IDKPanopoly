package transactions;

import player.Player;
import property.ImproveProperty;

public class BuildHotelTransaction {
    BuildHotelTransaction(Player player, ImproveProperty prop){
        player.build(prop.housePrice());
        prop.buildHotel();
    }
}