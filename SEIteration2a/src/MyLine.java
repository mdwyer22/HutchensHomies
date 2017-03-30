
import javafx.scene.shape.Line;

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

public class MyLine {
    
    ClassBox source;
    ClassBox dest;
    
    double startX;
    double startY;
    double endX;
    double endY;
    
    Line line = new Line();
    
    public MyLine (double startX, double startY, double endX, double endY) {
		this.startX=startX;
		this.startY=startY;
		this.endX=endX;
		this.endY=endY;
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
       
	}
    
    public void redrawStart(double x, double y){
    	startX+=x;
    	startY+=y;
    	line.setStartX(startX);
    	line.setStartY(startY);
    }
    
    public void redrawEnd(double x, double y){
    	endX+=x;
    	endY+=y;
    	line.setEndX(endX);
    	line.setEndY(endY);
    }
}
