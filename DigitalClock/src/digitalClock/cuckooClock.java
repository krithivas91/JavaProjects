package digitalClock;
import java.awt.Toolkit;
public class cuckooClock 
{
	public void cuckooTime(int c)
	{
		if(c == 0 || c == 15 || c == 30 || c == 45 ) // Every quarter Hour 
		{
			Toolkit.getDefaultToolkit().beep();//chime 
		}
	}
	
}
