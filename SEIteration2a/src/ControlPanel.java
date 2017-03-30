
// http://docs.oracle.com/javafx/2/get_started/hello_world.htm
// https://docs.oracle.com/javafx/2/api/javafx/application/Application.html
// http://www.java2s.com/Tutorials/Java/JavaFX/0040__JavaFX_Line.htm
// http://code.makery.ch/blog/javafx-8-event-handling-examples/

//package hutchenshomies;

/**
 *
 * @author mmhahn1
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

 
public class ControlPanel extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
	// Shows GUI with two buttons: "Draw Line" and "Draw Class Box"
    public void start(Stage primaryStage) {
    	
        primaryStage.setTitle("Controls");
        
        Button lineBtn = new Button();
        Text toggleLineRes = new Text("Ready");
        Button boxBtn = new Button();
        Button eraser = new Button();
        
        lineBtn.setText("Push to Draw Line");
        boxBtn.setText("Push to Draw Class Box");
        eraser.setText("Push to Enter Eraser Mode");
        
        DrawGraphical dg = new DrawGraphical(toggleLineRes);
     
        boxBtn.setOnAction(new EventHandler<ActionEvent>() {
        	
        	public void handle(ActionEvent event) {
        		dg.drawClassBox();
        	}
        	
        });
        
        lineBtn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	dg.toggleLineDraw();
        
            }
        });
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.add(lineBtn, 1, 1);
        root.add(toggleLineRes, 2, 1);
        root.add(boxBtn, 1, 2);
        
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }
  
}
