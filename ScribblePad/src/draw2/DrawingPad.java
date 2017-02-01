package draw2; 
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*; 
import scribble3.*;
import draw1.*;
public class DrawingPad extends draw1.DrawingPad { 
  public DrawingPad(String title) {
	  super(title); 
  }
  protected void initTools() { 
	  toolkit = new ToolKit(); 
	  toolkit.addTool(new ScribbleTool(canvas, "Scribble")); 
	  toolkit.addTool(new TwoEndsShapeTool(canvas, "Line", new LineShape())); 
	  toolkit.addTool(new TwoEndsShapeTool(canvas, "Oval", new OvalShape())); 
	  toolkit.addTool(new TwoEndsShapeTool(canvas, "Rect", new RectangleShape())); 
	  toolkit.addTool(new TwoEndsShapeTool(canvas, "Filled Oval", new FilledOvalShape())); 
	  toolkit.addTool(new TwoEndsShapeTool(canvas, "Filled Rect", new FilledRectangleShape())); 
	  toolkit.addTool(new TwoEndsShapeTool(canvas, "Circle", new CircleShape())); 
	  toolkit.addTool(new TwoEndsShapeTool(canvas, "Filled Circle", new FilledCircleShape())); 
	  toolkit.addTool(new TwoEndsShapeTool(canvas, "Polygon", new PolygonShape())); 
	  toolkit.addTool(new TwoEndsShapeTool(canvas, "Filled Polygon", new FilledPolygonShape())); 
	  toolkit.addTool(new TwoEndsShapeTool(canvas, "Round Rectangle", new RoundRectangleShape())); 
	  toolkit.addTool(new TwoEndsShapeTool(canvas, "Filled Round Rectangle", new FilledRoundRectangleShape()));
	  toolkit.addTool(new EraserTool(canvas, "Eraser")); 
	  toolkit.addTool(new TwoEndsShapeTool(canvas, "Erase Area", new EraseAreaTool()));  
	  drawingCanvas.setTool(toolkit.getTool(0));
  }
  public static void main(String[] args) {
	  JFrame frame = new draw2.DrawingPad("Drawing Pad");
	  frame.setSize(width, height);
	  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	  frame.setLocation(screenSize.width/2 - width/2,
	  screenSize.height/2 - height/2);
	  frame.show();
  }
}
