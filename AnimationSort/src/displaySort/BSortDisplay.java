package displaySort;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
public class BSortDisplay implements SortDisplay
{
	@Override
	public int getArraySize(Dimension d) {
		return d.width/2;
	}
	@Override
	public void display(int[] a, Graphics g, Dimension d) {
		g.setColor(Color.white);
		g.fillRect(0, 0, d.width, d.height);
		double f = d.height / (double) a.length;
		int x = d.width - 1;
		g.setColor(Color.black);
		for(int i = a.length; --i >= 0; x-=2)
			g.drawLine(x, d.height, x, d.height - (int)(a[i]*f));	
	}
}
