package draw1; 
import java.util.EventListener;
import scribble3.*;
public class DrawingCanvas extends ScribbleCanvas {
private static final long serialVersionUID = 1L;
public DrawingCanvas() {
  }
  public void setTool(Tool tool) { 
    drawingCanvasListener.setTool(tool);
  }
  public Tool getTool() { 
    return drawingCanvasListener.getTool(); 
  }
protected EventListener makeCanvasListener() {
    return (drawingCanvasListener = new DrawingCanvasListener(this)); 
  }
  protected DrawingCanvasListener drawingCanvasListener; 
}
