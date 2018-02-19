package buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class IncomeTaxButtons extends Button{
    public List<Component> showButtons()
    {
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());
        buttonList.add(makeIncomeTax());
        return buttonList;
    }

    public JButton makeIncomeTax()
    {
        JButton incomeTax = new JButton("Pay Income Tax");

        incomeTax.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Income Tax Paid");

            }

        } );

        return incomeTax;
    }
}
