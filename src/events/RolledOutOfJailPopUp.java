package events;

import javax.swing.*;

public class RolledOutOfJailPopUp extends JFrame {
    public RolledOutOfJailPopUp() {
        setBounds(200,300,400,210);
        setUndecorated(true);
        JLabel text = new JLabel("FREED FROM JAIL (rolled equal dice)");
        add(text);
        setAlwaysOnTop(true);
        setVisible(true);
    }
}
