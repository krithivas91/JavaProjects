package draw2;
import java.awt.*;
import draw1.TwoEndsShape; 
public class PolygonShape extends TwoEndsShape { 
    private static final long serialVersionUID = 1L; 
    public void draw(Graphics g) { 
    	int x = Math.min(x1, x2); 
        int y = Math.min(y1, y2); 
        int w = Math.abs(x1 - x2) + 1; 
        int h = Math.abs(y1 - y2) + 1; 
        if (color != null) { 
            g.setColor(color); 
        } 
        Polygon pg = new Polygon(); 
        pg.addPoint(x, y + h / 2); 
        pg.addPoint(x + w / 2, y); 
        pg.addPoint(x + w, y + h / 2); 
        pg.addPoint(x + w / 2, y + h); 
        g.drawPolygon(pg); 
  
    } 
    public void drawOutline(Graphics g, int x1, int y1, int x2, int y2) { 
    	int x = Math.min(x1, x2); 
        int y = Math.min(y1, y2); 
        int w = Math.abs(x1 - x2) + 1; 
        int h = Math.abs(y1 - y2) + 1; 
        Polygon pg = new Polygon(); 
        pg.addPoint(x, y + h / 2); 
        pg.addPoint(x + w / 2, y); 
        pg.addPoint(x + w, y + h / 2); 
        pg.addPoint(x + w / 2, y + h); 
        g.drawPolygon(pg); 
    } 
}
