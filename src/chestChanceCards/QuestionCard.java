package chestChanceCards;

import player.Player;
import twitterbotics.KnowledgeBaseModule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class QuestionCard extends Card {
    private Random rand = new Random();
    private String[] FIELDS = {"Typical Activity", "Vehicle of Choice", "Weapon of Choice", "Seen Wearing"};
    private KnowledgeBaseModule NOC = new KnowledgeBaseModule(kdir + "Veale's The NOC List.txt", 0);

    public QuestionCard(Player p) {
        super(p);
    }

    private String getName() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(kdir + "Veale's The NOC List.txt"));
        int lineNum = rand.nextInt(825) + 1;
        for (int i = 0; i < lineNum - 1; i++) {
            br.readLine();
        }
        return br.readLine().split("\t")[0];
    }

/*
return an array of strings in the format {category, option1, option2, option3, option 4, item, answer}
 */
    public String[] Question(){
        String[] result = new String[7];
        String category = FIELDS[rand.nextInt(4)];
        String currName = "";

        result[0] = category;
        for(int i = 0; i < 4; i ++){
            try {
                currName = getName();
            } catch (Exception e) {
                e.printStackTrace();
            }
            result[i+1] = currName;
            if(NOC.getFirstValue(category, currName) == null || NOC.getFirstValue(category, currName).contains("Daimler DB18 Drophead")){
                i--;
            }
        }
        String answer = result[rand.nextInt(4) + 1];
        String item = NOC.getFirstValue(category, answer);
        result[5] = item;
        result[6] = answer;
        return result;

    }
}

