/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegameObjects;

import java.util.ArrayList;
import javafx.scene.paint.Color;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
/**
 *
 * @author winte
 */
public class Snake {
   //declare colour variable
    private final Color color;


  //arraylists to hold x and y values of snake body
   public ArrayList<Integer> xValue = new ArrayList<Integer>();
   public  ArrayList<Integer> yValue = new ArrayList<Integer>();
   // constructors
    public Snake(){
        this.color = Color.BLUE;
  
        xValue.add(3);
        xValue.add(2);
        xValue.add(1);
        xValue.add(0);
        yValue.add(0);
        yValue.add(0);
        yValue.add(0);
        yValue.add(0);
    
    }
    

    
    //method to add new body part to snake
    public void newSnakeBodyPart(ArrayList<Circle> circles, GridPane grid, InputValidations input, Snake snake){
        circles.add(new Circle(0, 3, 9));
        int x = 0;
        int y =0;
        
        x = snake.xValue.get(snake.xValue.size() - 1);
        y = snake.yValue.get(snake.yValue.size() - 1);
        snake.xValue.add(x);
        snake.yValue.add(y);
  
    
    }


    public int getYCoordinate(int index){
        return yValue.get(index);
    }
    
    public int getXCoordinate(int index){
        return xValue.get(index);
    }
    

    public int getLength(){
        return  xValue.size();

    }

 
    //method to find out if snake ate food
    public boolean didSnakeEat(Food food){
        boolean eat = false;
      
        if (food.getX() == xValue.get(0) && food.getY() == yValue.get(0)){
          
            eat = true;
        }
        return eat;
    }
    
    //method to find out if snake ate itself
    public void didSnakeEatTail(Snake snake, ArrayList<Integer> x, ArrayList<Integer> y, ArrayList<Circle> c1, GridPane grid, Score scores){
        for(int i = 1; i < x.size() - 1; i++){
            if(x.get(0) == x.get(i) && y.get(0) == y.get(i)){
                //int length = x.size() - i;
                int theMainLength = x.size() - 4;
                
                if(x.size() > 4){
                    
                        
                        //now need to figure out how to remove it
                        while(theMainLength > 0){
                            if(scores.l.size() > 0){
                                scores.l.remove(scores.l.size() - 1);
                             }
                            x.remove(x.size() - 1); 
                            y.remove(y.size() - 1);
                            grid.getChildren().remove(c1.get(c1.size() - 1));
                            c1.remove(c1.size() - 1);
                            theMainLength--;
                        
                        
                    }
                }else{
                    while(theMainLength > 0){
                        if(scores.l.size() > 0){
                                scores.l.remove(scores.l.size() - 1);
                             }
                    }
                }
              
            
            }
        }
    }
    
}
