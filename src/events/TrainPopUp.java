package events;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.concurrent.TimeUnit;

class TrainPopUp extends JFrame{
    TrainPopUp(String trainName, String destination){
        setBounds(200, 300, 400, 210);
        setUndecorated(true);
        ImageIcon I = new ImageIcon("/Users/connorclancy/Desktop/Ticket.png");
        JLabel test = new JLabel(I);
        JLabel top, middle, bottom;

        if(destination.equals("Jail")){
            top = new JLabel("CAUGHT");
            middle = new JLabel("--TRAIN HOPING--");
            bottom = new JLabel("! ! !" + destination + "! ! !");

        }
        else if(destination.contains("Tax")){
            top = new JLabel("!Random Search!");
            middle = new JLabel("offshore accounts - FOUND");
            bottom = new JLabel("! ! !" + destination + "! ! !");
        }
        else {
            Random rand = new Random();
            Color[] colourAr = {Color.blue, Color.CYAN, Color.orange, Color.MAGENTA, Color.PINK};

            top = new JLabel("Boarded  the " + trainName + " to the");
            middle = new JLabel("\t\t-" + destination + "-\t\t");
            middle.setBorder(new LineBorder(colourAr[rand.nextInt(5)], 2, true));
            bottom = new JLabel("dimension");

        }

        JPanel p = new JPanel();

        test.setLayout(new BoxLayout(test, BoxLayout.Y_AXIS));
        test.add(Box.createRigidArea(new Dimension(15, 40)));
        top.setAlignmentX(Component.CENTER_ALIGNMENT);
        test.add(top);
        test.add(Box.createRigidArea(new Dimension(10, 10)));
        middle.setAlignmentX(Component.CENTER_ALIGNMENT);
        test.add(middle);
        test.add(Box.createRigidArea(new Dimension(10, 10)));
        bottom.setAlignmentX(Component.CENTER_ALIGNMENT);
        test.add(bottom);

        JButton finish = new JButton("Choo Choo!");
        finish.setSize(100, 50);
        finish.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        } );

        p.add(test);
        add(p);
        add(finish, BorderLayout.AFTER_LAST_LINE);
        setVisible(true);
        setAlwaysOnTop(true);
        try {
                TimeUnit.SECONDS.sleep(3);
        } catch (Exception e){
            e.printStackTrace();
        }
        dispose();
    }

}
