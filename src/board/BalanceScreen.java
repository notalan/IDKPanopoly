package board;
import player.Player;
import javax.swing.*;
import java.awt.*;

public class BalanceScreen extends JPanel{
    public BalanceScreen(Player[] player_balances) {
        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0, 100)));
        JLabel player1 = new JLabel(player_balances[0].name() + "'s balance: ");
        player1.setForeground(Color.white);
        JLabel player1_bal = new JLabel("SD$" + player_balances[0].balance());
        player1_bal.setForeground(Color.white);
        setPreferredSize(new Dimension(200, 720));
        player1.setAlignmentX(Component.CENTER_ALIGNMENT);
        player1_bal.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(player1);
        add(player1_bal);

        add(Box.createRigidArea(new Dimension(0, 100)));

        JLabel player2 = new JLabel(player_balances[1].name() + "'s balance: ");
        player2.setForeground(Color.CYAN);
        JLabel player2_bal = new JLabel("SD$" + player_balances[1].balance());
        player2_bal.setForeground(Color.CYAN);
        player2.setAlignmentX(Component.CENTER_ALIGNMENT);
        player2_bal.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(player2);
        add(player2_bal);

        add(Box.createRigidArea(new Dimension(0, 100)));

        JLabel player3 = new JLabel(player_balances[2].name() + "'s balance: ");
        player3.setForeground(Color.YELLOW);
        JLabel player3_bal = new JLabel("SD$" + player_balances[2].balance());
        player3_bal.setForeground(Color.YELLOW);
        player3.setAlignmentX(Component.CENTER_ALIGNMENT);
        player3_bal.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(player3);
        add(player3_bal);

        add(Box.createRigidArea(new Dimension(0, 100)));

        JLabel player4 = new JLabel(player_balances[3].name() + "'s balance: ");
        player4.setForeground(Color.RED);
        JLabel player4_bal = new JLabel("SD$" + player_balances[3].balance());
        player4_bal.setForeground(Color.RED);
        player4.setAlignmentX(Component.CENTER_ALIGNMENT);
        player4_bal.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(player4);
        add(player4_bal);
    }
}
