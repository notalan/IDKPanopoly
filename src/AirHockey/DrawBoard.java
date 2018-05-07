package AirHockey;

import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class DrawBoard extends JPanel {

    private int x, y, i, j, a, b;
    private int directionY[] = {0}; // 0 = nothing, 1 = down, 2 = up
    private int directionX[] = {0}; // 0 = nothing, 1 = left, 2 = right
    private int scoreP1 = 0, scoreCPU = 0;
    private boolean goal10 = true, goal11 = false, goal12 = false, goal13 = false;
    private boolean goal20 = true, goal21 = false, goal22 = false, goal23 = false;
    private boolean gameOver = false;
    Player PLAYER;

    public DrawBoard(Player player) {
        this.addKeyListener(new CircleListener());
        this.setFocusable(true);
        this.PLAYER = player;
        posInit();
        moveBall();
        moveCPU();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        g.drawRect(0, 0, 400, 600);
        g.setColor(Color.red);
        g.drawLine(0, 0, 0, 600);
        g.drawLine(400, 0, 400, 600);
        g.drawLine(0, 0, 400, 0);
        g.drawLine(0, 600, 400, 600);
        g.drawLine(0, 300, 400, 300);
        g.fillOval(190, 290, 20, 20);
        g.setColor(Color.blue);
        g.drawOval(100, 200, 200, 200);
        g.drawArc(100, -100, 200, 200, 180, 180);
        g.drawArc(100, 500, 200, 200, 0, 180);
        g.setColor(Color.black);
        g.fillOval(x-(20/2), y, 20, 20);
        g.fillOval(a-(20/2), b, 20, 20);
        g.drawOval(180, 280, 40, 40);
        g.drawRect(100,600, 200, 50);
        g.setColor(Color.green);
        g.fillOval(i-(40/2), j-(40/2), 40, 40);
        g.setColor(Color.white);
        g.fillRect(0,600, 600, 50);
        g.setColor(Color.black);
        g.drawLine(10,605, 10, 645);
        g.drawArc(-11, 605, 45, 30, 270, 180);
        g.drawLine(50, 605, 50, 645);
        g.drawLine(50, 645, 70, 645);
        g.drawLine(90, 605, 80, 645);
        g.drawLine(90, 605, 100, 645);
        g.drawLine(85, 625,  95, 625);
        g.drawLine(115, 605, 125, 635);
        g.drawLine(125, 635, 125, 645);
        g.drawLine(135, 605, 125, 635);
        g.drawLine(150, 605, 150, 645);
        g.drawLine(150, 605, 165, 605);
        g.drawLine(150, 625, 165, 625);
        g.drawLine(150, 645, 165, 645);
        g.drawLine(175,605, 175, 645);
        g.drawArc(154, 605, 45, 30, 270, 180);
        g.drawLine(180, 635, 200, 645);
        g.drawArc(355, 615, 25, 30, 180, 182);
        g.drawLine(355, 605, 355, 630);
        g.drawLine(380, 605, 380, 630);
        g.drawLine(320,605, 320, 645);
        g.drawArc(300, 605, 45, 30, 270, 180);
        g.drawArc(280, 605, 40, 40, 70, 230);
        g.drawLine( 210, 640, 230, 640);
        g.drawLine( 250, 640, 270, 640);
        g.drawLine(235, 625, 245, 625);

        if(goal10)
        {
            g.drawLine( 210, 610, 230, 610);
            g.drawLine(210, 610, 210, 640);
            g.drawLine(230, 610, 230, 640);
        }

        if(goal20)
        {
            g.drawLine( 250, 610, 270, 610);
            g.drawLine(250, 610, 250, 640);
            g.drawLine(270, 610, 270, 640);
        }

        if(goal11)
        {
            g.drawLine(220, 610, 220, 640);
            g.drawLine(220, 610, 210, 620);
        }

        if(goal21)
        {
            g.drawLine(260, 610, 260, 640);
            g.drawLine(260, 610, 250, 620);
        }

        if(goal12)
        {
            g.drawLine(210, 640, 210, 625);
            g.drawLine(210, 625, 230, 625);
            g.drawLine(230, 625, 230, 610);
            g.drawLine(230, 610, 210, 610);
        }

        if(goal22)
        {
            g.drawLine(250, 640, 250, 625);
            g.drawLine(250, 625, 270, 625);
            g.drawLine(270, 625, 270, 610);
            g.drawLine(270, 610, 250, 610);
        }

        if(goal13)
        {
            g.drawLine(230, 640, 230, 610);
            g.drawLine(210, 610, 230, 610);
            g.drawLine(210, 625, 230, 625);
        }

        if(goal23)
        {
            g.drawLine(270, 640, 270, 610);
            g.drawLine(250, 610, 270, 610);
            g.drawLine(250, 625, 270, 625);
        }
    }

    private class CircleListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            movePlayers(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private void movePlayers(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if ((x >= 0) && (x <= 400) && ((x + 10) <= 380)) {
                x += 10;
                DrawBoard.this.repaint();
            } else if ((x >= 0) && (x <= 380)) {
                x += (380 - x);
                DrawBoard.this.repaint();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if ((x >= 0) && (x <= 400) && (x - 10 >= 0)) {
                x -= 10;
                DrawBoard.this.repaint();
            } else if ((x > 0) && (x <= 400)) {
                x -= (10 - x);
                DrawBoard.this.repaint();
            }
        }
    }

    private void posInit() {
        x = 200;
        y = 110;
        i = 200;
        j = 280;
        a = 200;
        b = 470;
        directionX[0] = 0;
        directionY[0] = 2;
        DrawBoard.this.repaint();
    }

    private void moveBall() {

        int delay = 20;

        ActionListener moveBall = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(i + " " + j);
                if (isGoal2() || isGoal1()) {

                    goal();

                } else if(isCollision()) {
                    if((Math.abs(i-x) == 0 && Math.abs(j-y) == 40 || Math.abs(j-y) == 0) || (Math.abs(i-a) == 0 && (Math.abs(j-b) == 20)))
                    {
                        switchY();
                        direction(directionY[0], directionX[0]);
                    }
                    else if(i - x < 0 && j-y <= 40 && j-y >= 20 || i - a < 0 && j-b <= 0 && j-b >= -40)
                    {
                        switchX();
                        switchY();
                        direction(directionY[0], directionX[0]);
                    }
                    else if(i - x >= 0 && j-y <= 40 && j-y >= 20 || i - a > 0 && j-b <= 0 && j-b <= -40)
                    {
                        if(directionX[0] == 0)
                        {
                            directionX[0] = 1;
                        }
                        switchX();
                        switchY();
                        direction(directionY[0], directionX[0]);
                    }
                } else if ((i + 20 >= 400 || i - 20 <= 0)) {
                    switchX();
                    direction(directionY[0], directionX[0]);
                } else if ((j + 20 >= 600) || (j - 20 <= 0)) {
                    if(i <= 100 || i >= 300)
                    {
                        switchY();
                        direction(directionY[0], directionX[0]);
                    }
                    else {
                        direction(directionY[0], directionX[0]);
                    }
                }else {
                    direction(directionY[0], directionX[0]);
                }
            }
        };

        Timer timer = new Timer(delay, moveBall);
        timer.start();
    }

    private void moveCPU() {

        int delay = 70;
        Random rand = new Random();

        ActionListener moveCPU = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int chooseSpeed = rand.nextInt(2);
                int speed = 0;

                if (chooseSpeed == 0) {
                    speed = 20;
                } else if (chooseSpeed == 1) {
                    speed = 30;
                } else if (chooseSpeed == 2) {
                    speed = 40;
                }

                if (i - a < 0 && a - 40 > 0) {
                    a -= speed;
                } else if (i - a > 0 && a + 40 < 400) {
                    a += speed;
                }
            }
        };

        Timer timer2 = new Timer(delay, moveCPU);
        timer2.start();
    }

    private void direction(int directionY, int directionX) {
        if (directionY == 1 && directionX == 1) {
            j += 10;
            i -= 10;
            DrawBoard.this.repaint();
        } else if (directionY == 1 && directionX == 2) {
            j += 10;
            i += 10;
            DrawBoard.this.repaint();
        } else if (directionY == 2 && directionX == 1) {
            j -= 10;
            i -= 10;
            DrawBoard.this.repaint();
        } else if (directionY == 2 && directionX == 2) {
            j -= 10;
            i += 10;
            DrawBoard.this.repaint();
        } else if (directionX == 0 && directionY == 2) {
            j -= 10;
            DrawBoard.this.repaint();
        } else if (directionX == 0 && directionY == 1) {
            j += 10;
            DrawBoard.this.repaint();
        }
    }

    private void switchX()
    {
        if(directionX[0] == 0)
        {
            directionX[0] = 1;
        }
        else if(directionX[0] == 1)
        {
            directionX[0] = 2;
        }
        else if(directionX[0] == 2)
        {
            directionX[0] = 1;
        }
    }

    private void switchY()
    {
        if(directionY[0] == 1)
        {
            directionY[0] = 2;
        }
        else if(directionY[0] == 2)
        {
            directionY[0] = 1;
        }
    }

    private void goal()
    {
        if (isGoal1()) {
            JOptionPane.showMessageDialog(null, "Goal Player 1!!!!!");
            scoreP1++;

            if(scoreP1 == 1)
            {
                goal10 = !goal10;
                goal11 = true;
                DrawBoard.this.repaint();
            }
            else if(scoreP1 == 2)
            {
                goal11 = !goal11;
                goal12 = true;
                DrawBoard.this.repaint();
            }
            else if(scoreP1 == 3)
            {
                goal12 = !goal12;
                goal13 = true;
                DrawBoard.this.repaint();
            }

            if(scoreP1 == 3)
            {
                JOptionPane.showMessageDialog(null, "Player 1 Wins!!!!!! +50 SD");
                PLAYER.earnsMoney(50);
                gameOver = true;
            }
            posInit();
        }
        else if (isGoal2()) {
            JOptionPane.showMessageDialog(null, "Goal CPU!!!!!");
            scoreCPU++;

            if(scoreCPU == 1)
            {
                goal20 = !goal20;
                goal21 = true;
                DrawBoard.this.repaint();
            }
            else if(scoreCPU == 2)
            {
                goal21 = !goal21;
                goal22 = true;
                DrawBoard.this.repaint();
            }
            else if(scoreCPU == 3)
            {
                goal22 = !goal22;
                goal23 = true;
            }

                if(scoreCPU == 3)
            {
                JOptionPane.showMessageDialog(null, "CPU Wins!!!!!! -50 SD");
                PLAYER.pay(50);
                gameOver = true;
            }
            posInit();
        }
    }

    private boolean isGoal1()
    {
        return (j >= 600) && (i >= 120 && i <= 280);

    }

    private boolean isGoal2()
    {
        return (j == 0) && (i > 120 && i < 280);
    }

    private boolean isCollision()
    {
        double xDiff = i - a;
        double yDiff = j - b;
        double xDiff2 = i - x;
        double yDiff2 = j - y;

        double d = Math.pow(xDiff, 2) + Math.pow(yDiff, 2);
        double d2 = Math.pow(xDiff2, 2) + Math.pow(yDiff2, 2);

        return d < Math.pow((30 + 20 - 20), 2) || d2 < Math.pow((30 + 20), 2);
    }

    public boolean isGameOver()
    {
        return gameOver;
    }
}
