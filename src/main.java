import AI.IntermediateAI;
import board.*;
import buttons.ChooseButtons;
import dice.Dice;
import events.AITurnPopUp;
import events.AlertPopUp;
import events.ChooseEvent;
import events.WinnerPopUp;
import player.Player;
import property.FreeParking;
import property.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ListIterator;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.util.concurrent.TimeUnit;

public class main {

    private static int[] xCoord = new int[4];
    private static int[] yCoord = new int[4];

    static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];

    public static void main(String[] args) throws MalformedURLException {
        final Board panopoly = new Board(); // Makes the entire frame, you add panels into it to divide it into board, console etc.
        panopoly.setBackground(Color.BLACK);
        GameMusic music = new GameMusic();
        MainMenu main_menu = new MainMenu(panopoly, music);
        panopoly.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        Initialiser initialise = new Initialiser();
        final Tile[] tiles = initialise.tiles();
        String[] names = {"Player 1", "Player 2", "", ""};
        //players can be acquired properly later one

        final Player[] players = initialise.players(4, names, tiles);


        JLabel image = new JLabel(new ImageIcon("Resources/Images/PanopolyBoard3.png")) {
            public void paint(Graphics g) {
                super.paint(g);
                try {
                    Image img = ImageIO.read(getClass().getResourceAsStream("tokenImages/spaceboat.png"));
                    Image img2 = ImageIO.read(getClass().getResourceAsStream("tokenImages/dog.png"));
                    Image img3 = ImageIO.read(getClass().getResourceAsStream("tokenImages/spacecar.png"));
                    Image img4 = ImageIO.read(getClass().getResourceAsStream("tokenImages/wheelbarrow.png"));
                    switch(players.length) {
                        case 1: g.drawImage(img, xCoord[0] - 50, yCoord[0] - 50, null);
                        break;
                        case 2: g.drawImage(img, xCoord[0] - 50, yCoord[0] - 50, null);
                                g.drawImage(img2, xCoord[1] - 50, yCoord[1] - 50, null);
                        break;
                        case 3:
                            g.drawImage(img, xCoord[0] - 50, yCoord[0] - 50, null);
                            g.drawImage(img2, xCoord[1] - 50, yCoord[1] - 50, null);
                            g.drawImage(img3, xCoord[2] - 50, yCoord[2] - 50, null);
                        break;
                        case 4:
                            g.drawImage(img, xCoord[0] - 50, yCoord[0] - 50, null);
                            g.drawImage(img2, xCoord[1] - 50, yCoord[1] - 50, null);
                            g.drawImage(img3, xCoord[2] - 50, yCoord[2] - 50, null);
                            g.drawImage(img4, xCoord[3] - 50, yCoord[3] - 50, null);
                            break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Tiles next
                g.setColor(Color.white); // Changes the text colour to white
                Font font1 = new Font("Arial", Font.BOLD, 10);// This changes the font to comic sans and changes it to size 10
                g.setFont(font1); // This sets the font for the text on the tiles

                SpacingNames(g, tiles[1].getIdentifier(),557, 640);// Brown 1
                g.drawString("60", 575, 625); // Price
                SpacingNames(g, tiles[3].getIdentifier(),446, 640);// Brown 2
                g.drawString("60", 465, 625); // Price

                SpacingNames(g, tiles[4].getIdentifier(),391 ,640); // Tax tile 1

                SpacingNames(g, tiles[6].getIdentifier(),280, 640);// Cyan/Light Blue 1
                g.drawString("100", 296, 625); // Price
                SpacingNames(g, tiles[8].getIdentifier(),169, 640);// Cyan/Light Blue 2
                g.drawString("100", 186, 625); // Price
                SpacingNames(g, tiles[9].getIdentifier(),114, 640);// Cyan/Light Blue 3
                g.drawString("120", 130, 625); // Price

                SpacingNamesSides(g, tiles[11].getIdentifier(),5, 565);// Magenta/Pink 1
                g.drawString("140", 89, 585); // Price
                SpacingNamesSides(g, tiles[13].getIdentifier(),5, 455);// Magenta/Pink 2
                g.drawString("140", 89, 475); // Price
                SpacingNamesSides(g, tiles[14].getIdentifier(),5, 400);// Magenta/Pink 3
                g.drawString("160", 89, 425); // Price

                SpacingNamesSides(g, tiles[16].getIdentifier(),5, 290);// Orange 1
                g.drawString("180", 89, 310); // Price
                SpacingNamesSides(g, tiles[18].getIdentifier(),5, 180);// Orange 2
                g.drawString("180", 89, 200); // Price
                SpacingNamesSides(g, tiles[19].getIdentifier(),5, 125);// Orange 3
                g.drawString("200", 89, 145); // Price

                SpacingNames(g, tiles[21].getIdentifier(),114, 13);// Red 1
                g.drawString("220", 132, 103); // Price
                SpacingNames(g, tiles[23].getIdentifier(),225, 13);// Red 2
                g.drawString("220", 243, 103); // Price
                SpacingNames(g, tiles[24].getIdentifier(),280, 13);// Red 3
                g.drawString("240", 297, 103); // Price

                SpacingNames(g, tiles[26].getIdentifier(),390, 13);// Yellow 1
                g.drawString("260", 405, 103); // Price
                SpacingNames(g, tiles[27].getIdentifier(),445, 13);// Yellow 2
                g.drawString("260", 460, 103); // Price
                SpacingNames(g, tiles[29].getIdentifier(),555, 13);// Yellow 3
                g.drawString("280", 570, 103); // Price

                SpacingNamesSides(g, tiles[31].getIdentifier(),630, 123);// Green 1
                g.drawString("300", 610, 145); // Price
                SpacingNamesSides(g, tiles[32].getIdentifier(),630, 177);// Green 2
                g.drawString("300", 610, 200); // Price
                SpacingNamesSides(g, tiles[34].getIdentifier(),630, 287);// Green 3
                g.drawString("320", 610, 310); // Price

                SpacingNamesSides(g, tiles[37].getIdentifier(),633, 455);// Blue 1
                g.drawString("350", 610, 473); // Price
                SpacingNamesSides(g, tiles[39].getIdentifier(),633, 565);// Blue 2
                g.drawString("400", 610, 583); // Price

                SpacingNamesSides(g, tiles[38].getIdentifier(), 633, 510); // Tax tile 2

                g.setColor(Color.yellow); // Changes the text colour to yellow
                Font font2 = new Font("Comic Sans", Font.BOLD, 10);// This changes the font to comic sans and changes it to size 10
                g.setFont(font2); // This sets the font for the text on the tiles

                SpacingNames(g, tiles[5].getIdentifier(),335, 640);// Transport 1
                SpacingNamesSides(g, tiles[15].getIdentifier(),5, 345);// Transport 2
                SpacingNames(g, tiles[25].getIdentifier(),332, 13);// Transport 3
                SpacingNamesSides(g, tiles[35].getIdentifier(),630, 342);// Transport 4
            }
        };

        image.setForeground(Color.blue);
        image.setOpaque(true);

        panel.add(image);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new GridLayout(10,1));
        buttonPanel.setPreferredSize(new Dimension(180,720));

        panel.add(buttonPanel);

        JButton btn1 = new JButton("Full-Screen");
        btn1.setIcon(new ImageIcon("Resources/Images/fullscreen.png"));
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                device.setFullScreenWindow(panopoly);
            }
        });

        JButton btn2 = new JButton();
        btn2.setIcon(new ImageIcon("Resources/Images/normal.png"));

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                device.setFullScreenWindow(null);
            }
        });

        final boolean[] turnEnd = {false};
        final boolean[] moved = {false};

        JButton finished = new JButton("Finished");
        finished.setIcon(new ImageIcon("Resources/Images/finished.png"));
        finished.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnEnd[0] = true;
                System.out.println("Turn Finished");
