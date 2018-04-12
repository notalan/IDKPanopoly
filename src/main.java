import board.Board;
import buttons.Buttons;
import buttons.ChooseButtons;
import dice.Dice;
import player.Player;
import property.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class main {
    //public static int x1;
    //public static int x2;
    //public static int x3;
    //public static int x4;
    //public static int y1;
    //public static int y2;
    //public static int y3;
    //public static int y4;

    public static int[] xCoord = new int[4];
    public static int[] yCoord = new int[4];

    static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];

    public static void main(String[] args) throws MalformedURLException {
        Board panopoly = new Board(); // Makes the entire frame, you add panels into it to divide it into board, console etc.
        panopoly.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        Initialiser initialise = new Initialiser();
        Tile[] tiles = initialise.tiles();
        String[] names = {"Bill", "John"};
        //players can be acquired properly later one

        Player[] players = initialise.players(2, names, tiles);


        JLabel image = new JLabel(new ImageIcon(new URL("https://i.imgur.com/y7GC8xJ.png"))) {
            public void paint(Graphics g) {
                super.paint(g);

                g.setColor(Color.red); //Colour placeholder for the player - will add images later
                g.drawOval(xCoord[0], yCoord[0], 10, 10);

                g.setColor(Color.blue);
                g.drawOval(xCoord[1], yCoord[1], 10, 10);

                g.setColor(Color.GREEN);
                g.drawOval(xCoord[2], yCoord[2], 10, 10);

                g.setColor(Color.CYAN);
                g.drawOval(xCoord[2], yCoord[2], 10, 10);
                // This is set to 4 players

                // Tiles next
                g.setColor(Color.white); // Changes the text colour to white
                Font font1 = new Font("Comic Sans", Font.BOLD, 10);// This changes the font to comic sans and changes it to size 10
                g.setFont(font1); // This sets the font for the text on the tiles

                SpacingNames(g, tiles[1].getIdentifier(),557, 640);// Brown 1
                g.drawString("60", 575, 625); // Price
                SpacingNames(g, tiles[3].getIdentifier(),446, 640);// Brown 2
                g.drawString("60", 465, 625); // Price

                SpacingNames(g, tiles[6].getIdentifier(),278, 640);// Cyan/Light Blue 1
                g.drawString("100", 296, 625); // Price
                SpacingNames(g, tiles[8].getIdentifier(),168, 640);// Cyan/Light Blue 2
                g.drawString("100", 186, 625); // Price
                SpacingNames(g, tiles[9].getIdentifier(),112, 640);// Cyan/Light Blue 3
                g.drawString("120", 130, 625); // Price

                SpacingNamesSides(g, tiles[11].getIdentifier(),5, 565);// Magenta/Pink 1
                g.drawString("140", 89, 585); // Price
                SpacingNamesSides(g, tiles[13].getIdentifier(),5, 455);// Magenta/Pink 2
                g.drawString("140", 89, 475); // Price
                SpacingNamesSides(g, tiles[14].getIdentifier(),5, 400);// Magenta/Pink 3
                g.drawString("160", 89, 425); // Price

                SpacingNamesSides(g, tiles[16].getIdentifier(),5, 285);// Orange 1
                g.drawString("180", 89, 310); // Price
                SpacingNamesSides(g, tiles[18].getIdentifier(),5, 175);// Orange 2
                g.drawString("180", 89, 200); // Price
                SpacingNamesSides(g, tiles[19].getIdentifier(),5, 125);// Orange 3
                g.drawString("200", 89, 145); // Price

                SpacingNames(g, tiles[21].getIdentifier(),112, 13);// Red 1
                g.drawString("220", 132, 103); // Price
                SpacingNames(g, tiles[23].getIdentifier(),223, 13);// Red 2
                g.drawString("220", 243, 103); // Price
                SpacingNames(g, tiles[24].getIdentifier(),277, 13);// Red 3
                g.drawString("240", 297, 103); // Price

                SpacingNames(g, tiles[26].getIdentifier(),391, 13);// Yellow 1
                g.drawString("260", 405, 103); // Price
                SpacingNames(g, tiles[27].getIdentifier(),447, 13);// Yellow 2
                g.drawString("260", 460, 103); // Price
                SpacingNames(g, tiles[29].getIdentifier(),557, 13);// Yellow 3
                g.drawString("280", 570, 103); // Price

                SpacingNamesSides(g, tiles[31].getIdentifier(),630, 125);// Green 1
                g.drawString("300", 610, 145); // Price
                SpacingNamesSides(g, tiles[32].getIdentifier(),630, 180);// Green 2
                g.drawString("300", 610, 200); // Price
                SpacingNamesSides(g, tiles[34].getIdentifier(),630, 290);// Green 3
                g.drawString("320", 610, 310); // Price

                SpacingNamesSides(g, tiles[37].getIdentifier(),630, 455);// Blue 1
                g.drawString("350", 610, 473); // Price
                SpacingNamesSides(g, tiles[39].getIdentifier(),630, 565);// Blue 2
                g.drawString("400", 610, 583); // Price

                g.setColor(Color.lightGray); // Changes the text colour to light gray
                Font font2 = new Font("Comic Sans", Font.BOLD, 10);// This changes the font to comic sans and changes it to size 10
                g.setFont(font2); // This sets the font for the text on the tiles

                SpacingNames(g, tiles[5].getIdentifier(),330, 640);// Transport 1
                SpacingNamesSides(g, tiles[15].getIdentifier(),5, 340);// Transport 2
                SpacingNames(g, tiles[25].getIdentifier(),332, 13);// Transport 3
                SpacingNamesSides(g, tiles[35].getIdentifier(),630, 340);// Transport 4
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
        final boolean[] moved = {false};

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


        final Player[] currentPlayer = {null};
        Tile currentTile;
        Dice dice = new Dice(); //Test rolling dice
        int i;
        boolean gameEnd = false;

        JButton roll = new JButton("Roll");

        roll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dice dice = new Dice();
                int rolled_result = dice.rollDice(2, 6);
                System.out.println(currentPlayer[0].name());
                currentPlayer[0].move(rolled_result);
                System.out.println("Rolled: " + rolled_result + " " + currentPlayer[0].Location().getIdentifier());
                moved[0] = true;
            }

        } );

        while(!gameEnd) {
            i = 0;
            while (i < players.length) {
                /*
                representing each turn, the player rolls to move and then
                the tile type is checked, the appropriate buttons wil appear
                 */
                buttonPanel.removeAll();
                turnEnd[0] = false;
                moved[0] = false;

                currentPlayer[0] = players[i % players.length];
                System.out.println(currentPlayer[0].name());

                currentTile = currentPlayer[0].Location();
                xCoord[i % players.length] = currentTile.getXCo();
                yCoord[i % players.length] = currentTile.getYCo();

                image.repaint();

                buttonPanel.add(btn1);
                buttonPanel.add(btn2);
                buttonPanel.add(finished);
                buttonPanel.add(roll);

                try {
                    while (!moved[0]) {
                        TimeUnit.MILLISECONDS.sleep(5);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                buttonPanel.remove(roll);

                ListIterator<Component> iterator = new ChooseButtons().showButtons(currentTile, currentPlayer[0]).listIterator();
                Component temp;

                while(iterator.hasNext())
                {
                    temp = iterator.next();
                    temp.setSize(new Dimension(30, 10));
                    buttonPanel.add(temp);
                }
                buttonPanel.revalidate();

                try {
                    while (!turnEnd[0]) {
                        TimeUnit.MILLISECONDS.sleep(5);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                i++;
            }
            gameEnd = true;
        }
    }

    public static void SpacingNames(Graphics g, String toSplit, int x, int y) // top and bottom
    {
        String[] splittingString1 = toSplit.split(" ");
        if(splittingString1.length == 1){
            g.drawString(splittingString1[0], x, y + 75);
        }
        else if(splittingString1.length == 2) {
            g.drawString(splittingString1[0], x, y);
            g.drawString(splittingString1[1], x, y + 75);
        }
        else if(splittingString1.length == 3){
            for (int i = 0; i < splittingString1.length; i++) {
                g.drawString(splittingString1[i], x, y + i * 10);
            }
        }
        else if(splittingString1.length == 4) {
            for (int i = 0; i < splittingString1.length; i++) {
                g.drawString(splittingString1[i], x, y + i * 10);
            }
        }
    }

    public static void SpacingNamesSides(Graphics g, String toSplit, int x, int y) // sides
    {
        String[] splittingString1 = toSplit.split(" ");
        if (splittingString1.length == 1) {
            g.drawString(splittingString1[0], x, y +  40);

        } else if (splittingString1.length == 2) {
            g.drawString(splittingString1[0], x, y);
            g.drawString(splittingString1[1], x , y + 40);

        } else if (splittingString1.length == 3) {
            for (int i = 0; i < splittingString1.length; i++) {
                g.drawString(splittingString1[i], x , y + i * 10);
            }
        }
    }
}

/*       x, y
0    Go = 665 665
    --Bottom line--
1    585 665
2   530
3   470
4    420
5    360
6    305
7    250
8    195
9    140

10 JAIL = 50 665
    --Left--
11    50 580
12       530
13       470
14       420
15       360
16       305
17       250
18       190
19       140
20    FREE PARKING 50 60
    --top--
21    140 50
22    195
3    250
4    305
5    360
6    420
7    470
8    530
9    585
30    GO TO JAIL 665 50
    --right--
1    665 140
2        190
3        250
4        305
5        360
6        420
7        470
8        530
9        580
 */