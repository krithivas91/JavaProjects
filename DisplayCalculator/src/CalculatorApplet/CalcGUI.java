package CalculatorApplet;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class CalcGUI extends JPanel
{
	private static final long serialVersionUID = 1L;
	JTextField entryFeild ;
	Vector clickedButtons = new Vector();
	Commands previousClick= Commands.NULL;
	public CalcGUI()
	{
    setLayout(new BorderLayout());
	    entryFeild = new JTextField();
	    add(entryFeild,BorderLayout.NORTH);
	    JPanel ButtonPanel = new JPanel();
	    ButtonPanel.setLayout(new GridLayout(4,4));
	    formButtons(ButtonPanel);
	    add(ButtonPanel,BorderLayout.CENTER);
	    JButton resetButton = new JButton("CLEAR");
	    resetButton.setBackground(Color.YELLOW);
	    resetButton.setFont (new Font("Monospaced",Font.BOLD, 16));
	    resetButton.addActionListener(new ButtonActListner(Commands.CLEAR));
	    add(resetButton,BorderLayout.SOUTH);
}
	void show (String str)
	{
		entryFeild.setText(str);
		entryFeild.repaint();
		
	} 
enum Commands
 	{
 	ADD,MULTIPLY,DIVIDE,SUBTRACT,CLEAR,EQUALTO,NULL,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,ZERO 
 	}
	private void formButtons (JPanel buttonPanel)
	{
		JButton seven = new JButton ("7");
		seven.addActionListener(new ButtonActListner(Commands.SEVEN));
		JButton eight = new JButton ("8");
		eight.addActionListener(new ButtonActListner(Commands.EIGHT));
	    JButton nine = new JButton ("9");
	    nine.addActionListener(new ButtonActListner(Commands.NINE));
	    JButton divide = new JButton ("/");
	    divide.addActionListener(new ButtonActListner(Commands.DIVIDE));
	    JButton four = new JButton ("4");
	    four.addActionListener(new ButtonActListner(Commands.FOUR));
	    JButton five = new JButton ("5");
	    five.addActionListener(new ButtonActListner(Commands.FIVE));
	    JButton six = new JButton ("6");
	    six.addActionListener(new ButtonActListner(Commands.SIX));
	    JButton multiply = new JButton ("*");
	    multiply.addActionListener(new ButtonActListner(Commands.MULTIPLY));
	    JButton one = new JButton ("1");
	    one.addActionListener(new ButtonActListner(Commands.ONE));
	    JButton two = new JButton ("2");
	    two.addActionListener(new ButtonActListner(Commands.TWO));
	    JButton three = new JButton ("3");
	    three.addActionListener(new ButtonActListner(Commands.THREE));
	    JButton minus = new JButton ("-");
	    minus.addActionListener(new ButtonActListner(Commands.SUBTRACT));
	    JButton zero = new JButton ("0");
	    zero.addActionListener(new ButtonActListner(Commands.ZERO));
	    JButton equalTo = new JButton ("=");
	    equalTo.addActionListener(new ButtonActListner(Commands.EQUALTO));	
	    JButton add = new JButton ("+");
	    add.addActionListener(new ButtonActListner(Commands.ADD));
	    buttonPanel.add(one);
	    buttonPanel.add(two);
	    buttonPanel.add(three);
	    buttonPanel.add(four);
	    buttonPanel.add(five);
	    buttonPanel.add(six);
	    buttonPanel.add(seven);
	    buttonPanel.add(eight);
	    buttonPanel.add(nine);
	    buttonPanel.add(multiply);
	    buttonPanel.add(minus);
	    buttonPanel.add(zero);
	    buttonPanel.add(equalTo);
	    buttonPanel.add(add);
	    buttonPanel.add(divide);
	    
	}
	void Calculate()
	{
		Iterator i = clickedButtons.iterator();
		Integer value = 0;
		Commands LastClick = Commands.NULL;
	    while (i.hasNext())
	    {
	    	String s = (String)i.next();
	    	if (s == "+")
	    		LastClick = Commands.ADD;
	    	else if (s == "-")
	    		LastClick = Commands.SUBTRACT;
	    	else if (s == "*")
	    		LastClick = Commands.MULTIPLY;
	    	else if (s == "/")
	    		LastClick = Commands.DIVIDE;
	    	else
	    	{
	    		if (LastClick == Commands.ADD)
	    		{
	    			value = value + Integer.parseInt(s);
	    			show(value.toString());
	    			
	    		}
	    		else if (LastClick == Commands.SUBTRACT)
	    		{
	    			value = value - Integer.parseInt(s);
	    			show(value.toString());
	    			
	    		}
	    		else if (LastClick == Commands.MULTIPLY)
	    		{
	    			value = value * Integer.parseInt (s);
	            	show(value.toString());
	            	
	    		}
	    		else if (LastClick == Commands.DIVIDE)
	    		{
	    			value = value / Integer.parseInt(s);
	    			show(value.toString());
	    			
	    		}
	    		else
	    			value = Integer.parseInt(s);
	    		}
	    	}
	    }
	protected class ButtonActListner implements ActionListener
	{
		Commands buttonselect;
		public ButtonActListner (Commands buttonselect)
		{
			this.buttonselect = buttonselect;
			
		}
		private void clearAll ()
		{
			clickedButtons.removeAllElements();
			previousClick = Commands.NULL;
			
		}
		String toString (Commands buttonselect)
		{
			switch (buttonselect)
			{
			case ONE:
				return "1";
			case TWO:
				return "2";
	        case THREE:
	        	return "3";
	        case FOUR:
	        	return "4";
	        case FIVE:
	        	return "5";
	        case SIX:
	        	return "6";
	        case SEVEN:
	        	return "7";
	        case EIGHT:
	        	return "8";
	        case NINE:
	        	return "9";
	        case ADD:
	        	return "+";
	        case MULTIPLY:
	        	return "*";
	        case DIVIDE:
	        	return "/";
	        case SUBTRACT:
	        	return "-";
	        case ZERO:  
	        	return "0";
	        default:
	        	return " ";
	        }	       
	      }
		void manageSequence (String recent, Commands buttonselect)
		{
			if (previousClick == Commands.NULL)
			{
				if (numbersGroup(buttonselect))
					show(recent);
				clickedButtons.add(recent);
	        }
			else if (numbersGroup(previousClick) && numbersGroup(buttonselect))
			{
				String lastElement = (String)clickedButtons.lastElement();
				clickedButtons.remove(clickedButtons.lastElement());
				lastElement = lastElement + recent;
				if (lastElement.charAt(0)== '0')
					lastElement=recent;
				clickedButtons.add(lastElement);
				show (lastElement);
				
			}
	        else if (operatorsGroup (previousClick) && operatorsGroup (buttonselect))
	        {
	        	String lastElement = (String)clickedButtons.lastElement();
	        	clickedButtons.remove(clickedButtons.lastElement());
	        	lastElement = recent;
	        	clickedButtons.add(lastElement);
	        }
	        else if (numbersGroup(buttonselect))
	        {
	        	show(recent);      
	        	clickedButtons.add(recent);
	        }
	        else
	        {
	        	Calculate();
	        	clickedButtons.add(recent);
	        }
			previousClick = buttonselect;
			
		}
		private Boolean operatorsGroup (Commands buttonselect)
		{
			switch (buttonselect)
			{
			case ADD:
			case MULTIPLY:
			case SUBTRACT:
			case DIVIDE:
				return true;
		    default:
		    	return false;
		    	}
			
		}
		private Boolean numbersGroup(Commands buttonselect)
		{
			switch (buttonselect)
			{
			case ONE:
	    	case TWO:
	    	case THREE:
	    	case FOUR:
	        case FIVE:
	        case SIX:
	        case SEVEN:
	        case EIGHT:
	        case NINE:
	        case ZERO:
	          return true;
	        default:
	          return false;
	        }  
	      }
		public void actionPerformed(ActionEvent e)
		{
			if (buttonselect == Commands.CLEAR)
			{
				show ("0");
				clearAll();
	        }
			else if (buttonselect == Commands.EQUALTO)
			{
				Calculate();
				clearAll();
	        }
			else
				manageSequence(toString(buttonselect),buttonselect);
			}
		}
	}
