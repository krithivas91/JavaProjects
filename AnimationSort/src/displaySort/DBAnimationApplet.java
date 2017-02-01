package displaySort;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
public abstract class DBAnimationApplet extends AnimationApplet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected boolean doublebuffered;
	protected Dimension d;
	protected Graphics offscreen;
	protected Image img;
	protected DBAnimationApplet()
	{
		this.doublebuffered=true;
		
	}
	protected DBAnimationApplet(boolean doublebuffered)
	{
		this.doublebuffered = doublebuffered;
	}
	final public void update (Graphics g)
	{
		if (doublebuffered)
		{
			paintFrame(offscreen);
			g.drawImage(img, 0, 0, this);
		}
		else
		{
			super.update(g);
		}
	}
	final public void paint (Graphics g)
	{
		paintFrame(g);
	}
	public void init()
	{
		d = getSize();
		img = createImage(d.width,d.height);
		offscreen = img.getGraphics();
		initAnimator();
	}
	protected void initAnimator()
	{
	}
	abstract protected void paintFrame(Graphics g);
}
