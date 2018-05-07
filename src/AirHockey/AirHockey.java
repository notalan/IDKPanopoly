package AirHockey;

import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AirHockey extends JFrame{
    Player PLAYER;

    public AirHockey(Player player)
    {
        this.PLAYER = player;
        setBoard();
    }

    public void setBoard()
    {
        final DrawBoard table_panel = new DrawBoard(PLAYER);

        final JFrame table = new JFrame("Air Hockey");
        table.setPreferredSize(new Dimension(400, 650));
        table.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        table.setUndecorated(true);
        table.add(table_panel);
        table.pack();
        table.setVisible(true);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table_panel.isGameOver())
                {
                    table.dispose();
                }
            }
        };

        Timer timer = new Timer(100, listener);
        timer.start();
    }
}
