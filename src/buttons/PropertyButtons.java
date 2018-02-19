package buttons;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class PropertyButtons extends Button{

    public List<Component> showButtons()
    {
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());
        buttonList.add(makeBuy());
        buttonList.add(makeAuction());
        buttonList.add(makePayRent());
        buttonList.add(makeBuild());
        buttonList.add(makeSell());
        buttonList.add(makeMortgage());
        return buttonList;
    }

    public JButton makeBuy()
    {
        JButton buy = new JButton("Buy");

        buy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bought");

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
                System.out.println("Sold");

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
                System.out.println("Built");

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
                System.out.println("Mortgaged");

            }

        } );

        return mortgage;
    }
}
