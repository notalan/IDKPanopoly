package buttons;

import player.Player;
import property.TaxTiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TaxButtons extends Buttons{

//    private Player PLAYER;
//    private TaxTiles TILE;
    public List<Component> showButtons(TaxTiles tile, Player p)
    {
        PLAYER = p;
        TILE = tile;

        ArrayList<Component> buttonList = new ArrayList<>();
        //buttonList.add(makeRoll());
        buttonList.add(makeTax());
        if(p.getOwnedProperties().size() > 0)
            buttonList.add(makeMortgage());
        if(p.getMortProperties().size() > 0)
            buttonList.add(makeUnMortgage());
        if(p.CARDS.size() > 0)
            buttonList.add(makeCardHand());
        return buttonList;
    }

    public JButton makeTax()
    {
        JButton tax = new JButton("Pay Tax");

        tax.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tax Paid");
                //Need some way to identify which type of tax tile it is.
            }

        } );

        return tax;
    }
}
