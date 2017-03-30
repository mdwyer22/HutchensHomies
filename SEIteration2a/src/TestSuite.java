import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import javafx.application.Platform;

import java.util.ArrayList;

public class TestSuite {
	
	@BeforeClass
	// credit for setUpClass() to Michael Ellis 
	// http://stackoverflow.com/questions/11385604/how-do-you-unit-test-a-javafx-controller-with-junit
	public static void setUpClass() throws InterruptedException {
	    // Initialise Java FX

	    System.out.printf("About to launch FX App\n");
	    Thread t = new Thread("JavaFX Init Thread") {
	        public void run() {
	            Application.launch(ControlPanel.class, new String[0]);
	        }
	    };
	    t.setDaemon(true);
	    t.start();
	    System.out.printf("FX App thread started\n");
	    Thread.sleep(500);
	}

	@Test
	public void checkTextInNewBox() {
		System.out.println("Test the default values in the three textbox sections of a new ClassBox");
		ClassBox newbox1 = new ClassBox(0, 1.0);
		ArrayList<String> myText1 = newbox1.getText();
		
		assertEquals("Default text in textbox 1 is 'a'", "a", myText1.get(0));
		assertEquals("Default text in textbox 2 is 'b'", "b", myText1.get(1));
		assertEquals("Default text in textbox 3 is 'c'", "c", myText1.get(2));	
	}
	
	@Test
	public void textEditorChangingBoxText() {
		System.out.println("Test whether the text editor successfully changes the text in the ClassBox");
		ClassBox newbox2 = new ClassBox(0, 1.0);
		
		Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	        	TextEditor edit2 = new TextEditor(newbox2);
	    		newbox2.setEditor(edit2);
	    		ArrayList<String> origText2 = newbox2.getText();
	    		
	    		assertEquals("Default text in textbox 1 is 'a'", "a", origText2.get(0));
	    		assertEquals("Default text in textbox 2 is 'b'", "b", origText2.get(1));
	    		assertEquals("Default text in textbox 3 is 'c'", "c", origText2.get(2));	
	    		
	    		edit2.resetText("New name", "New att", "New ops");
	    		ArrayList<String> newText2 = newbox2.getText();
	    		
	    		assertEquals("Edited text in textbox 1 is 'New name'", "New name", newText2.get(0));
	    		assertEquals("Edited text in textbox 2 is 'New att'", "New att", newText2.get(1));
	    		assertEquals("Edited text in textbox 3 is 'New ops'", "New ops", newText2.get(2));
	        }
	   });
		
			
	}
	
	@Test
	public void submitEmptyTextInEditor() {
		System.out.println("Test whether the text editor can change the textboxes to empty in a ClassBox");
		ClassBox newbox3 = new ClassBox(0, 1.0);
		
		Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	        	TextEditor edit3 = new TextEditor(newbox3);
	    		newbox3.setEditor(edit3);
	    		ArrayList<String> origText3 = newbox3.getText();
	    		
	    		assertEquals("Default text in textbox 1 is 'a'", "a", origText3.get(0));
	    		assertEquals("Default text in textbox 2 is 'b'", "b", origText3.get(1));
	    		assertEquals("Default text in textbox 3 is 'c'", "c", origText3.get(2));	
	    		
	    		edit3.resetText("", "", "");
	    		ArrayList<String> newText3 = newbox3.getText();
	    		
	    		assertEquals("Textbox 1 is now empty", "", newText3.get(0));
	    		assertEquals("Textbox 2 is now empty", "", newText3.get(1));
	    		assertEquals("Textbox 3 is now empty", "", newText3.get(2));
	        }
	   });
		
	}
}
