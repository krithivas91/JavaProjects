package draw2;
import java.util.*;
import scribble3.Shape;
import java.awt.Point; 
import java.awt.Color; 
import java.awt.Graphics; 
public class EraserStroke extends Shape {  
    private static final long serialVersionUID = 1L; 
    public EraserStroke() {}  
    public EraserStroke(Color color) { 
    	super(color);  
  }  
  public void addPoint(Point p) { 
	  if (p != null) {  
		  points.add(p);  
    } 
  } 
  public List getPoints() {  
	  return points;  
  } 
  public void draw(Graphics g) { 
	  if (color != null) { 
		  g.setColor(color); 
    } 
	  Point prev = null;  
	  Iterator iter = points.iterator();  
	  while (iter.hasNext()) {  
		  Point cur = (Point) iter.next();  
		  if (prev != null) { 
			  g.fillOval(cur.x, cur.y, 20, 20); 
			  } 
		  prev = cur;  
		  } 
	  } 
  protected List points = new ArrayList();   
  }
