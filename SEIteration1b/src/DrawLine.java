import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DrawLine {

	Stage stage;
	Scene scene;
	Group box;
	
	DrawClassBox source;
	DrawClassBox dest;
	
	public DrawLine (Stage passStage, Scene passScene, Group passGroup, DrawClassBox src, DrawClassBox destination) {
		this.stage = passStage;
		this.scene = passScene;
		this.box = passGroup;
		
		this.source = src;
		this.dest = destination;
		
	}
	
public void drawLine() {
		
    	double midX = source.width/2;
    	double midY = source.height*1.5;
    	
		double startX = source.startX + midX;
		double startY = source.startY + midY;
		double endX = dest.startX + midX;
		double endY = dest.startY + midY;
		
		Line line = new Line();
		line.setStartX(startX);
		line.setStartY(startY);
		line.setEndX(endX);
		line.setEndY(endY);
		
        box.getChildren().add(line);
        
        stage.setScene(scene);
        stage.show();
    }
}
