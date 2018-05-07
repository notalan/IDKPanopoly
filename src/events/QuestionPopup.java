package events;

import player.Player;
import transactions.ExpenditureTransaction;
import transactions.IncomeTransaction;
import twitterbotics.KnowledgeBaseModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Input:  array of strings in the format {category, option1, option2, option3, option 4, item, answer}
 */
public class QuestionPopup extends JFrame {
    public QuestionPopup(String[] input, final Player player){
        setUndecorated(true);
        setBounds(100, 100, 450, 250);
        JLabel top;

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(Box.createRigidArea(new Dimension(400, 20)));

        String kdir = "DATA/TSV Lists/";
        String det;
        switch(input[0]) {
            case "Seen Wearing":
                KnowledgeBaseModule clothes = new KnowledgeBaseModule(kdir + "Veale's clothing line.txt", 1);
                det = clothes.getFirstValue("Determiner", input[5]) + " ";
                if (det.equals(null + " ")) {
                    det = "";
                }
                top = new JLabel("Which person would you see wearing " + det + input[5] + "?");
                top.setAlignmentX(Component.CENTER_ALIGNMENT);
                p.add(top);
                break;
            case "Weapon of Choice":
                KnowledgeBaseModule weapons = new KnowledgeBaseModule("DATA/TSV Lists/Veale's weapon arsenal.txt", 1);
                KnowledgeBaseModule NOC = new KnowledgeBaseModule("DATA/TSV Lists/Veale's The NOC List.txt", 0);
                String opponent = NOC.getFirstValue("Opponent", input[6]);
                String affordance = weapons.getFirstValue("Affordances", input[5]);
                det = weapons.getFirstValue("Determiner", input[5]) + " ";
                if (det.equals(null + " ")) {
                    det = "";
                }
                String[] affordanceSplit = affordance.split(" ");
                String assualting = "";
                if (opponent != null) {
                    for (int i = 0; i < affordanceSplit.length; i++) {
                        assualting += affordanceSplit[i] + " ";
                        if (i == 0) {
                            assualting += opponent + " ";
                        }
                    }
                }
                if (assualting.equals("")) {
                    top = new JLabel("You see someone with " + det + input[5] + ", who is it?");
                    top.setAlignmentX(Component.CENTER_ALIGNMENT);
                    p.add(top);
                } else {
                    top = new JLabel("You see someone " + assualting);
                    JLabel newLine = new JLabel(det + input[5] + ", who is it?");
                    newLine.setAlignmentX(Component.CENTER_ALIGNMENT);
                    top.setAlignmentX(Component.CENTER_ALIGNMENT);
                    p.add(top);
                    p.add(newLine);
                }
                break;
            case "Vehicle of Choice":
                KnowledgeBaseModule vehicles = new KnowledgeBaseModule("DATA/TSV Lists/Veale's vehicle fleet.txt", 1);
                affordance = vehicles.getFirstValue("Affordances", input[5]) + " ";
                det = vehicles.getFirstValue("Determiner", input[5]) + " ";

                if (det.equals(" ")) {
                    det = "";
                }
                if (affordance.equals(" ")) {
                    affordance = "";
                }
                top = new JLabel("You see someone " + affordance + det + input[5] + ", who is it?");
                top.setAlignmentX(Component.CENTER_ALIGNMENT);
                p.add(top);
                break;
            case "Typical Activity":
                top = new JLabel("Whom might you see " + input[5] + "?");
                top.setAlignmentX(Component.CENTER_ALIGNMENT);
                p.add(top);
                break;
        }

        p.add(Box.createRigidArea(new Dimension(400, 50)));

        for(int i = 0; i < 4; i++){
            JButton option = new JButton(input[i+1]);
            if(input[i+1].equals(input[6])){
                option.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new IncomeTransaction(player, 50);
                        new CorrectPopUp();
                        dispose();
                    }
                });
            }
            else{
                option.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new ExpenditureTransaction(player, 50);
                        new IncorrectPopUp();
                        dispose();
                    }
                });
            }

            p.add(option);
            option.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        add(p);
        setAlwaysOnTop(true);
        setVisible(true);
    }
}
