
//http://stackoverflow.com/questions/28566860/javafx-how-to-group-shapes-for-dragging
//package hutchenshomies;

/**
*
* @author Matt Rumpf, Matt Hahn, Jessica Butts, Mike Dwyer, Jamie Thorpe
*
**/

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawGraphical {

	Stage stage = new Stage();
	Group box = new Group();
	Scene scene = new Scene(box, 1250, 800);

	Text togglebox;
	ArrayList<ClassBox> list = new ArrayList<ClassBox>(4);

	private boolean toDrawLine = false;
	
	private ClassBox source;
	private ClassBox destination;
	
	private ClassBox current;

	double mouseX;
	double mouseY;
	
	/**
	*
	* Creates a graphical window for the UML elements to be drawn in
	*
	* @param togglebox is the text that is to be next to the draw line button by default
	*
	**/

	public DrawGraphical(Text togglebox) {

		this.togglebox = togglebox;

		stage.setTitle("Graphical View");
		stage.setScene(scene);
		stage.show();
	}

	/**
	*
	* Creates a class box object and the visual objects it contains, sets up event filters to handle desired functionality
	* for class box objects
	*
	**/
	
	public void drawClassBox() {
		// automatically calculates start points based on number of boxes
		// already present
		// Draws empty class box with three sections in it
		ClassBox newbox = new ClassBox(list.size(), 0.75);

		box.getChildren().add(newbox.baseRec);
		box.getChildren().add(newbox.sep1);
		box.getChildren().add(newbox.sep2);

		box.getChildren().add(newbox.t1);
		box.getChildren().add(newbox.t2);
		box.getChildren().add(newbox.t3);

		TextEditor te = new TextEditor(newbox);
		newbox.setEditor(te);
		te.createEditor();

		list.add(newbox);
		newbox.setGraphical(this);

		newbox.baseRec.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2) {
					// Create a new text editor
					te.closeWindow();
					TextEditor teNew = new TextEditor(newbox);
					newbox.setEditor(teNew);
					te.createEditor();
				} else {
					//System.out.println("mouse click detected! " + newbox.name);
				}
			}
		});

		newbox.baseRec.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (current == null) {
					current = newbox;
					//System.out.println("source set");
					mouseX = mouseEvent.getSceneX();
					mouseY = mouseEvent.getSceneY();
				}
			}
		});

		newbox.baseRec.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (current != null) {
					current = null;
					//System.out.println("source reset to null");
				}
			}
		});

		newbox.baseRec.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				newbox.redraw(mouseEvent.getSceneX() - mouseX, mouseEvent.getSceneY() - mouseY);
				mouseX = mouseEvent.getSceneX();
				mouseY = mouseEvent.getSceneY();
			}
		});

	}

	/**
	*
	* Toggles the graphical window to handle events differently since the user has indicated a line is to be 
	* Toggles the showing of anchor points for the drawing of lines
	*
	**/
	
	public void toggleLineDraw() {
		if (list.size() >= 2) {
			if (!toDrawLine) {
				toDrawLine = true;
				togglebox.setText("Drawing");
				//System.out.println("Toggle true");
				for (int i=0; i<list.size();i++){
					//list.get(i).showAnchors();
					for (int j=0; j<16; j++){
						box.getChildren().add(list.get(i).anchorPoints.get(j));
					}
				}
			} else {
				toDrawLine = false;
				source = null;
				togglebox.setText("Ready");
				for (int i=0; i<list.size();i++){
					for (int j=0; j<16; j++){
						box.getChildren().remove(list.get(i).anchorPoints.get(j));
					}
				}
				//System.out.println("Toggle false");
			}

		}
	}

	/**
	*
	* Draws a line from the specified source anchor point to the specified destination anchor point
	*
	**/
	
	public void drawNewLine() {
		if (list.size() < 2) {
			return;
		}

		MyLine newline = new MyLine(source.toSend.getX() + (source.toSend.getWidth()/2), 
				source.toSend.getY() + (source.toSend.getHeight()/2), 
				destination.toSend.getX() + (destination.toSend.getWidth()/2), 
				destination.toSend.getY() + (destination.toSend.getHeight()/2));
		source.outboundLines.add(newline);
		destination.inboundLines.add(newline);

		box.getChildren().add(newline.line);
		
		source.toSend = null;
		destination.toSend = null;
		source = null;
		destination = null;

	}
	
	/**
	*
	* returns the source classbox 
	*
	* @return a classbox that is specified to be the source of a line
	*
	**/
	
	public ClassBox getSource(){
		return source;
	}
	
	/**
	*
	* Sets the source classBox for a line that is to be drawn
	*
	* @param src is the classBox that is to be the source of the line
	*
	**/
	
	public void setSource(ClassBox src){
		this.source = src;
	}

	/**
	*
	* Sets the destination classBox for a line that is to be drawn
	*
	* @param dest is the classBox that is to be the destination of the line
	*
	**/
	
	public void setDest(ClassBox dest){
		this.destination = dest;
	}

}
