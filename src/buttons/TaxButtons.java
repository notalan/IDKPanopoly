package buttons;

import player.Player;
import property.FreeParking;
import property.TaxTiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TaxButtons extends Buttons{

    private TaxTiles TILE;
    private FreeParking F;
    public List<Component> showButtons(TaxTiles tile, Player p, FreeParking freeParkingP)
    {
        PLAYER = p;
        TILE = tile;
        F = freeParkingP;

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
        JButton tax = new JButton();
        tax.setIcon(new ImageIcon("Resources/Images/paytax.png"));
        tax.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                double taxtype = TILE.getTypeOfTax();
                if(taxtype < TILE.getFlatIncomeTaxAmount()){
                    new transactions.IncomeTaxTransaction(PLAYER, TILE, false, F);
                    System.out.println("income " + PLAYER.balance());
                }
                else if(taxtype > TILE.getIncomeTaxPercentage()
                        && taxtype < TILE.getFlatLuxaryTaxAmount()){
                    new transactions.IncomeTaxTransaction(PLAYER, TILE, true, F);
                    System.out.println("flatIncome " + PLAYER.balance());
                }
                else{
                    new transactions.LuxuryTransaction(PLAYER, TILE, F);
                    System.out.println("Luxury " + PLAYER.balance());
                }
                System.out.println(F.freeParkingPool);
            }

        } );

        return tax;
    }
}
