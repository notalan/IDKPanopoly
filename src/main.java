import board.Board;
import buttons.ChooseButtons;
import dice.Dice;
import player.Player;
import property.ImproveProperty;
import property.Tile;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ListIterator;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;

public class main {
    public static int x1;
    public static int x2;
    public static int x3;
    public static int x4;
    public static int y1;
    public static int y2;
    public static int y3;
    public static int y4;
    static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];

    public static void main(String[] args) throws MalformedURLException {
        Board panopoly = new Board(); // Makes the entire frame, you add panels into it to divide it into board, console etc.
        panopoly.setLayout(new FlowLayout());
        JPanel panel = new JPanel();

        JLabel image = new JLabel(new ImageIcon(new URL("https://i.imgur.com/YNAbDLe.png"))) {
            public void paint(Graphics g) {
                super.paint(g);

                g.setColor(Color.red); //Colour placeholder for the player - will add images later
                g.drawOval(x1, y1, 10, 10);

                g.setColor(Color.blue);
                g.drawOval(x2, y2, 10, 10);

                g.setColor(Color.GREEN);
                g.drawOval(x3, y3, 10, 10);

                g.setColor(Color.CYAN);
                g.drawOval(x4, y4, 10, 10);

                // This is set to 4 players
            }
        };

        image.setForeground(Color.blue);
        image.setOpaque(true);

        panel.add(image);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(10,1));

        panel.add(buttonPanel);

        JButton btn1 = new JButton("Full-Screen");

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                device.setFullScreenWindow(panopoly);
            }
        });

        JButton btn2 = new JButton("Normal");

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                device.setFullScreenWindow(null);
            }
        });

        final boolean[] turnEnd = {false};

        JButton finished = new JButton("Finished");

        finished.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnEnd[0] = true;
                System.out.println("Turn Finished");
            }
        });

        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
        buttonPanel.add(finished);

        panel.add(buttonPanel);

        panopoly.getContentPane().add(panel, FlowLayout.LEFT);
        panopoly.setUndecorated(true); // hides close, minimize, fullscreen
        panopoly.pack();
        panopoly.setVisible(true);

        Initialiser initialise = new Initialiser();
        Tile[] tiles = initialise.tiles();
        String[] names = {"Bill", "John"};
        //players can be acquired properly later one

        Player[] players = initialise.players(2, names, tiles);

        Player currentPlayer;
        Tile currentTile;
        Dice dice = new Dice(); //Test rolling dice
        int i;
        boolean gameEnd = false;
        while(!gameEnd) {
            i = 0;
            while (i < players.length) {
                /*
                representing each turn, the player rolls to move and then
                the tile type is checked, the appropriate buttons wil appear
                 */
                buttonPanel.removeAll();
                turnEnd[0] = false;

                currentPlayer = players[i % players.length];
                System.out.println(currentPlayer.name());

                int x = dice.rollDice(2, 6);
                System.out.println(x);
                currentTile = currentPlayer.move(x);
                x1 = currentTile.getXCo(); // moving the players
                y1 = currentTile.getYCo();
                image.repaint();

                buttonPanel.add(btn1);
                buttonPanel.add(btn2);
                buttonPanel.add(finished);

                ListIterator<Component> iterator = new ChooseButtons().showButtons(currentTile).listIterator();
                Component temp;

                while(iterator.hasNext())
                {
                    temp = iterator.next();
                    temp.setSize(new Dimension(30, 10));
                    buttonPanel.add(temp);
                }
                buttonPanel.revalidate();

                while(!turnEnd[0])
                {
                    System.out.println(currentPlayer.name() + "'s turn");
                }

                i++;
            }
            gameEnd = true;
        }
    }
}
