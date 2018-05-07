package AirHockey;

import player.Player;

import javax.swing.*;
import java.awt.*;

public class AirHockey extends JFrame{
    Player PLAYER;

    public AirHockey(Player player)
    {
        setBoard();
        this.PLAYER = player;
    }

    public void setBoard()
    {
        DrawBoard table_panel = new DrawBoard(PLAYER);

        JFrame table = new JFrame("Air Hockey");
        table.setPreferredSize(new Dimension(400, 650));
        table.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        table.setUndecorated(true);
        table.add(table_panel);
        table.pack();
        table.setVisible(true);

        if(table_panel.isGameOver())
        {
            this.dispose();
        }
    }
}
