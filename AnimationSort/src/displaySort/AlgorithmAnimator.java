package displaySort;
public abstract class AlgorithmAnimator extends DBAnimationApplet
{
	private static final long serialVersionUID = 1L;
	abstract protected void algorithm();
	public void run()
	{
		algorithm();
	}
	final protected void pause()
	{
		if (Thread.currentThread()== AnimationThread)
		{
			try
			{
				Thread.sleep(delay);
			}
			catch (InterruptedException e)
			{				
			}
			repaint();
		}
	}
}

