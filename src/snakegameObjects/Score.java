/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegameObjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

/**
 *
 * @author winte
 */
public class Score {

    //arrayList to hold all score values
    ArrayList<Integer> l= new ArrayList<Integer>();
    // default contructor
    public Score(){

    }
    

    //determine the score type by colour
    public int whatScoreType(Food food){
        int scoreType = 0;
        if (food.getColor() == Color.RED){
            scoreType = 2;
           
        } else{
            scoreType = 1; 
           
        }
        
        return scoreType; 
    }
    
    //add score to arraylist
    public void addScoreToArrayList(int score){
        l.add(score);
       
        
    }
    
    //method to calculate the scores
    public String calcScores(Score score){
        int sum = 0;
        String Score;
        for(int i = 0; i < score.l.size(); i++){
            sum += score.l.get(i);
        }
        String thesum = Integer.toString(sum);
        Score = "Your score is " + thesum + " !";
        return Score;
    }
    //wrting the scores to a file
    public void writeScores(String string) throws FileNotFoundException{
        File f1 = new File("test/score.txt");
        PrintWriter pw = new PrintWriter(f1);
        pw.write(string);
        pw.close();
    }
}
