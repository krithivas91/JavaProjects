package draw;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class drawShape extends JPanel implements Shapes
{
	private static final long serialVersionUID = 1L;
	public void paint(Graphics g)
	{
		for (int i = 0 ; i < mainDraw.shape.size(); i ++)
		{
		Shapes str = mainDraw.shape.get(i);
		if(str.getClass().getName().contains("Lines"))
		{
			Lines lin= (Lines) mainDraw.shape.get(i);
			int x1= lin.getX1();
			int y1= lin.getY1();
			int x2= lin.getX2();
			int y2= lin.getY2();
			g.setColor(Color.red);
			g.drawLine(x1, y1, x2, y2);
			g.drawString("Line Segment from point ("+x1+","+y1+") to point ("+x2+","+y2+") is drawn", 700, 100 );
		}
		if(str.getClass().getName().contains("Rectangle"))
		{
			Rectangle rect = (Rectangle) mainDraw.shape.get(i);
			int width = rect.getWidth();
			int height = rect.getHeight();
			g.setColor(Color.BLUE);
			g.fillRect(450, 100, width, height);
			g.drawString("Rectangle with width "+width+" and height "+height+" is drawn",700,130);
		}
		
	   if(str.getClass().getName().contains("Oval"))
	   {
		   Oval ov = (Oval) mainDraw.shape.get(i);
		   int width = ov.getWidth();
		   int height = ov.getHeight();
		   g.setColor(Color.magenta);
		   g.fillOval(100, 450, width, height);
		   g.drawString("Oval with width "+width+" and height "+height+" is drawn",700,160);
		   
	   }
	   
	   if(str.getClass().getName().contains("Circle"))
	   {
		   Circle c = (Circle) mainDraw.shape.get(i);
		   int radius = c.getRadius();
		   g.setColor(Color.BLACK);
		   g.fillOval(400, 450, radius, radius);
		   g.drawString("Circle with radius "+radius+" is drawn",700,190);
		   
	   }
	   
		}
		
	}
	
}
