
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

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ClassBox {
    
    // Variables to track dimensions of box
	double base = 0.75;
	double width = base*200;
	double height = base*300;
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
    
    ArrayList<MyLine> outboundLines = new ArrayList<MyLine>(16);
    ArrayList<MyLine> inboundLines = new ArrayList<MyLine>(16);
        
	public ClassBox (int boxCount, double base) {
		
            this.boxCount = boxCount;
            this.name = "ClassBox" + boxCount;
            
            startX = 100;
            startY = 100;
            
            baseRec = new Rectangle(startX, startY, width, height);
            baseRec.setFill(Color.WHITE);
            baseRec.setStroke(Color.BLACK);
            
            sep1 = new Line(startX, startY+(1.0/3.0)*height, startX+width, startY+(1.0/3.0)*height);
            sep2 = new Line(startX, startY+(2.0/3.0)*height, startX+width, startY+(2.0/3.0)*height);
            
            t1.setX(startX);
            t1.setY(startY + 12);
            t1.setVisible(true);
            t2.setX(startX);
            t2.setY(startY + (1.0/3.0) * height + 12);
            t2.setVisible(true);
            t3.setX(startX);
            t3.setY(startY + (2.0/3.0) * height + 12);
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
	
	public void redraw(double x, double y){
		startX+=x;
		startY+=y;
		        
        //baseRec = new Rectangle(startX, startY, width, 3*height);
        baseRec.setX(startX);
        baseRec.setY(startY);
        
        //sep1 = new Line(startX, startY+height, startX+width, startY+height);
        //sep2 = new Line(startX, startY+(2*height), startX+width, startY+(2*height));
        
        sep1.setStartX(startX);
        sep1.setStartY(startY + (1.0/3.0) * height);
        sep1.setEndX(startX + width);
        sep1.setEndY(startY + (1.0/3.0) * height);
        
        sep2.setStartX(startX);
        sep2.setStartY(startY + (2.0/3.0) * height);
        sep2.setEndX(startX + width);
        sep2.setEndY(startY + (2.0/3.0) * height);
        
        t1.setX(startX);
        t1.setY(startY + 12);
        t1.setVisible(true);
        t2.setX(startX);
        t2.setY(startY + (1.0/3.0) * height + 12);
        t2.setVisible(true);
        t3.setX(startX);
        t3.setY(startY + ((2.0/3.0) * height) + 12);
        t3.setVisible(true);
        
        for (int i=0; i < inboundLines.size(); i++){
        	inboundLines.get(i).redrawEnd(x, y);
        }
        
        for (int i=0; i < outboundLines.size(); i++){
        	outboundLines.get(i).redrawStart(x, y);
        }
        
        
	}
	
	public double getStartX(){
		return startX;
	}
	
	public double getStartY(){
		return startY;
	}
	
	public double getHeight(){
		return height;
	}
	
	public double getWidth(){
		return width;
	}

}
