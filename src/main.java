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
    static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];

    public static void main(String[] args) throws MalformedURLException {
        Board panopoly = new Board(); // Makes the entire frame, you add panels into it to divide it into board, console etc.
        JPanel panel = new JPanel();
        JLabel image = new JLabel(new ImageIcon(new URL("https://i.imgur.com/YNAbDLe.png"))) {
            public void paint(Graphics g, int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4) {
                super.paint(g);

                g.setColor(Color.red); //Colour placeholder for the player - will add images later
                g.drawOval(x1, y1, 10, 10);

                g.setColor(Color.blue);
                g.drawOval(x2, y2, 10, 10);

                g.setColor(Color.GREEN);
                g.drawOval(x3, y3, 10, 10);

                g.setColor(Color.CYAN);
                g.drawOval(x4, y4, 10, 10);

            }
        };

        image.setForeground(Color.blue);
        image.setOpaque(true);
        panel.add(image);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        ListIterator<Component> iterator = new ChooseButtons().showButtons().listIterator();
        while(iterator.hasNext())
        {
            buttonPanel.add(iterator.next());
        }
        panel.add(buttonPanel, BorderLayout.CENTER);
        panopoly.add(panel);
        panopoly.setUndecorated(true); // hides close, minimize, fullscreen

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
        panel.add(btn1);
        panel.add(btn2);
        panopoly.add(panel);

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
        ChooseButtons buttons = new ChooseButtons();
        int i;
        boolean gameEnd = false;
        while(!gameEnd) {
            i = 0;
            while (i < players.length) {
                /*
                representing each turn, the player rolls to move and then
                the tile type is checked, the appropriate buttons wil appear
                 */
                currentPlayer = players[i % players.length];
                System.out.println(currentPlayer.name());
                int x = dice.rollDice(2, 6);
                System.out.println(x);
                currentTile = currentPlayer.move(x);
                if(currentTile instanceof ImproveProperty){
                    System.out.println(currentTile.getIdentifier());
                    //but like make a way to change what buttons appear.
                }
                i++;
            }
            gameEnd = true;
        }
    }
}
