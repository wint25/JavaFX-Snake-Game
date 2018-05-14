/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegameObjects;

/**
 *
 * @author winte
 */
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle; 
import javafx.scene.paint.*;

public class Food {
    //declare variables and objects
   private Color c1; 
   private double xCenter;
    
   private double yCenter;
   private double radius; 
  
   private int randomNum;  
   Circle circle; 
   private Direction direction;
   int randX = (int)(Math.random() * 21);
   int randY = (int)(Math.random() * 20);
   //default constructor
   public Food(){
       this.c1 = Color.GREEN;
       this.randomNum = (int)(Math.random() * 5);
       this.xCenter = 0;
       this.yCenter = 3;
       this.radius = 9; 
       this.circle = new Circle(this.xCenter, this.yCenter, this.radius);
       this.direction = new Direction();
   }
   //assign a default colour
   public void setColor(Color color){
       this.c1 = color;
       circle.setFill(this.c1);
   }

   //return circle
   public Circle getCircle(){
       return circle; 
   }
   //access newly formed yValue
   public int getX(){
       return randX;
   }
   //access newly formed xValue
   public int getY(){
       return randY;
   }
   //method to assign new colour
   public void randomColor(){
    if (randomNum == 1){
        setColor(Color.RED);
    } else if (randomNum == 2){
        setColor(Color.YELLOW);
    }else if (randomNum == 3){
        setColor(Color.ORANGE);
    } else{
        setColor(Color.GREEN);
    }
   }
  //method to get circle colour 
  public Color getColor(){
      return this.c1; 
  }

 //method to set a new x value
 public void newRandx(){
       this.randX =  (int)(Math.random() * 21);
}
 //method to set a new y value
  public void newRandy(){
       this.randY =  (int)(Math.random() * 20);
}
  //method to set and new colour number
   public void newRandNum(){
       this.randomNum =  (int)(Math.random() * 5);
}
}


