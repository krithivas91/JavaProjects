package draw3; 
import java.awt.*; 
import java.awt.event.*; 
import java.util.EventListener;
import draw1.*;
public class KeyboardDrawingCanvas extends DrawingCanvas { 
private static final long serialVersionUID = 1L;
public KeyboardDrawingCanvas() {
    addKeyListener((KeyListener) listener); 
    font = new Font(fontFamily, fontStyle, fontSize); 
  }
  public Font getFont() { 
    return font; 
  }
  public String getFontFamily() { 
    return fontFamily;
  }
  public void setFontFamily(String fontFamily) { 
    if (fontFamily != null && 
	!fontFamily.equals(this.fontFamily)) { 
      this.fontFamily =fontFamily;
      font = new Font(fontFamily, fontStyle, fontSize);
    }
  }
  public int getFontSize() { 
    return fontSize;
  }
  public void setFontSize(int fontSize) { 
    if (fontSize > 0 && 
	fontSize != this.fontSize) { 
      this.fontSize = fontSize;
      font = new Font(fontFamily, fontStyle, fontSize);
    }
  }
  public int getFontStyle() {
    return fontStyle;
  }
  public void setFontStyle(int fontStyle) {
    if (fontStyle != this.fontStyle) { 
      this.fontStyle = fontStyle;
      font = new Font(fontFamily, fontStyle, fontSize);
    }
  }
  public boolean isFocusable() { 
    return true; 
  }
  protected EventListener makeCanvasListener() {
    return (drawingCanvasListener = new KeyboardDrawingCanvasListener(this)); 
  }
  protected String fontFamily = "Serif";
  protected int fontSize = 24; 
  protected int fontStyle = Font.PLAIN;
  protected Font font; 
}
