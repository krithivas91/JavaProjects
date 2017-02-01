package digitalClock;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class digitalClock extends Applet implements Runnable
{
	
	private static final long serialVersionUID = 1L;
	Thread t = null;
	Font font = new Font("Monospaced", Font.ROMAN_BASELINE, 24 );
	Color color = Color.ORANGE;
	int hours=0, minutes =0, seconds=0;
	int alarmHr=0,alarmMin=0;
	String alarmTime ="";

	public digitalClock() //creating Alarm functionality
	{
		JFrame frame =new JFrame("Alarm");
		JPanel panel = new JPanel();
		JButton button=new JButton("Set Alarm");
		JLabel label1= new JLabel("Hour:");
		JLabel label2 = new JLabel("Minute:");
		JTextField text1 = new JTextField("12hr",4);
		JTextField text2 = new JTextField(4);
		JTextField text3 = new JTextField("AM/PM",4);
		setVisible(true);
		setSize(200,200);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(text3);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
				 alarmHr= Integer.parseInt(text1.getText());
				 alarmMin= Integer.parseInt(text2.getText());
				 alarmTime=text3.getText();
				 
				}
				catch (Exception ex)	//Exception handling for invalid inputs
				{
					JFrame Err= new JFrame();
					JOptionPane.showMessageDialog(Err,"Please enter valid inputs","Wrong Inputs",JOptionPane.ERROR_MESSAGE);
					
				}
				
				if (alarmHr>12||alarmMin>59)
				{
					JFrame Err2= new JFrame();
					JOptionPane.showMessageDialog(Err2,"Please enter the alarm time in 12HR format\n Please maintain the correct format ","Invalid Input",JOptionPane.ERROR_MESSAGE);
					
				}
				}
			});
		add(panel);
		frame.setVisible(true);
		frame.add(panel);
		}
	
	public void start() 
	{
		if ( t== null)
		{
		t = new Thread(this);//creating new thread
		t.start();
		}
		
	}
	
	public void stop()
	{
		t = null;
		
	}
	
	public void run()
	{
		while (Thread.currentThread() == t)
		{
			repaint();
			try
			{
				Thread.currentThread();
				Thread.sleep(1000);
			}
			catch  (InterruptedException e)
			{
				
			}
			}
		}
	
	public String getTimeofday(int a) //returns AM or PM
	{
		if (a == 0)
		{
		 return "AM";
		}
		else
		{
		  return "PM";
		}
	}
	
	public String getdayofWeek(int d) //return the day of the week
	{
		switch (d) 
		{
		case 1:
			return "Sunday";
		case 2:
			return "Monday";
		case 3:
			return "Tuesday";
		case 4:
			return "Wednesday";
		case 5:
			return "Thursday";
		case 6:
			return "Friday";
		case 7:
			return "Saturday";
		default:
			break;
		}
		return null;
		
	}
	
	public String getMonth(int m) //returns the month name
	{
		switch (m) 
		{
		case 0:
			return "January";
		case 1:
			return "February";
		case 2:
			return "March";
		case 3:
			return "April";
		case 4:
			return "May";
		case 5:
			return "June";
		case 6:
			return "July";
		case 7:
			return "August";
		case 8:
			return "September";
		case 9:
			return "October";
		case 10:
			return "November";
		case 11:
			return "December";
		default:
			break;
		}
		return null;
		
	}
	
	public void paint(Graphics g)
	{
		String var ="";		
		String whatday ="";
		String whatmonth="";
		String romanMin="";
		String romanHour="";
		String romanSec="";
	Calendar calendar = Calendar.getInstance();	//creating calendar instance
	int hours = calendar.get(Calendar.HOUR);
	int minutes = calendar.get(Calendar.MINUTE);
	int seconds = calendar.get(Calendar.SECOND);
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH);
	int date = calendar.get(Calendar.DATE);
	int day = calendar.get(Calendar.DAY_OF_WEEK);
	int ampm = calendar.get(Calendar.AM_PM);
	
	var= getTimeofday(ampm);//gets AM or PM
	whatday = getdayofWeek(day); //gets the day
	whatmonth=getMonth(month); //gets the month
	
	cuckooClock cuckoo = new cuckooClock();
	cuckoo.cuckooTime(minutes);//Calling Cuckoo functionality
	
	
	if (alarmTime.contains(var))//check for Alarm 
	{
		//System.out.println("check1");
		if(alarmHr == hours)
		{
			//System.out.println("check2");
			if(alarmMin == minutes)
			{
				//System.out.println("check3");
				String message="Wake up call at "+hours+" "+minutes+" "+var+"\n !!Please wake up!!!";
				JFrame wakeUp= new JFrame();
				JOptionPane.showMessageDialog(wakeUp,message,"!!ALARM!!",JOptionPane.ERROR_MESSAGE);
				Toolkit.getDefaultToolkit().beep();//chime at the alarm!!
				}
			
		}
	}
	
	romanNumerals roman = new romanNumerals();
	romanHour=roman.getNumeral(hours); //calls the getNumeral() in RomanNumerals class
	romanMin=roman.getNumeral(minutes);
	romanSec = roman.getNumeral(seconds);/*gets the hrs,minutes seconds in Roman numerals*/
	
	g.setFont(font); //setting font and color
	g.setColor(color);
	
	g.drawString(date+"-"+whatmonth+"-"+year, 10, 60);	//draws the Strings
	g.drawString(whatday, 10, 90);
	g.drawString(hours+":"+minutes/10 + minutes%10 +":"+seconds/10 + seconds%10+" "+var, 10, 120);
	g.drawString("Time in Roman Numerals", 10, 200);
	g.drawString(romanHour+":"+romanMin+":"+romanSec+" "+var, 10, 230);
	}
}	

