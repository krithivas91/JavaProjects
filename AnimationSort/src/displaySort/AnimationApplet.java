package displaySort;
import java.applet.Applet;
public class AnimationApplet extends Applet implements Runnable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Thread AnimationThread;
	protected int delay = 100;
	public void start()
	{
	AnimationThread = new Thread(this);
	AnimationThread.start();
		
	}
	public void stop()
	{
	AnimationThread = null;	
	}
	public void run()
	{
		while (Thread.currentThread()== AnimationThread)
		{
			try
			{
				Thread.currentThread().sleep(delay);
			}
			catch(InterruptedException e)
			{
			repaint();
			}
		}
	}
	public void setDelay(int delay)
	{
		this.delay=delay;
	}
	public int getDelay()
	{
		return delay;
	}
}
