package displaySort;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
public class BarSortDisplay implements SortDisplay
{
	@Override
	public int getArraySize(Dimension d) {
		return d.width/3;
	}
	@Override
	public void display(int[] a, Graphics g, Dimension d) 
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, d.width, d.height);
		double f = d.height / (double) a.length;
		double cf = 255.0 / (double) a.length;
		int x = d.width -3;
		for (int i = a.length ; --i >= 0 ; x-=3)
		{
			g.setColor(new Color((int) (a[i]*cf/1.5) ,(int)(a[i]*cf) ,0));
			g.fillRect(x, d.height- (int) (a[i]*f), 3, (int)(a[i]*f));
		}	
	}
}
