import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DrawGraphical {
	
	double base = 1;
	String className = "";
	TextArea ta = new TextArea();
	
	Stage stage;
	Scene scene;
	Group box;
	
	public DrawGraphical (Stage passStage, Scene passScene, Group passGroup) {
		this.stage = passStage;
		this.scene = passScene;
		this.box = passGroup;
	}

	public void setBase (double b) {
		this.base = b;
	}
	
	public void setClassname (String name) {
		this.className = name;
		ta.setText(className);
		
		box.getChildren().add(ta);
	}
	
	public void drawLine(String placement) {
		
		Line line = new Line(); //(base*50.0, base*50.0, base*100.0, base*100.0);
		
		double width = base*200;
    	double height = base*100;
    	
    	double midTop = (700-(3*height))/2;
    	double midSide = (1000-width)/2;
    	
		if(placement.equals("top")){
			line.setStartX(1000/2);
			line.setStartY(midTop);
			line.setEndX(1000/2);
			line.setEndY(50);
		}
		else if(placement.equals("bottom")){
			line.setStartX(1000/2);
			line.setStartY(700-midTop);
			line.setEndX(1000/2);
			line.setEndY(700-50);
		}
		else if(placement.equals("left")){
			line.setStartX(midSide);
			line.setStartY(700/2);
			line.setEndX(100);
			line.setEndY(700/2);
		}
		else if(placement.equals("right")){
			line.setStartX(1000-midSide);
			line.setStartY(700/2);
			line.setEndX(1000-100);
			line.setEndY(700/2);
		}
		else {
			line.setStartX(50);
			line.setStartY(50);
			line.setEndX(100);
			line.setEndY(100);
		}
		
        box.getChildren().add(line);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public void drawClass() { 
    	// include way to adjust StartX and StartY, taking width and height into account
    
    	double width = base*200;
    	double height = base*100;
    	double startX = (1000 - width) / 2;
    	double startY = (700 - (3*height)) / 2;
    	
    	Rectangle rec1 = new Rectangle(startX, startY, width, height);
    	Rectangle rec2 = new Rectangle(startX, startY + height, width, height);
    	Rectangle rec3 = new Rectangle(startX, startY + (2*height), width, height);
 
    	rec1.setFill(Color.TRANSPARENT);
    	rec1.setStroke(Color.BLACK);
    	rec2.setFill(Color.TRANSPARENT);
    	rec2.setStroke(Color.BLACK);
    	rec3.setFill(Color.TRANSPARENT);
    	rec3.setStroke(Color.BLACK);
    	
    	box.getChildren().add(rec1);
    	box.getChildren().add(rec2);
    	box.getChildren().add(rec3);
  
        stage.setScene(scene);
        stage.show();
    }
}

