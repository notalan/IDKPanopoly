package board;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class MainMenuButtons {
    public JButton playButton(final JFrame mainmenu, final Board panopoly)
    {
        JButton play = new JButton();

            play.setIcon(new ImageIcon("Resources/Images/playbutton.png"));
            play.setBorder(new EmptyBorder(0,0,0,0));
        play.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    panopoly.setVisible(true);

                    mainmenu.dispose();
            }

        } );
        return play;
    }
    public  JButton quitButton()
    {
        JButton quit = new JButton();
        quit.setIcon(new ImageIcon("Resources/Images/quitbutton.png"));
        quit.setBorder(new EmptyBorder(0,0,0,0));
        quit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }

        } );
        return quit;
    }
}
