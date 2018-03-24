package buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TaxButtons extends Button{
    public List<Component> showButtons()
    {
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());
        buttonList.add(makeTax());
        return buttonList;
    }

    public JButton makeTax()
    {
        JButton tax = new JButton("Pay Tax");

        tax.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tax Paid");

            }

        } );

        return tax;
    }
}
