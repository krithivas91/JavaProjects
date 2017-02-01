package CalculatorApplet;
import javax.swing.JApplet;
public class CalculatorApplet extends JApplet 
{
	  public void init() {  
		    CalcGUI panel = new CalcGUI();
		    setContentPane (panel);
		     }
}
