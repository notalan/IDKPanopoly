package events;

import javax.swing.*;

public class RolledOutOfJailFailPopUp extends JFrame {
    public RolledOutOfJailFailPopUp() {
        setBounds(200,300,400,210);
        setUndecorated(true);
        JLabel text = new JLabel("FAILED ROLL (rolled non equal dice)");
        add(text);
        setAlwaysOnTop(true);
        setVisible(true);
    }
}
