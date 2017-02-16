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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
 
public class Practice1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Time to Draw!");
        Button btn1 = new Button();
        btn1.setText("Push to Draw Line");
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	Stage stage = new Stage();
            	drawLine(stage);
            }
        });
        
        Button btn2 = new Button();
        btn2.setText("Push to Draw Circle");
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
        	
        	public void handle(ActionEvent event) {
        		Stage s = new Stage();
        		drawCircle(s);
        	}
        	
        });
        
        Pane root = new Pane();
        btn1.setLayoutX(200);
        btn1.setLayoutY(180);
        root.getChildren().add(btn1);
        btn2.setLayoutX(200);
        btn2.setLayoutY(220);
        root.getChildren().add(btn2);
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }
    
    public void drawLine(Stage stage) {
    	VBox box = new VBox();
        final Scene scene = new Scene(box,300, 250);
        scene.setFill(null);
        
        Line line = new Line();
        line.setStartX(0.0f);
        line.setStartY(0.0f);
        line.setEndX(100.0f);
        line.setEndY(100.0f);
        
        box.getChildren().add(line);
        
        stage.setTitle("Line");
        stage.setScene(scene);
        stage.show();
    }
    
    public void drawCircle(Stage stage) {
    	Circle circ = new Circle(40, 40, 30);
        Group root = new Group(circ);
        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("Circle");
        stage.setScene(scene);
        stage.show();
    }
}