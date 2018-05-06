package board;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MainMenu extends JFrame{
    public MainMenu(Board panopoly) throws MalformedURLException {
        JFrame main_menu = new JFrame("MainMenu");
        main_menu.setUndecorated(true);
        main_menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MainMenuButtons main_buttons = new MainMenuButtons();
        JPanel mainmenu = new JPanel();
        JLabel main = new JLabel(new ImageIcon("Resources/Images/main.gif"));
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(Box.createRigidArea(new Dimension(50, 400)));
        JButton p = main_buttons.playButton(main_menu, panopoly);
        JButton q = main_buttons.quitButton();
        p.setAlignmentX(Component.CENTER_ALIGNMENT);
        q.setAlignmentX(Component.CENTER_ALIGNMENT);
        main.add(p);
        main.add(Box.createRigidArea(new Dimension(50, 50)));
        main.add(q);
        mainmenu.add(main);
        main_menu.add(mainmenu);
        main_menu.pack();
        main_menu.setVisible(true);

    }
}
