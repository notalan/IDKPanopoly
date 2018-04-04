package transactions;

import player.Player;
import property.Property;

public class IncomeTransaction {
    public IncomeTransaction(Player player, double amount) {
        player.receiveIncome(amount);
    }
}
