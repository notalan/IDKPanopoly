package buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LuxuryTaxButtons extends Button {
    public List<Component> showButtons()
    {
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());
        buttonList.add(makeLuxuryTax());
        return buttonList;
    }

    public JButton makeLuxuryTax()
    {
        JButton luxuryTax = new JButton("Pay Luxury Tax");

        luxuryTax.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Unlucky Mate");

            }

        } );
        return luxuryTax;
    }
}
