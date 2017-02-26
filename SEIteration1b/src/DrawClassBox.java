import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Scene;
//import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DrawClassBox {
	double base = 1;
	double width = base*200;
	double height = base*100;
	double startX;
	double startY;
	int boxCount;
	
	String className;
	String attributes;
	String ops;
	
	Text t1 = new Text("");
	Text t2 = new Text("");
	Text t3 = new Text("");
	
	Stage stage;
	Scene scene;
	Group box;
	
	public DrawClassBox (Stage passStage, Scene passScene, Group passGroup, int boxCount) {
		this.stage = passStage;
		this.scene = passScene;
		this.box = passGroup;
		
    	this.boxCount = boxCount;
    	
	}
	
	public void setBase (double b) {
		this.base = b;
	}
	
	public void setAllText(String name, String attr, String methods){
		//this.className = name;
		//this.attributes = attr;
		//this.ops = methods;
		
		t1.setText(name);
		t2.setText(attr);
		t3.setText(methods);
		
	}
	
	public void drawClass() { 
    	// include way to adjust StartX and StartY, taking width and height into account
    	
    	startX = (1.5*width*(boxCount%4)) + 50;
    	startY = (boxCount/4)*(4*height) + 50;
    	
    	Rectangle rec1 = new Rectangle(startX, startY, width, height);
    	//Text t1 = new Text(className);
    	t1.setX(startX);
    	t1.setY(startY + 12);
    	t1.setVisible(true);
    	
    	Rectangle rec2 = new Rectangle(startX, startY + height, width, height);
    	//Text t2 = new Text();
    	t2.setX(startX);
    	t2.setY(startY + height + 12);
    	//t2.setText(attributes);
    	t2.setVisible(true);
    	
    	Rectangle rec3 = new Rectangle(startX, startY + (2*height), width, height);
    	//Text t3 = new Text();
    	t3.setX(startX);
    	t3.setY(startY + (2* height) + 12);
    	//t3.setText(ops);
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
	
	public void drawNewLine(ArrayList<DrawClassBox> al){
		int index = (int) (Math.random() * (al.size()-2));
		DrawLine dl = new DrawLine(stage, scene, box, this, al.get(index));
		dl.drawLine();
	}
}
