/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import snakegameObjects.Direction;
import snakegameObjects.Food;
import snakegameObjects.InputValidations;
import snakegameObjects.Score;
import snakegameObjects.Snake;
import snakegameObjects.Timer1;

/**
 *
 * @author winte
 */
public class FXMLDocumentController implements Initializable {
   //declare FXML variables 
    @FXML
    public AnchorPane pane;
    @FXML
    private GridPane grid; 
    

    //declare boolean variables for direction control
      boolean Up;
    boolean Down;
    boolean Right;
    boolean Left;
     

         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        //declare the timer
   Timer1 gameStart = new Timer1(grid);
   //assign default boolean for direction cocntrol
        Right = true;
        Up = false;
        Down = false;
        Left = false;
        
       
          grid.setFocusTraversable(true);
       
        //must have lambta exxpression to allow user to change directions
        grid.setOnKeyPressed(e->{
         if(e.getCode() == KeyCode.UP){
             Right = false;
             Up = true;
             Down = false;
             Left = false;
             gameStart.updateBoolean(Up, Down, Right, Left);
           
         } else if (e.getCode() == KeyCode.DOWN){
             Right = false;
             Up = false;
             Down = true;
             Left = false; 
             gameStart.updateBoolean(Up, Down, Right, Left);
         } else if (e.getCode() == KeyCode.LEFT){
            Right = false;
            Up = false;
            Down = false;
            Left = true;
            gameStart.updateBoolean(Up, Down, Right, Left);
        } else if (e.getCode() == KeyCode.RIGHT){
            Right = true;
            Up = false;
            Down = false;
            Left = false;
            gameStart.updateBoolean(Up, Down, Right, Left);
        }
        });
 
   grid.requestFocus();
    }  
    
 

}
