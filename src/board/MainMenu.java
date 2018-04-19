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
        JLabel lewd = new JLabel(new ImageIcon("C:\\Users\\1997a\\Documents\\IDKPanopoly\\Resources\\Images\\main.gif"));
        lewd.setLayout(new BoxLayout(lewd, BoxLayout.Y_AXIS));
        lewd.add(Box.createRigidArea(new Dimension(50, 400)));
        JButton p = main_buttons.playButton(main_menu, panopoly);
        JButton q = main_buttons.quitButton();

        p.setAlignmentX(Component.CENTER_ALIGNMENT);
        q.setAlignmentX(Component.CENTER_ALIGNMENT);
        lewd.add(p);
        lewd.add(Box.createRigidArea(new Dimension(50, 50)));
        lewd.add(q);
        mainmenu.add(lewd);
        main_menu.add(mainmenu);
        main_menu.pack();
        main_menu.setVisible(true);
    }
}
