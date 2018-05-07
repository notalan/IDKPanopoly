package transactions;

import AI.IntermediateAI;
import player.Player;
import property.ImproveProperty;
import property.Property;
import property.Tile;

import javax.swing.*;

public class Auction {
    ImproveProperty tile;
    double bid;
    Player highestBidder;
    IntermediateAI A;

    public Auction(ImproveProperty CurrentTile, Player[] players)
    {
        this.tile = CurrentTile;
        this.bid = 0.0;
        start(players);
    }

    public void bid(Player player, Player[] players) {
        double new_bid;
        if (player.isAI()) {
            A = new IntermediateAI(player, players);//auction specific AI
            new_bid = A.auctionStrategise(tile, bid);
            System.out.println(new_bid);
        } else {
            try {
                new_bid = Double.parseDouble(JOptionPane.showInputDialog(player.name() + ", Enter your bid"));
            } catch (Exception e) {
                new_bid = 0.0;
                JOptionPane.showMessageDialog(null, "Invalid bid");
            }
        }

        if (new_bid != 0.0) {
            if(new_bid < bid)
            {
                JOptionPane.showMessageDialog(null, "Invalid bid");
            }
            else if(player.balance() < new_bid)
            {
                JOptionPane.showMessageDialog(null, "You can't afford to bid that much!");
            }
            else
            {
                bid = new_bid;
                highestBidder = player;
                JOptionPane.showMessageDialog(null, "Highest bid is now: " + bid);
            }
        }
    }

    public void start(Player[] players)
    {
        JOptionPane.showMessageDialog(null, "Auction rules: Each player gets 2 bids, the highest bidder wins!");

        for(int i = 0; i < players.length*2; i++)
        {
            bid(players[i % players.length], players);
        }

        JOptionPane.showMessageDialog(null, "Auction over: " + highestBidder.name() + " won with a bid of " + bid);

        new BuyTransaction(highestBidder, tile, bid);
    }
}
