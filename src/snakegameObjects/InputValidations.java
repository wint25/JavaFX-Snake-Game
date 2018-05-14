/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegameObjects;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;

/**
 *
 * @author winte
 */
public class InputValidations {

    
    //constructor
    public InputValidations(){

    }
    

  //determine if snake is facing right
    public boolean snakeisRight(Snake snake){
        boolean isRight = false;
        if (snake.getYCoordinate(1) == (snake.getYCoordinate(snake.getLength() -1)) && snake.getXCoordinate(1) > (snake.getXCoordinate(snake.getLength() -1))){
            isRight = true;
        }
        return isRight; 
    }
    //determine if snake is facing left
    public boolean snakeisLeft(Snake snake){
        boolean isLeft = false;
        if (snake.getYCoordinate(1) == (snake.getYCoordinate(snake.getLength() -1)) && snake.getXCoordinate(1) < (snake.getXCoordinate(snake.getLength() -1))){
            isLeft = true;
        }
        return isLeft; 
    }
    //determine if snake is facing up
    public boolean snakeisUp(Snake snake){
        boolean isUp = false;
        if (snake.getXCoordinate(1) == (snake.getXCoordinate(snake.getLength() -1)) && snake.getYCoordinate(1) > (snake.getYCoordinate(snake.getLength() -1))){
            isUp = true;
        }
        return isUp; 
    }
    //determine if snake is facing down
    public boolean snakeisDown(Snake snake){
        boolean isDown = false;
      
        if (snake.getXCoordinate(1) == (snake.getXCoordinate(snake.getLength() -1)) && snake.getYCoordinate(1) < (snake.getYCoordinate(snake.getLength() -1))){
            isDown = true;
        
      }
        return isDown; 
    } 
    //move snake head right
    public void translateXRight(Snake snake){
        int i = 0;
        
            snake.xValue.set(i, snake.xValue.get(i) + 1);
            
        
    }

    
    
//move snake head dowwn
    public void translateYDown(Snake snake){
        int i = 0;
       
            snake.yValue.set(i, snake.yValue.get(i) + 1);
       
    }

     //move snake head up
     public void translateYUp(Snake snake){
         int i = 0;
        
             snake.yValue.set(i, snake.yValue.get(i) - 1);
       
     }
//move snake head left
     public void translateXLeft(Snake snake){
         int i = 0;
        
             snake.xValue.set(i, snake.xValue.get(i) - 1);
      
       
    }

  
}
