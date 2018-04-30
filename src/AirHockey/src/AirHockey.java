package AirHockey.src;

import javax.swing.*;
import java.awt.*;

public class AirHockey {

    public AirHockey()
    {
        setBoard();
    }

    public void setBoard()
    {
        DrawBoard table_panel = new DrawBoard();

        JFrame table = new JFrame("Air Hockey");
        table.setPreferredSize(new Dimension(400, 650));
        table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table.setUndecorated(true);
        table.add(table_panel);
        table.pack();
        table.setVisible(true);
    }
}
