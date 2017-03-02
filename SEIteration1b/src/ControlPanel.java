
// http://docs.oracle.com/javafx/2/get_started/hello_world.htm
// https://docs.oracle.com/javafx/2/api/javafx/application/Application.html
// http://www.java2s.com/Tutorials/Java/JavaFX/0040__JavaFX_Line.htm
// http://code.makery.ch/blog/javafx-8-event-handling-examples/

// javafx.scene.input.inputevent

//import java.util.ArrayList;

//Tracks the class boxes
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Group;

 
public class ControlPanel extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
	// Shows GUI with two buttons: "Draw Line" and "Draw Class Box"
    public void start(Stage primaryStage) {
    	
        primaryStage.setTitle("Controls");
        
        Button lineBtn = new Button();
        Button boxBtn = new Button();
        
        lineBtn.setText("Push to Draw Line");
        boxBtn.setText("Push to Draw Class Box");
        
        Stage stage = new Stage();
        stage.setTitle("Graphical View");
        Group a = new Group();
        Scene scene = new Scene(a, 1250, 800);
        
        ArrayList<DrawClassBox> boxes = new ArrayList<DrawClassBox>(4);
        //int boxCount = 0;
        double size = 0.75;
        
        boxBtn.setOnAction(new EventHandler<ActionEvent>() {
        	
        	public void handle(ActionEvent event) {
        		newClassBox(stage, scene, a, boxes, size);
        	}
        	
        });
        
        lineBtn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	if(boxes.size() >= 2){
            		// Draws a line from the most recently drawn class box to a random other class box
			// Calls methods for most recently drawn box
            		(boxes.get(boxes.size()-1)).drawNewLine(boxes);
            	}
            }
        });
        
        Group root = new Group();
        lineBtn.setLayoutX(200);
        lineBtn.setLayoutY(180);
        root.getChildren().add(lineBtn);
        boxBtn.setLayoutX(200);
        boxBtn.setLayoutY(220);
        root.getChildren().add(boxBtn);
        
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }
    
	// When a class box is created, create a text editor to go with it
	// Text editor allows you to add text to each section of the class box
	// Will add or update text when "submit" is pressed
    public void createEditor(DrawClassBox dc){
    	
    	Stage textEditor = new Stage();
        textEditor.setTitle("Text Editor");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        Scene textScene = new Scene(grid, 300, 275);
        textEditor.setScene(textScene);
    	
    	Label name = new Label("Class Name:");
    	grid.add(name, 0, 0);
    	
    	TextField nameField = new TextField();
    	grid.add(nameField, 1, 0);
    	
    	Label att = new Label("Attributes:");
    	grid.add(att, 0, 1);
    	
    	TextField attField = new TextField();
    	grid.add(attField, 1, 1);
    	
    	Label op = new Label("Operations:");
    	grid.add(op, 0,2);
    	
    	TextField opField = new TextField();
    	grid.add(opField, 1, 2);
    	
    	Button submit = new Button("Submit");
    	grid.add(submit, 1, 4);
    	
    	submit.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
            	dc.setAllText(nameField.getText(), attField.getText(), opField.getText());
            }
        });
    	
    	textEditor.show();
    }
    
	// When "Draw Class Box" is pressed, check if there's room for a new class box
	// If there is, create a new DrawClassBox, create an associated editor, and add to class box list
    public void newClassBox(Stage stage, Scene scene, Group a, ArrayList<DrawClassBox> boxes, double size){
    	
    	int count = boxes.size();
    	
    	if (count >= 8){
    		return;
    	}
    	
    	DrawClassBox dc = new DrawClassBox(stage, scene, a, count);
    	dc.setBase(size);
		dc.drawClass();
		
		createEditor(dc);
		
		boxes.add(dc);
	
		// Create a new text editor for each class box
    }
  
}



