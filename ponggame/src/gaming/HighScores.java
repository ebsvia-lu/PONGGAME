package gaming;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.List;


public class HighScores{
    ArrayList<Integer> scores;
    File scoreFile;
    public HighScores(){
        scores = new ArrayList<Integer>();
        scoreFile = new File("src/gaming/highscores.txt");
    }

    public void saveScores(){ //save scores after the game is over
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(scoreFile,true));
            for(Integer i: scores){
                writer.write(String.valueOf(i)+"\r\n"); //writes to file
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addScore(int score){ //add scores
        scores.add(score);
        orderList();
        saveScores();                //save scores
    }

    public List<Integer> getTop10(){      //create a list
        List<Integer> top10 = scores.subList(0,10);
        return top10;
    }

    private void orderList(){
        Collections.sort(scores, Collections.reverseOrder());
    }


}


