// http://docs.oracle.com/javafx/2/get_started/hello_world.htm
// https://docs.oracle.com/javafx/2/api/javafx/application/Application.html
// http://www.java2s.com/Tutorials/Java/JavaFX/0040__JavaFX_Line.htm
// http://code.makery.ch/blog/javafx-8-event-handling-examples/

// javafx.scene.input.inputevent

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Group;

//import javafx.scene.paint.Color;
//import javafx.scene.shape.Line;
//import javafx.scene.shape.Rectangle;
 
public class Iter1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
        primaryStage.setTitle("Controls");
        
        Button btn1 = new Button();
        Button btn2 = new Button();
        
        btn1.setText("Push to Draw Line");
        btn2.setText("Push to Draw Class Box");
        
        TextField name = new TextField();
        name.setPromptText("Enter the Class Name");
        //name.setPrefColumnCount(10);
        
        Stage stage = new Stage();
        stage.setTitle("Graphical View");
        Group a = new Group();
        Scene scene = new Scene(a, 1000, 700);
        DrawGraphical dg = new DrawGraphical(stage, scene, a);
        //dg.setBase(0.7);
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	dg.drawLine("right");
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
        	
        	public void handle(ActionEvent event) {
        		dg.drawClass();
        	}
        	
        });
        
        name.setOnAction(new EventHandler<ActionEvent>() {
        	
        	public void handle(ActionEvent event) {
        		dg.setClassname(name.getText());
        	}
        });
        
        Group root = new Group();
        btn1.setLayoutX(200);
        btn1.setLayoutY(180);
        root.getChildren().add(btn1);
        btn2.setLayoutX(200);
        btn2.setLayoutY(220);
        root.getChildren().add(btn2);
        root.getChildren().add(name);
        
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }
  
}

// Add text boxes on top of rectangles; can these be bound together?
// Method to make all of Class Box follow as one part is shifted

