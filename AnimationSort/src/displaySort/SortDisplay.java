package displaySort;
import java.awt.Dimension;
import java.awt.Graphics;
public interface SortDisplay {
	public int getArraySize(Dimension d);
	public void display(int a[],Graphics g, Dimension d);
}
