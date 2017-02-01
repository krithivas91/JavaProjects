package draw2;
import java.awt.Color; 
import java.awt.Graphics;
import draw1.TwoEndsShape; 
public class EraseAreaTool extends TwoEndsShape { 
	private static final long serialVersionUID = 1L; 
	public void draw(Graphics g) { 
		int x = Math.min(x1, x2);  
		int y = Math.min(y1, y2);  
		int w = Math.abs(x1 - x2) + 1;  
		int h = Math.abs(y1 - y2) + 1;      
		if (color != null) { 
			g.setColor(Color.WHITE); 
			} 
		g.drawRect(x, y, w, h); 
		g.fillRect(x, y, w, h); 
		} 
	public void drawOutline(Graphics g, int x1, int y1, int x2, int y2) {
		int x = Math.min(x1, x2);  
        int y = Math.min(y1, y2);  
        int w = Math.abs(x1 - x2) + 1;  
        int h = Math.abs(y1 - y2) + 1;      
        g.drawRect(x, y, w, h); 
        g.fillRect(x, y, w, h); 
          } 
	} 
