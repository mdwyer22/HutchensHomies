
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 *
 * @author Matt Hahn, Matt Rumpf, Jess Butts, Mike Dwyer, Jamie Thorpe
 *
 */

public class TextEditor {

	Stage textEditor = new Stage();
	GridPane grid = new GridPane();
	Scene textScene = new Scene(grid, 300, 275);
	
	ClassBox dc;
	
	
	/**
 	*
 	* Creates a window that can be used to edit the text of a classBox
	*
	* @param dc is the classBox whose text is to be edited
	*
 	**/

	public TextEditor(ClassBox box) {

		this.dc = box;
		
	}
	
	public void createEditor() {
		
		textEditor.setTitle("Text Editor");
		grid.setAlignment(Pos.CENTER);
		textEditor.setScene(textScene);

		Label name = new Label("Class Name:");
		grid.add(name, 0, 0);

		TextField nameField = new TextField(dc.t1.getText());
		grid.add(nameField, 1, 0);

		Label att = new Label("Attributes:");
		grid.add(att, 0, 1);

		TextField attField = new TextField(dc.t2.getText());
		grid.add(attField, 1, 1);

		Label op = new Label("Operations:");
		grid.add(op, 0, 2);

		TextField opField = new TextField(dc.t3.getText());
		grid.add(opField, 1, 2);

		Button submit = new Button("Submit");
		grid.add(submit, 1, 4);

		submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				resetText(nameField.getText(), attField.getText(), opField.getText());
			}
		});

		textEditor.show();
	}

	/**
 	*
 	* closes the textEditor window
	*
 	**/
	
	public void closeWindow() {
		textEditor.close();
	}
	
	public void resetText(String nameField, String attField, String opField){
		dc.setAllText(nameField, attField, opField);
	}

}