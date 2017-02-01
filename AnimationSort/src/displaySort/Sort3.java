package displaySort;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
public class Sort3 extends Sort2 
{
	private static final long serialVersionUID = 1L;
	protected SortDisplay theDisplay;
	protected SortDisplayFactory displayFactory;
	protected void initAnimator()
	{
		String att = getParameter("dis");
		displayFactory = new StaticSortDisplayFactory();
		theDisplay = displayFactory.makeSortDisplay(att);
		super.initAnimator();		
	}
	protected void scramble ()
	{
		int n = theDisplay.getArraySize(getSize());
		arr = new int [n];
		for (int i = arr.length;--i>=0;)
		{
			arr[i] = i;
		}
		for (int i = arr.length; --i>=0;)
		{
			int j = (int)(i*Math.random());
			SortAlg.swap(arr, i, j);
		}
	}
	protected void paintFrame(Graphics g)
	{
		theDisplay.display(arr, g, getSize());
	}
}
