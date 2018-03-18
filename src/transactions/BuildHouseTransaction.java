package transactions;

import player.Player;
import property.ImproveProperty;

public class BuildHouseTransaction {
    public BuildHouseTransaction(Player player, ImproveProperty prop){
        player.build(prop.housePrice());//takes house price from player
        prop.buildHouse();
    }
}
