package draw2;
import java.awt.*;
import scribble3.*;
public class EraserTool extends AbstractTool {  
	public EraserTool(ScribbleCanvas canvas, String name) { 
		super(canvas, name); 
		} 
	public void startShape(Point p) { 
		curStroke = new EraserStroke(Color.white);  
		curStroke.addPoint(p);  
		} 
  public void addPointToShape(Point p) { 
	  if (curStroke != null) {  
		  curStroke.addPoint(p);  
		  Graphics g = canvas.getGraphics(); 
		  g.setColor(canvas.getCurColor()); 
		  g.setColor(Color.white); 
		  g.fillOval(canvas.x, canvas.y, 20, 20); 
		  } 
	  } 
  public void endShape(Point p) { 
	  if (curStroke != null) {  
		  curStroke.addPoint(p);  
		  canvas.addShape(curStroke);  
		  curStroke = null;  
		  } 
	  } 
  protected EraserStroke curStroke = null;  
}
