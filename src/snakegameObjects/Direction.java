/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegameObjects;

import java.util.ArrayList;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 *
 * @author winte
 */

public class Direction {
//declare arraylists to hold backup x and y values to move snake in new direction
    ArrayList<Integer> x = new ArrayList<Integer>();
    ArrayList<Integer> y = new ArrayList<Integer>();
    public Direction(){

    }
  
//method to setup new values to backup array
    public void setUpXYBackup(ArrayList<Integer> oldx, ArrayList<Integer> oldy){
        for(int i = 0; i < oldx.size(); i++){
            x.add(oldx.get(i));
            y.add(oldy.get(i));
        }
    }
    //methos to reset new backup array with new values
    public void resetXYBackup(ArrayList<Integer> oldx, ArrayList<Integer> oldy){
        for(int i = 0; i < oldx.size(); i++){
            x.set(i, oldx.get(i));
            y.set(i, oldy.get(i));
        }
    }
    //method to only add one new x and one new y value to backup
    public void addNewToBackup(ArrayList<Integer> oldx, ArrayList<Integer> oldy){
        x.add(oldx.get(oldx.size() - 1));
        y.add(oldy.get(oldy.size() - 1));
    }
    //method to turn the snake
   public void turnTheSnake(Snake snake, InputValidations input, int direct){
     
    for(int j = 0; j < snake.xValue.size(); j++){
         
         if(j == 0){
             
             
                 if(direct == 0){
                 input.translateYUp(snake);
                }else if (direct == 1){
                 input.translateYDown(snake);
                     }else if(direct == 2){
                 input.translateXRight(snake);
                     }else{
                 input.translateXLeft(snake); 
             }
         }else{
             snake.xValue.set(j, x.get(j - 1));
             snake.yValue.set(j, y.get(j - 1));
             
         }
         
         
     }
     
       
   } 
}
