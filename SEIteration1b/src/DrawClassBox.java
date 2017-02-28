import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Scene;
//import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DrawClassBox {
	// Variables to track dimensions of box
	double base = 1;
	double width = base*200;
	double height = base*100;
	double startX;
	double startY;
	
	int boxCount;
	
	String className;
	String attributes;
	String ops;
	
	// Initialize empty text
	Text t1 = new Text("");
	Text t2 = new Text("");
	Text t3 = new Text("");
	
	Stage stage;
	Scene scene;
	Group box;
	
	// Pass the necessary stage, scene, and group, as well as number of boxes in box list
	public DrawClassBox (Stage passStage, Scene passScene, Group passGroup, int boxCount) {
		this.stage = passStage;
		this.scene = passScene;
		this.box = passGroup;
		
    	this.boxCount = boxCount;
    	
	}
	
	// Hard coded into Control Panel; can use to adjust size of box
	public void setBase (double b) {
		this.base = b;
	}
	
	// Used by the text editor in Control Panel to change the text of the box
	public void setAllText(String name, String attr, String methods){
		//this.className = name;
		//this.attributes = attr;
		//this.ops = methods;
		
		t1.setText(name);
		t2.setText(attr);
		t3.setText(methods);
		
	}
	
	public void drawClass() { 
    	// automatically calculates start points based on number of boxes already present
	// Draws empty class box with three sections in it
    	
    	startX = (1.5*width*(boxCount%4)) + 50;
    	startY = (boxCount/4)*(4*height) + 50;
    	
    	Rectangle rec1 = new Rectangle(startX, startY, width, height);
    	t1.setX(startX);
    	t1.setY(startY + 12);
    	t1.setVisible(true);
    	
    	Rectangle rec2 = new Rectangle(startX, startY + height, width, height);
    	t2.setX(startX);
    	t2.setY(startY + height + 12);
    	t2.setVisible(true);
    	
    	Rectangle rec3 = new Rectangle(startX, startY + (2*height), width, height);
    	t3.setX(startX);
    	t3.setY(startY + (2* height) + 12);
    	t3.setVisible(true);
 
    	rec1.setFill(Color.WHITE);
    	rec1.setStroke(Color.BLACK);
    	rec2.setFill(Color.WHITE);
    	rec2.setStroke(Color.BLACK);
    	rec3.setFill(Color.WHITE);
    	rec3.setStroke(Color.BLACK);
    	
    	box.getChildren().add(rec1);
    	box.getChildren().add(rec2);
    	box.getChildren().add(rec3);
    	
    	box.getChildren().add(t1);
    	box.getChildren().add(t2);
    	box.getChildren().add(t3);
  
        stage.setScene(scene);
        stage.show();
    }
	// Used by Control Panel when Draw Line is selected
	// Creates new instace of DrawLine and draws from this box to a random other existing box
	public void drawNewLine(ArrayList<DrawClassBox> al){
		int index = (int) (Math.random() * (al.size()-2));
		DrawLine dl = new DrawLine(stage, scene, box, this, al.get(index));
		dl.drawLine();
	}
}
