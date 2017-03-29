
import javafx.scene.shape.Line;

/**
*
* @author Matt Rumpf, Jamie Thorpe, Mike Dwyer, Jessica Butts, Matt Hahn
*/

public class MyLine {
    
    ClassBox source;
    ClassBox dest;
    
    double startX;
    double startY;
    double endX;
    double endY;
    
    Line line = new Line();
	
	/**
	* Create an instance of the MyLine object
	* 
	* @param startX is the x coordinate of the starting point of the line
	* @param startY is the y coordinate of the starting point of the line
	* @param endX is the x coordinate of the final point of the line
	* @param endY is the y coordinate of the final point of the line
	*
    	**/
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
    
	/**
	*
	* Changes the x and y coordinates of the starting point of the line
	*
	* @param x is the desired change in x to be applied
	* @param y is the desired change in y to be applied
	*
	**/
	
    public void redrawStart(double x, double y){
    	startX+=x;
    	startY+=y;
    	line.setStartX(startX);
    	line.setStartY(startY);
    }
	/**
	*
	* Changes the x and y coordinates of the ending point of the line
	*
	* @param x is the desired change in x to be applied
	* @param y is the desired change in y to be applied
	*
	**/
	
    public void redrawEnd(double x, double y){
    	endX+=x;
    	endY+=y;
    	line.setEndX(endX);
    	line.setEndY(endY);
    }
}
