package draw;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

public class mainDraw {
	
	public static ArrayList<Shapes> shape = new ArrayList<Shapes>();
	public static  void substringLine(String getLine)
	{
		Scanner sc = new Scanner(getLine);
		String name = sc.next();
		int x1= Integer.parseInt(sc.next());
		int y1= Integer.parseInt(sc.next());
		sc.next();
		int x2= Integer.parseInt(sc.next());
		int y2=Integer.parseInt(sc.next());
		Lines lines = new Lines();
		lines.setName(name);
		lines.setX1(x1);
		lines.setX2(x2);
		lines.setY1(y1);
		lines.setY2(y2);
		shape.add(lines);
		System.out.println(lines.toString());
	  }
	
	public static void substringOval(String getLine)
	{
		Scanner sc = new Scanner(getLine);
		String name = sc.next();
		int width =Integer.parseInt(sc.next());
		int height = Integer.parseInt(sc.next());
		Oval ova = new Oval();
		ova.setName(name);
		ova.setHeight(height);
		ova.setWidth(width);
		shape.add(ova);
		System.out.println(ova.toString());
		
	}
		
	public static void substringRect(String getLine)
	{

		Scanner sc = new Scanner(getLine);
		String name =sc.next();
		int width =Integer.parseInt(sc.next());
		sc.next();
		int height = Integer.parseInt(sc.next());
		Rectangle rect = new Rectangle();
		rect.setHeight(height);
		rect.setName(name);
		rect.setWidth(width);
		shape.add(rect);
		System.out.println(rect.toString());
	}
	public static void substringCirc(String getLine)
	
	{	
		Scanner sc = new Scanner(getLine);
		String name = sc.next();
		int radius =Integer.parseInt(sc.next());
		Circle circ =new Circle();
		circ.setName(name);
		circ.setRadius(radius);
		shape.add(circ);
		System.out.println(circ.toString());
	}


	public static void main(String[] args)
	{
		try
		
		{
			String line="";
			FileInputStream f = new FileInputStream("draw.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(f));
			line= br.readLine();
			while (line!= null)
			{
				if (line.contains("LineSegment"))
				{
					substringLine(line);
					
				}
				
				if (line.contains("Rectangle")) 
				{
					substringRect(line);
				}
				
				if  (line.contains("Circle"))
				{
					substringCirc(line);
					
				}
				if (line.contains("Oval"))
				{
					substringOval(line);
					
				}
				line= br.readLine();
				
			}
			
			if(line==null)
			{
				System.out.println("All files are read");
				
			}
			
			JFrame j = new JFrame("Shapes");
			j.setDefaultCloseOperation(j.EXIT_ON_CLOSE);
			j.setBackground(Color.white);
			drawShape d = new drawShape();
			j.add(d);
			j.setSize(1100,1000);
			j.setVisible(true);
			
		}
		catch (NullPointerException n)
		{
			System.out.println(" TXT FILE IS EMPTY" );
		}	
		
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
		
	}

}
