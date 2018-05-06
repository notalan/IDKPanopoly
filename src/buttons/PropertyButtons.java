package buttons;

import player.Player;
import property.ImproveProperty;
import transactions.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class PropertyButtons extends Buttons {

    //    private Player PLAYER;
    private ImproveProperty TILE;
    private Player[] PLAYER_ARR;

    public List<Component> showButtons(ImproveProperty currentTile, Player currentPlayer, Player[] players) {
        PLAYER = currentPlayer;
        TILE = currentTile;
        PLAYER_ARR = players;

        ArrayList<Component> buttonList = new ArrayList<>();
        //buttonList.add(makeRoll());
        if(currentPlayer.getOwnedProperties().size() > 0)
            buttonList.add(makeMortgage());
        if(currentPlayer.getMortProperties().size() > 0)
            buttonList.add(makeUnMortgage());
        if(currentPlayer.CARDS.size() > 0)
            buttonList.add(makeCardHand());

        if (!currentTile.hasOwner()) {
            buttonList.add(makeBuy());
            buttonList.add(makeAuction());
        }

        if (currentTile.hasOwner() && !currentTile.owner().equals(currentPlayer)) {
            buttonList.add(makePayRent());
        }


        if (currentTile.hasOwner() && currentTile.owner().equals(currentPlayer)) {
            /*
            want to change to involve monopolies
            e.g if(currentTile.playerMonopoly())
            */
            if (currentTile.getConstructable()) {
                buttonList.add(makeBuild());
            }
            if (currentTile.getSellable()) {
                buttonList.add(makeSell());
            }
        }

        return buttonList;
    }

    public JButton makeBuy() {
        JButton buy = new JButton();
        buy.setIcon(new ImageIcon("Resources/Images/buy.png"));
        buy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("Bought");
                if (!TILE.hasOwner()) {
                    new BuyTransaction(PLAYER, TILE);
                    System.out.println("Bought");
                }
            }

        });
        return buy;
    }

    public JButton makeAuction() {
        JButton auction = new JButton();
        auction.setIcon(new ImageIcon("Resources/Images/auction.png"));
        auction.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Auction auction = new Auction(TILE, PLAYER_ARR);
            }

        });
        return auction;
    }

    public JButton makePayRent() {
        JButton payRent = new JButton();
        payRent.setIcon(new ImageIcon("Resources/Images/payrent.png"));
        payRent.addActionListener(new ActionListener() {

            boolean payed = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Rent Paid");
                if (!payed) {
                    new RentTransaction(PLAYER, TILE);
                    beenPayed();
                } else {
                    System.out.println("already payed" + PLAYER.balance());
                }
            }

            void beenPayed() {
                payed = true;
            }
        });

        return payRent;
    }

    public JButton makeSell() {
        JButton sell = new JButton();
        sell.setIcon(new ImageIcon("Resources/Images/sell.png"));
        sell.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (TILE.countHotels() > 0) {
                    new SellHotelTransaction(PLAYER, TILE);
                } else if (TILE.countHouses() < 0) {
                    new SellHouseTransaction(PLAYER, TILE);
                }
            }
        });

        return sell;
    }

    public JButton makeBuild() {
        JButton build = new JButton();
        build.setIcon(new ImageIcon("Resources/Images/build.png"));

        build.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (TILE.countHouses() < 4) {
                    new BuildHouseTransaction(PLAYER, TILE);
                } else if (TILE.countHouses() == 4 && TILE.countHotels() < 1) {
                    new BuildHotelTransaction(PLAYER, TILE);
                }
            }

        });

        return build;
    }
}
