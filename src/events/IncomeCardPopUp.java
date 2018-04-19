package events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncomeCardPopUp extends JFrame{
    public IncomeCardPopUp(String message, double ammount){
        setBounds(200,200,450,180);
        setUndecorated(true);
        setBackground(Color.gray);
        String[] messageArr = message.split(" ");
        int size = messageArr.length;
        String firstHalf = "";
        String secondHalf = "";
        for(int i = 0; i < size/2; i++){
            firstHalf += messageArr[i] + " ";
        }
        for(int i = size/2; i < size; i++){
            secondHalf += messageArr[i] + " ";
        }
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        p.add(Box.createRigidArea(new Dimension(400, 40)));
        JLabel l1 = new JLabel(firstHalf);
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(l1);
        JLabel l2 = new JLabel(secondHalf);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(l2);
        p.add(Box.createRigidArea(new Dimension(400, 50)));
        JLabel l3 = new JLabel("Gain " + ammount + "sd");
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(l3);

        JButton finished = new JButton("click to collect!");
        finished.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(p);

        add(finished, BorderLayout.AFTER_LAST_LINE);
        setVisible(true);
    }
}
