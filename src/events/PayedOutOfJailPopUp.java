package events;

import javax.swing.*;

public class PayedOutOfJailPopUp extends JFrame{
    public PayedOutOfJailPopUp() {
        setBounds(200,300,400,210);
        setUndecorated(true);
        JLabel text = new JLabel("FREED FROM JAIL (payed the fine criminal scum)");
        add(text);
        setAlwaysOnTop(true);
        setVisible(true);
    }
}
