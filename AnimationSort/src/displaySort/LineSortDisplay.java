package displaySort;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
public class LineSortDisplay implements SortDisplay
{
	@Override
	public int getArraySize(Dimension d) {
		return d.width/3;
	}
	@Override
	public void display(int[] a, Graphics g, Dimension d) {
		g.setColor(Color.white);
		g.fillRect(0, 0, d.width, d.height);
		double f = d.height/(double) a.length;
		int x = d.width-3;
		for(int i = a.length; --i>=0; x-=3)
		{
			g.setColor(Color.black);
			g.drawLine(x, d.height-(int)(a[i]*f), x+3, d.height - (int)(a[i]*f));
		}
	}
}
