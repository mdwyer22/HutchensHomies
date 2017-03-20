
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hutchenshomies;

/**
 *
 * @author mmhahn1
 */

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ClassBox {
    
    // Variables to track dimensions of box
	double base = 0.75;
	double width = base*200;
	double height = base*100;
	double startX;
	double startY;
	
	int boxCount;
	String name;
	
	TextEditor te;
	
	// Initialize empty text
	Text t1 = new Text("a");
	Text t2 = new Text("b");
	Text t3 = new Text("c");
        
    Rectangle baseRec;
    Line sep1;
    Line sep2;
        
	public ClassBox (int boxCount, double base) {
		
            this.boxCount = boxCount;
            this.name = "ClassBox" + boxCount;
            
            startX = (1.5*width*(boxCount%4)) + 50;
            startY = (boxCount/4)*(4*height) + 50;
            
            baseRec = new Rectangle(startX, startY, width, 3*height);
            baseRec.setFill(Color.WHITE);
            baseRec.setStroke(Color.BLACK);
            
            sep1 = new Line(startX, startY+height, startX+width, startY+height);
            sep2 = new Line(startX, startY+(2*height), startX+width, startY+(2*height));
            
            t1.setX(startX);
            t1.setY(startY + 12);
            t1.setVisible(true);
            t2.setX(startX);
            t2.setY(startY + height + 12);
            t2.setVisible(true);
            t3.setX(startX);
            t3.setY(startY + (2* height) + 12);
            t3.setVisible(true);
        }
        
        // Hard coded into DrawGraphical; can use to adjust size of box
	public void setBase (double b) {
		this.base = b;
	}
	
	public void setEditor(TextEditor te) {
		this.te = te;
	}
        
        // Used by the text editor in Control Panel to change the text of the box
	public void setAllText(String name, String attr, String methods){
		
		t1.setText(name);
		t2.setText(attr);
		t3.setText(methods);
		
	}
}
