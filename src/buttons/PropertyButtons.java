package buttons;

import player.Player;
import property.ImproveProperty;
import property.Property;
import property.TaxTiles;
import transactions.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class PropertyButtons extends Button{

//    private Player PLAYER;
    private ImproveProperty TILE;

    public List<Component> showButtons(ImproveProperty currentTile, Player currentPlayer) {
        PLAYER = currentPlayer;
        TILE = currentTile;
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());

        if (!currentTile.hasOwner()) {
            buttonList.add(makeBuy());
            buttonList.add(makeAuction());
        }

       if(currentTile.hasOwner() && !currentTile.owner().equals(currentPlayer))
        {
            buttonList.add(makePayRent());
        }


        if(currentTile.hasOwner() && currentTile.owner().equals(currentPlayer))
        {
            buttonList.add(makeMortgage());
            /*
            want to change to involve monopolies
            e.g if(currentTile.playerMonopoly())
            */
            if(currentTile.getConstructable()){
                buttonList.add(makeBuild());
            }
            if(currentTile.getSellable()){
                buttonList.add(makeSell());
            }
        }
        return buttonList;
    }

    public JButton makeBuy()
    {
        JButton buy = new JButton("Buy");

        buy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("Bought");
                new BuyTransaction(PLAYER, TILE);
            }

        } );
        return buy;
    }

    public JButton makeAuction()
    {
        JButton auction = new JButton("Auction");

        auction.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Auctioned");

            }

        } );
        return auction;
    }

    public JButton makePayRent()
    {
        JButton payRent = new JButton("Pay Rent");

        payRent.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Rent Paid");
                new RentTransaction(PLAYER, TILE);
            }

        } );

        return payRent;
    }

    public JButton makeSell()
    {
        JButton sell = new JButton("Sell");

        sell.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(TILE.countHotels() > 0)
                {
                    new SellHotelTransaction(PLAYER, TILE);
                }
                else{
                    new SellHouseTransaction(PLAYER, TILE);
                }
            }

        } );

        return sell;
    }

    public JButton makeBuild()
    {
        JButton build = new JButton("Build");

        build.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if(TILE.countHouses() < 4)
               {
                   new BuildHouseTransaction(PLAYER, TILE);
               }
               else if(TILE.countHouses() == 4 && TILE.countHotels() < 1)
               {
                   new BuildHotelTransaction(PLAYER, TILE);
               }
            }

        } );

        return build;
    }

    public JButton makeMortgage()
    {
        JButton mortgage = new JButton("Mortgage");

        mortgage.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              new MortgageTransaction(PLAYER, (ImproveProperty)TILE);
            }

        } );

        return mortgage;
    }
}
