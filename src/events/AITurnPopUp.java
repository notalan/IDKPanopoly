package events;

import javax.swing.*;
import java.awt.*;

public class AITurnPopUp extends JFrame{
    public AITurnPopUp(){
        setBounds(0, 40, 500, 150);
        setUndecorated(true);
        setAlwaysOnTop(true);
        setBackground(Color.BLACK);
        JPanel p = new JPanel();
        p.setBackground(Color.black);
        TextArea T = new TextArea("AI TURN");
        T.setSize(500, 100);
        p.add(new TextArea("AI TURN"));

        add(p);
        setVisible(true);
    }
}