//                image.repaint();
            }
        });

        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
  //      buttonPanel.add(finished);

        panel.add(buttonPanel);
        BalanceScreen balanceScreen = new BalanceScreen(players);
        panopoly.getContentPane().add(panel, FlowLayout.LEFT);
        panopoly.getContentPane().add(balanceScreen);

        panopoly.setUndecorated(true); // hides close, minimize, fullscreen
        panopoly.pack();
        panopoly.setVisible(false);


        final Player[] currentPlayer = {null};
        Tile currentTile;
        //Dice dice = new Dice(); //Test rolling dice
        int i;
        boolean gameEnd = false;

        JButton roll = new JButton("Roll");
        roll.setIcon(new ImageIcon("Resources/Images/roll.png"));
        roll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dice dice = new Dice();
                int rolled_result = dice.rollDice(2, 6);
                System.out.println(currentPlayer[0].name());
                currentPlayer[0].move(rolled_result);
                System.out.println("Rolled: " + rolled_result + " " + currentPlayer[0].Location().getIdentifier());
                moved[0] = true;
                //image.repaint();
            }

        } );

        while(!gameEnd) {
            i = 0;
            while (i < players.length) {
                buttonPanel.removeAll();
                turnEnd[0] = false;
                moved[0] = false;
                int bankruptCount = 0;

                currentPlayer[0] = players[i % players.length];

                //check if player is still in the game or not
                int poorCount = 0;
                while(currentPlayer[0].isBankrupt()){
                    i++;
                    currentPlayer[0] = players[i % players.length];
                    poorCount++;
                }
                if(poorCount == 3){
                    gameEnd = true;
                    break;
                }
                System.out.println(currentPlayer[0].name());

                currentTile = currentPlayer[0].Location();
                xCoord[i % players.length] = currentTile.getXCo();
                yCoord[i % players.length] = currentTile.getYCo();

                image.repaint();
                buttonPanel.add(btn1);
                buttonPanel.add(btn2);

                if(currentPlayer[0].balance() < 0)
                    bankruptCount++;

                if(currentPlayer[0].isAI()){
                    buttonPanel.removeAll();
                    IntermediateAI AI = new IntermediateAI(currentPlayer[0].name(), players, tiles);
                    AITurnPopUp A = new AITurnPopUp();
                    AI.updater(currentPlayer[0]);
                    AI.strategize();

                    AI.roll();

                    currentTile = currentPlayer[0].Location();
                    xCoord[i % players.length] = currentTile.getXCo();
                    yCoord[i % players.length] = currentTile.getYCo();

                    AI.act();

                    xCoord[i % players.length] = currentPlayer[0].Location().getXCo();
                    yCoord[i % players.length] = currentPlayer[0].Location().getYCo();

                    if(currentPlayer[0].balance() < 0)
                        bankruptCount++;

                    if(bankruptCount > 1)
                        currentPlayer[0].setBankrupt();

                    A.dispose();
                }
                else {
                    currentPlayer[0] = players[i % players.length];
                    if (!currentPlayer[0].isJailed()) {
                        buttonPanel.add(roll);
                    }
                    buttonPanel.repaint();
                    try {
                        while (!moved[0]) {
                            TimeUnit.MILLISECONDS.sleep(10);
                            if (currentPlayer[0].isJailed())
                                break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    buttonPanel.remove(roll);
                    buttonPanel.repaint();

                    currentTile = currentPlayer[0].Location();
                    xCoord[i % players.length] = currentTile.getXCo();
                    yCoord[i % players.length] = currentTile.getYCo();

                    new ChooseEvent(currentPlayer[0], currentTile, players);

                    currentTile = currentPlayer[0].Location();
                    xCoord[i % players.length] = currentTile.getXCo();
                    yCoord[i % players.length] = currentTile.getYCo();

                    image.repaint();
                    ListIterator<Component> iterator = new ChooseButtons().showButtons(currentTile, currentPlayer[0], players, (FreeParking) tiles[20]).listIterator();
                    Component temp;

                    while (iterator.hasNext()) {
                        temp = iterator.next();
                        temp.setSize(new Dimension(30, 10));
                        buttonPanel.add(temp);
                        buttonPanel.repaint();
                    }
                    buttonPanel.add(finished);
                    buttonPanel.revalidate();
                    try {
                        while (!turnEnd[0]) {
                            TimeUnit.MILLISECONDS.sleep(10);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                balanceScreen.update_bal(players);
                buttonPanel.removeAll();
                buttonPanel.repaint();

                if(currentPlayer[0].balance() < 0)
                    bankruptCount++;

                if(bankruptCount > 1) {
                    currentPlayer[0].setBankrupt();
                    new AlertPopUp(currentPlayer[0].name(), "!!BANKRUPT!!");
                }
                i++;
            }
        }
        for(Player p : players){
            if(!p.isBankrupt()){
                music.stop();
                new WinnerPopUp(currentPlayer[0].name(), panopoly);
            }
        }
    }

    private static void SpacingNames(Graphics g, String toSplit, int x, int y) // top and bottom
    {
        String[] splittingString1 = toSplit.split(" ");
        if(splittingString1.length == 1){
            if(splittingString1[0].length() >= 9){
                String furtherSplit = splittingString1[0].substring(0, 6); // deals with names that are too large for tiles like groundskeeper
                g.drawString(furtherSplit + "-", x, y + 65);
                g.drawString(splittingString1[0].substring(6, splittingString1[0].length()) , x, y + 75);
            }
            else {
                g.drawString(splittingString1[0], x, y + 75);
            }
        }
        else if(splittingString1.length == 2) {
            if(splittingString1[0].length() > 9){
                String furtherSplit = splittingString1[0].substring(0, 6); // deals with names that are too large for tiles like groundskeeper
                g.drawString(furtherSplit + "-", x, y);
                g.drawString(splittingString1[0].substring(6, splittingString1[0].length()) , x, y + 10);
            }
            else {
                g.drawString(splittingString1[0], x, y);
            }
            if(splittingString1[1].length() > 9){
                String furtherSplit = splittingString1[1].substring(0, 6); // deals with names that are too large for tiles like groundskeeper
                g.drawString(furtherSplit + "-", x, y + 65);
                g.drawString(splittingString1[1].substring(6, splittingString1[1].length()) , x, y + 75);
            }
            else {
                g.drawString(splittingString1[1], x, y + 75);
            }
        }
        else if(splittingString1.length == 3){
            int total = 0;
            for (int i = 0; i < splittingString1.length; i++) {
                if(splittingString1[i].length() > 9){
                    String furtherSplit = splittingString1[i].substring(0, 6); // deals with names that are too large for tiles like groundskeeper
                    g.drawString(furtherSplit + "-", x, y + total);
                    total+=10;
                    g.drawString(splittingString1[i].substring(6, splittingString1[i].length()) , x, y + total);
                    total+=10;
                }
                else {
                    g.drawString(splittingString1[i], x, y + total);
                    total+=10;
                }
            }
        }
        else if(splittingString1.length >= 4) { // used to be == 4. Changed to >= as it will cover 4+ and there may be a longer name which is why it wasnt drawing
            for (int i = 0; i < splittingString1.length; i++) {
                g.drawString(splittingString1[i], x, y + i * 10);
            }
        }
    }

    private static void SpacingNamesSides(Graphics g, String toSplit, int x, int y) // sides
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