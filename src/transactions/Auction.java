package transactions;

import property.Tile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Auction {
    Tile tile;
    double bid;

    public Auction(Tile CurrentTile)
    {
        this.tile = CurrentTile;
        this.bid = 0.0;
    }

    public void bid()
    {
        double new_bid = 0.0;

        new_bid = Double.parseDouble(JOptionPane.showInputDialog("Enter your bid"));

        if(new_bid != 0.0)
        {
            if(new_bid < bid)
            {
                JOptionPane.showMessageDialog(null, "Invalid bid");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Highest bid is now: " + bid);
            }
        }
    }

    public void start()
    {
        int delay = 1000;
        int time[] = {0};

        ActionListener incTime = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                time[0] += 1;
            }
        };

        new Timer(delay, incTime);

        if(time[0] >= 30)
        {
            JOptionPane.showMessageDialog(null,"Auction over!");
        }

        while(time[0] >= 30)
        {
            bid();
        }
    }
}
