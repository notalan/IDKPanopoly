package board;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuButtons {
    public JButton playButton(final JFrame mainmenu, final Board panopoly, final GameMusic M, final GameMusic music)
    {
        JButton play = new JButton();

        play.setIcon(new ImageIcon("Resources/Images/playbutton.png"));
        play.setBorder(new EmptyBorder(0,0,0,0));
        play.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panopoly.setVisible(true);
                M.stop();
                mainmenu.dispose();
                music.playCont("Resources/Audio/main_game_music.wav");
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
