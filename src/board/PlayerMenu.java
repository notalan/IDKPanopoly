package board;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class PlayerMenu extends JFrame{
    public String[] player_names = new String[4];

    public PlayerMenu(Board panopoly) throws MalformedURLException{
        JFrame player_menu = new JFrame("PlayerMenu");
        player_menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PlayerMenuButtons player_buttons = new PlayerMenuButtons();
        JLabel menu_image = new JLabel(new ImageIcon("Resources/Images/Character.png"));
        menu_image.setLayout(new BoxLayout(menu_image, BoxLayout.Y_AXIS));
        player_menu.add(menu_image);

        menu_image.add(Box.createRigidArea(new Dimension(0, 150)));
        JLabel p1 = new JLabel("Enter Player 1 name:");
        p1.setForeground(Color.white);
        menu_image.add(p1);

        JTextField player1 = new JTextField();
        player1.setHorizontalAlignment(0);
        menu_image.add(player1);
        menu_image.add(Box.createRigidArea(new Dimension(0, 100)));

        JLabel p2 = new JLabel("Enter Player 2 name: (Leave blank for AI)");
        p2.setForeground(Color.white);
        menu_image.add(p2);
        JTextField player2 = new JTextField();
        menu_image.add(player2);
        player2.setHorizontalAlignment(0);
        menu_image.add(Box.createRigidArea(new Dimension(0, 100)));

        JLabel p3 = new JLabel("Enter Player 3 name: (Leave blank for AI)");
        p3.setForeground(Color.white);
        menu_image.add(p3);
        JTextField player3 = new JTextField();
        player3.setHorizontalAlignment(0);
        menu_image.add(player3);
        menu_image.add(Box.createRigidArea(new Dimension(0, 100)));

        JLabel p4 = new JLabel("Enter Player 4 name: (Leave blank for AI)");
        p4.setForeground(Color.white);
        menu_image.add(p4);
        JTextField player4 = new JTextField();
        player4.setHorizontalAlignment(0);
        menu_image.add(player4);

        JButton next = player_buttons.nextButton(player_menu, panopoly);
        next.setAlignmentX(Component.CENTER_ALIGNMENT);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set player names here
                String player_1 = player1.getText();
                String player_2 = player2.getText();
                String player_3 = player3.getText();
                String player_4 = player4.getText();
                player_names[0] = player_1;
                if(player_2.isEmpty()){
                    player_names[1] = "";
                }
                else{
                    player_names[1] = player_2;
                }
                if(player_3.isEmpty()){
                    player_names[2] = "";
                }
                else{
                    player_names[2] = player_3;
                }
                if(player_4.isEmpty()){
                    player_names[3] = "";
                }
                else{

                    player_names[3] = player_4;
                }
            }

        });
        player_menu.setUndecorated(true);
        menu_image.add(next);
        player_menu.pack();
        player_menu.setVisible(true);
    }
    public String[] getPlayer_names(){
        return player_names;
    }
}
