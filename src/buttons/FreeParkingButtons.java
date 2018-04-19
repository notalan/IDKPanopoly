package buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FreeParkingButtons extends Buttons{
    public List<Component> showButtons()
    {
        ArrayList<Component> buttonList = new ArrayList<>();
        buttonList.add(makeRoll());
        buttonList.add(makeCollectMoney());
        return buttonList;
    }

    public JButton makeCollectMoney()
    {
        JButton collectMoney = new JButton("Collect Money");

        collectMoney.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Money collected, lucky boiiii!");

            }

        } );
        return collectMoney;
    }
}
