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

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle.Control;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import snakegame.GameOverController;
import snakegameObjects.Food;

public class Timer1 extends GridPane{
    //declare second controller
    GameOverController GameOver;
    
    //declare objects
     private Direction direction; 
    private InputValidations inputValid; 
    private Score score; 
    private Timeline timer;
     private Snake snake = new Snake();
    private Food food = new Food();

   //declare and assign inital body of snake
    private Circle head = new Circle(0, 3, 9);
    private Circle midHead = new Circle(0, 3, 9);
    private Circle midTail = new Circle(0, 3, 9);
    private Circle tail = new Circle(0, 3, 9); 
    
    //delcare arraylist to hold snake body
    ArrayList<Circle> circles = new ArrayList<Circle>();

    //variable to control snake movement
    int dir;
    
    //variable if there is food
    boolean yesFood;
    
    //boolean control for movements of the snake
    boolean Up;
    boolean Down;
    boolean Right;
    boolean Left;
    
    //second boolean control to hold previous movements of the snake
    boolean up;
    boolean down;
    boolean right;
    boolean left;
    
    //Timer1 constructor
    public Timer1(GridPane grid){
        //set default grid movement
        Right = true;
        Up = false;
        Down = false;
        Left = false;
        
        //set default past movement 
        right = true;
        up = false;
        down = false;
        left = false;
        
      //head, tail, midHead, midTail of snake body added to ArrayList
     circles.add(head);
     circles.add(midHead);
     circles.add(midTail);
     circles.add(tail);
     
     //add snake body to gridpane
        grid.getChildren().addAll(circles);
        grid.setConstraints(circles.get(0), 3, 0);
        grid.setConstraints(circles.get(1), 2, 0);
        grid.setConstraints(circles.get(2), 1, 0);
        grid.setConstraints(circles.get(3), 0, 0);
        
        //set the colour of the snake
        head.setFill(Color.BLUE);
        tail.setFill(Color.BLUE);
        midHead.setFill(Color.BLUE);
        midTail.setFill(Color.BLUE);
        
        //create objects
        direction = new Direction();
        inputValid = new InputValidations();
        score = new Score();
        
        //create food and add to gridpane
        food.randomColor();
        Circle foodPiece = food.getCircle();
        grid.getChildren().add(foodPiece);
        grid.setConstraints(foodPiece, food.getX(), food.getY());
        
        //setup backup arraylists
        direction.setUpXYBackup(snake.xValue, snake.yValue);
        
        // create timer and set default speed
        timer = new Timeline(
        new KeyFrame(Duration.millis(1000), e -> {
            try {
                gameLoop(grid, foodPiece);
            } catch (IOException ex) {
                Logger.getLogger(Timer1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }
    //method to create the gameloop
   public void gameLoop(GridPane grid, Circle foodPiece) throws IOException{
  
       //takes in keycode input and decides what direction to move snake
       
           if (Up == true){
            
                dir = 0;
            if(down == true){
             
                Up = up;
                Down = down;
                Right = right;
                Left = left;
            }else{    
                up = Up;
                down = Down;
                right = Right;
                left = Left;
            
            direction.turnTheSnake(snake, inputValid, dir);
            snake.didSnakeEatTail(snake, snake.xValue, snake.yValue, circles, grid, score);
            if(snake.yValue.get(0)== 21 || snake.yValue.get(0) == -1 || snake.xValue.get(0) == -1){
                stopGame(grid);
                
            }else{
            try{
            for(int i = 0; i < snake.yValue.size(); i++){
            grid.setConstraints(circles.get(i), snake.xValue.get(i), snake.yValue.get(i));
            }
            }catch(IllegalArgumentException ex){
                    stopGame(grid);
                    }
           yesFood = isThereFood(grid, foodPiece);
           if(yesFood == false){
               direction.resetXYBackup(snake.xValue, snake.yValue);
           }else{
               direction.addNewToBackup(snake.xValue, snake.yValue);
               direction.resetXYBackup(snake.xValue, snake.yValue);
           }
          }
        }
      }
       
            if(Down == true){
                dir = 1;
          
            if(up == true){
             
                Up = up;
                Down = down;
                Right = right;
                Left = left;
            }else{
                 up = Up;
                down = Down;
                right = Right;
                left = Left;
           direction.turnTheSnake(snake, inputValid, dir);
           snake.didSnakeEatTail(snake, snake.xValue, snake.yValue, circles, grid, score);
           if(snake.yValue.get(0)== 21 || snake.yValue.get(0) == -1){
                stopGame(grid);
            }else{
           try{
            for(int i = 0; i < snake.yValue.size(); i++){
            grid.setConstraints(circles.get(i), snake.xValue.get(i), snake.yValue.get(i));
                    }
           }catch(IllegalArgumentException ex){
               stopGame(grid);
           }
            yesFood = isThereFood(grid, foodPiece);
           if(yesFood == false){
               direction.resetXYBackup(snake.xValue, snake.yValue);
           }else{
               direction.addNewToBackup(snake.xValue, snake.yValue);
               direction.resetXYBackup(snake.xValue, snake.yValue);
           }
         }
       }
     }
            
            if(Right == true){
                dir = 2;
        
            if(left == true){
             
                 Up = up;
                Down = down;
                Right = right;
                Left = left;
            }else{
           
                up = Up;
                down = Down;
                right = Right;
                left = Left;
            direction.turnTheSnake(snake, inputValid, dir);
            snake.didSnakeEatTail(snake, snake.xValue, snake.yValue, circles, grid, score);
            if(snake.xValue.get(0)== 22 || snake.xValue.get(0) == -1){
                stopGame(grid);
            }else{
            try{
            for(int i = 0; i < snake.xValue.size(); i++){
            grid.setConstraints(circles.get(i), snake.xValue.get(i), snake.yValue.get(i));
                    }
            }catch(IllegalArgumentException ex){
                stopGame(grid);
            }
            yesFood = isThereFood(grid, foodPiece);
            if(yesFood == false){
               direction.resetXYBackup(snake.xValue, snake.yValue);
           }else{
               direction.addNewToBackup(snake.xValue, snake.yValue);
               direction.resetXYBackup(snake.xValue, snake.yValue);
           }
         }
        }
      } 
            if(Left == true){
           
                dir = 3;
           
            if(right == true){
            
                Up = up;
                Down = down;
                Right = right;
                Left = left;
            }else{
          
                up = Up;
                down = Down;
                right = Right;
                left = Left;
           direction.turnTheSnake(snake, inputValid, dir);
           snake.didSnakeEatTail(snake, snake.xValue, snake.yValue, circles, grid, score);
            if(snake.xValue.get(0)== 22){
                stopGame(grid);
            }else{
            try{
            for(int i = 0; i < snake.xValue.size(); i++){
            grid.setConstraints(circles.get(i), snake.xValue.get(i), snake.yValue.get(i));
                    }
            }catch(IllegalArgumentException ex){
                stopGame(grid);
            }
            yesFood = isThereFood(grid, foodPiece);
            if(yesFood == false){
               direction.resetXYBackup(snake.xValue, snake.yValue);
           }else{
               direction.addNewToBackup(snake.xValue, snake.yValue);
               direction.resetXYBackup(snake.xValue, snake.yValue);
           }
            
         }
       }
      }
        
        
        
    }
   
    //method to add a new snake body part to array
        public void addCircleToArray(){
        circles.add(new Circle(0, 3, 9));
    }
     
    //method to set a new circle on the grid
    public void setgridConstraint(GridPane grid, int index, int x, int y){
       // Circle newc = circles.get(index)
        grid.getChildren().add(circles.get(index));
        grid.setConstraints(circles.get(index), x, y);
        circles.get(index).setFill(Color.BLUE);
    }
    //method to check if there is food
    public boolean isThereFood(GridPane grid, Circle foodPiece){
        boolean isFood = false;
       isFood = snake.didSnakeEat(food);
       if (isFood == true){
           food.newRandx();
           food.newRandy();
           food.newRandNum();
           food.randomColor();
          
           grid.setConstraints(foodPiece, food.getX(), food.getY());
          
           score.addScoreToArrayList(score.whatScoreType(food));
           int x = snake.xValue.get(snake.xValue.size() - 1);
           int y = snake.yValue.get(snake.yValue.size() - 1);
           snake.newSnakeBodyPart(circles, grid, inputValid, snake);
       
           setgridConstraint(grid, circles.size()-1, x, y);
          
           increaseSpeed();
       }
        return isFood;
       
    }
    
    
    //to stop the game and bring up new FXML and controller and hide game 
   public void stopGame(GridPane grid) throws IOException{
   
       timer.stop();
       score.writeScores(score.calcScores(score));
      Platform.runLater(()->{
  
           try {
               Stage sTage = new Stage();
               Scene scene;
             AnchorPane root;
            GameOver = new GameOverController();
            
             root   =(AnchorPane)FXMLLoader.load(GameOverController.class.getResource("gameOver.fxml"));
             scene = new Scene(root);
                sTage.setScene(scene);
                Stage stage = Stage.class.cast(grid.getScene().getWindow()); 
                stage.hide();
                 Platform.setImplicitExit(false);
                 sTage.show();
           } catch (IOException ex) {
               Logger.getLogger(Timer1.class.getName()).log(Level.SEVERE, null, ex);
           }
    
                });
   }
  //method to start the game
   public void play(){
       timer.play();
   }
   //method to increase the speed of the game
   public void increaseSpeed(){
       timer.setRate(timer.getCurrentRate() + 0.1);
   }
   //method to update the direction boolean controls
   public void updateBoolean(boolean up, boolean down, boolean right, boolean left){
       this.Up = up;
       this.Down = down;
       this.Right = right;
       this.Left = left;
   }
   
}

