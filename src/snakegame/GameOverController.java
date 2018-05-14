/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author winte
 */
public class GameOverController implements Initializable {
//declare FXML variables
   @FXML
    private AnchorPane thepane;
    @FXML
    private Button playagain;
    /**
     * Initializes the controller class.
     */
    
   
  @FXML private Label thescore;
  //declare stage for first controller
 Stage stage = new Stage();
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //assign scores to label 
        try {
         
            thescore.setText(getFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameOverController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
      //button to hide second screen and open game screen and controller
       playagain.setOnMouseClicked(e->{
       Stage sTage = new Stage();
                Scene scene;
                AnchorPane root = null;
                try {
                    root =(AnchorPane)FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                   
                 scene = new Scene(root);
                sTage.setScene(scene);
                Platform.setImplicitExit(true);
             
              Stage stage = Stage.class.cast(thepane.getScene().getWindow()); 
               
               stage.hide();
                sTage.show();
       
       
       }   catch (IOException ex) {
               Logger.getLogger(GameOverController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
    }    
  
    
   //method to access file the first controller wrote to with scores
    public String getFile() throws FileNotFoundException {
   File f1 = new File("test/score.txt");
   String scores = " ";
   //need to read the file
   Scanner scan = new Scanner(f1);
   while(scan.hasNext()){
       scores = scan.nextLine();
   }
   return scores;
  }
}
