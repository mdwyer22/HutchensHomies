
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hutchenshomies;

/**
 *
 * @author Matt Hahn, Matt Rumpf, Jess Butts, Mike Dwyer, Jamie Thorpe
 */

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ClassBox {
   
	double base = 0.75;
	double width = base*200;
	double height = base*300;
	double startX;
	double startY;
	
	Rectangle clicked = null;
	
	int boxCount;
	String name;
	
	TextEditor te;
	DrawGraphical dg;
	
	Rectangle baseRec;
    	Line sep1;
    	Line sep2;
	Text t1 = new Text("a");
	Text t2 = new Text("b");
	Text t3 = new Text("c");
    
	Rectangle toSend;
    	ArrayList<Rectangle> anchorPoints = new ArrayList<Rectangle>(16);
    	ArrayList<MyLine> outboundLines = new ArrayList<MyLine>(8);
    	ArrayList<MyLine> inboundLines = new ArrayList<MyLine>(8);
    
    
	/**
   	 * Initializes a class box at point (100, 100), with name of the nth box created being "ClassBox n".
	 * Class box made up of one large rectangle, two lines used as dividers to separate sections, three
	 * Text objects, and 16 anchor points around the box.
	 *
	 * @param boxCount passes the length of the list of existing class boxes, used in naming the classBox
	 * @param base passes a constant that can be used to resize the boxes; currently not being used
   	 */
	public ClassBox (int boxCount, double base) {
		
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
            
            for (double i=0; i < 4.0; i++){
    			anchorPoints.add(new Rectangle(startX+(i/4.0)*width-5, startY-5, 10, 10));
    		}
    		for (double i=0; i < 4.0; i++){
    			anchorPoints.add(new Rectangle(startX+width-5, startY+(i/4.0)*height-5, 10, 10));
    		}
    		for (double i=0; i < 4.0; i++){
    			anchorPoints.add(new Rectangle(startX+width-(i/4.0)*width-5, startY+height-5, 10, 10));
    		}
    		for (double i=0; i < 4.0; i++){
    			anchorPoints.add(new Rectangle(startX+-5, startY+height-(i/4.0)*height-5, 10, 10));
    		}
    		
    		for (int i=0; i<anchorPoints.size();i++){
    			createEvent(anchorPoints.get(i));
    		}
    		
        }
        
        /**
	* Set the base value that affects the size of the class box; currently not being used
	*
	* @param b passes the constant value to set base
	*/
	public void setBase (double b) {
		this.base = b;
	}
	
	/**
	* Sets the text editor associated with this classBox that can edit the Text objects
	*
	* @param te passes TextEditor object
	*/
	public void setEditor(TextEditor te) {
		this.te = te;
	}
        
        /**
	* Used by text editor to reset the text of the Text objects in the classBox
	*
	* @param name passes the text for the first Text object
	* @param attr passes the text for the second Text object
	* @param methods passes the text for the third class box
	*/
	public void setAllText(String name, String attr, String methods){
		
		t1.setText(name);
		t2.setText(attr);
		t3.setText(methods);
		
	}
	
	/**
	* Used by DrawGraphical to redraw the classBox when a Drag Event occurs
	*
	* @param x passes the change in the x coordinate between drag events
	* @param y passes the change in the y coordinate between drag events
	*/
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
        
        	for (int i=0; i <4.0; i++){
        		anchorPoints.get(i).setX(startX+(i/4.0)*width-5);
        		anchorPoints.get(i).setY(startY-5);
        	}
        
        	for (int i=0; i <4.0; i++){
        		anchorPoints.get(i+4).setX(startX+width-5);
        		anchorPoints.get(i+4).setY(startY+(i/4.0)*height-5);
        	}
        
        	for (int i=0; i <4.0; i++){
        		anchorPoints.get(i+8).setX(startX+width-(i/4.0)*width-5);
        		anchorPoints.get(i+8).setY(startY+height-5);
        	}
        
        	for (int i=0; i <4.0; i++){
        		anchorPoints.get(i+12).setX(startX+-5);
        		anchorPoints.get(i+12).setY(startY+height-(i/4.0)*height-5);
        	}
        
	}
	
	/**
	* @return x coordinate of top left corner of classBox
	*/
	public double getStartX(){
		return startX;
	}
	
	/**
	* @return y coordinate of top left corner of classBox
	*/
	public double getStartY(){
		return startY;
	}
	
	/**
	* @return height of classBox
	*/
	public double getHeight(){
		return height;
	}
	
	/**
	* @return width of classBox
	*/
	public double getWidth(){
		return width;
	}
	
	/**
	* Set the drawGraphical object that created the classBox.
	* Used to alert drawGraphical to clicks on anchor points when drawing lines.
	*
	* @param dg passes the drawGraphical object to be set
	*/
	public void setGraphical(DrawGraphical dg){
		this.dg = dg;
	}
	
	/**
	* Used when selecting achor points between which to draw lines. toSend records which anchor point on 
	* 	the classBox was clicked. Event then calls method to set the source or destination classBox 
	*	for the line.  
	*
	* @param me is a rectangular anchor point on which to detect mouse clicks
	*/
	public void createEvent(Rectangle me){
		me.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent mouseEvent){
				if (dg.getSource() == null){
					toSend = me;
					setSrc();
					//System.out.println("Setting source");
				}
				else{
					toSend = me;
					setDest();
					//System.out.println("Setting dest");
				}
			}
		});
	}
	
	/**
	* Set this classBox as the source classBox in drawGraphical
	*/
	public void setSrc(){
		dg.setSource(this);
	}
	
	/**
	* Set this classBox as the destination classBox in drawGraphical. Since the line being drawn now has
	*	a destination, also call the drawNewLine method in drawGraphical, and toggle the Draw Line 
	*	button in the control panel.
	*/
	public void setDest(){
		dg.setDest(this);
		dg.drawNewLine();
		dg.toggleLineDraw();
	}

}
