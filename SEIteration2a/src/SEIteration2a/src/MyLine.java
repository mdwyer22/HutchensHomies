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
    
    Line line = new Line();
    
    public MyLine (ClassBox src, ClassBox destination) {
		
		this.source = src;
		this.dest = destination;	
		
		double midX = source.width/2;
        double midY = source.height*1.5;
    	
        double startX = source.startX + midX;
        double startY = source.startY + midY;
        double endX = dest.startX + midX;
        double endY = dest.startY + midY;
		
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
       
	}
}
