package transactions;

import player.Player;

public class ExpenditureTransaction {
    public ExpenditureTransaction(Player player, double amount) {
        player.pay(amount);
    }
}
