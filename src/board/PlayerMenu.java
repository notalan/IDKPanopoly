package board;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class PlayerMenu extends JFrame{


    public PlayerMenu(Board panopoly) throws MalformedURLException {
        JFrame player_menu = new JFrame("PlayerMenu");
        player_menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PlayerMenuButtons player_buttons = new PlayerMenuButtons();
        JLabel menu_image = new JLabel(new ImageIcon("Resources/Images/Character.png"));
        menu_image.setLayout(new GridBagLayout());
        player_menu.add(menu_image);

        menu_image.add(new JLabel("Enter Player 1 name:"));
        JTextField player1 = new JTextField();
        player1.setPreferredSize(new Dimension(100,20));
        menu_image.add(player1);

        menu_image.add(new JLabel("Enter Player 2 name:"));
        JTextField player2 = new JTextField();
        player2.setSize(100,20);
        menu_image.add(player2);

        menu_image.add(new JLabel("Enter Player 3 name:"));
        JTextField player3 = new JTextField();
        player3.setSize(100,20);
        menu_image.add(player3);

        menu_image.add(new JLabel("Enter Player 4 name:"));
        JTextField player4 = new JTextField();
        player4.setSize(100,20);
        menu_image.add(player4);

        JButton next = player_buttons.nextButton(player_menu, panopoly);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set player names here
                System.out.println(player1.getText());
            }
        });
        menu_image.add(next);
        player_menu.pack();
        player_menu.setVisible(true);
    }
}
