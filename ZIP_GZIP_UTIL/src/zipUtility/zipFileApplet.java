package zipUtility;
import java.awt.Choice; 
import java.awt.FileDialog; 
import java.awt.Frame; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.ItemEvent; 
import java.awt.event.ItemListener; 
import java.io.File;
import javax.swing.JApplet; 
import javax.swing.JFileChooser; 
import javax.swing.SwingUtilities; 
public class zipFileApplet extends JApplet
{ 
	private static final long serialVersionUID = 1L;
	zipPanel zipPanel = new zipPanel(); 
	static String compType = "", directory = "", fileName = "", pathName = "";
	static String outputPath = ""; 
	File file; 
	JFileChooser filech = new JFileChooser(); 
	public void init() 
	{ 
	try 
	{
       SwingUtilities.invokeAndWait(new Runnable () { 
        public void run() 
        { 
          showPanel(); 
          selectFile(); 
          selectType(); 
          compression(); 
          decompression(); 
          resetAll(); 
        } 
      }); 
    } catch (Exception e) {} 
  } 
   
  public void showPanel() 
  { 
    this.setSize(500, 400); 
    add(zipPanel); 
  } 
  

  public void selectType()
  { 
	  ItemListener typeListener  = new ItemListener() 
	  { 
		  public void itemStateChanged(ItemEvent event) { 
          zipPanel.errormsg.setText(""); 
          if (event != null) 
            System.out.println("Item state is changed " + event);
          Choice ch = (Choice) event.getSource(); 
          if (ch != null) 
            compType = event.getItem().toString(); 
        }  
      }; 
      zipPanel.compFormat.addItemListener(typeListener);     
  }
  public void selectFile()
  { 
	  ActionListener fileListener = new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
          if (compType.isEmpty() || compType.equals("")) { 
            zipPanel.errormsg.setText("Please select ZIP/GZIP"); 
          } 
          else { 
            Frame fr = new Frame(); 
            FileDialog dialogBox = new FileDialog(fr, "Select FILE",FileDialog.LOAD); 
            dialogBox.setVisible(true); 
            directory = dialogBox.getDirectory(); 
            fileName = dialogBox.getFile(); 
            if (directory != null && fileName != null) 
              pathName = directory + fileName; 
            zipPanel.Path.setText(pathName); 
          } 
        }  
      }; 
      zipPanel.fileButton.addActionListener(fileListener);     
  }
  public void compression() { 
      ActionListener compListener = new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
          zipPanel.clearButton.setVisible(true); 
          if (fileName == null || fileName.equals("")) 
          { 
                zipPanel.selectedPath.setText("choose File to compress"); 
          }  
          else
          { 
            if (compType.equalsIgnoreCase("ZIP")) 
            { 
              outputPath = compressionLogic.zip(directory, fileName, fileName + ".zip"); 
              zipPanel.selectedPath.setText(outputPath); 
             }  
            else 
            { 
              outputPath = compressionLogic.gZip(directory + fileName); 
              zipPanel.selectedPath.setText(outputPath); 
                
            } 
            } 
        }  
      }; 
      zipPanel.compressButton.addActionListener(compListener);     
  }
  public void decompression() 
  { 
     ActionListener decompListener = new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
          zipPanel.clearButton.setVisible(true); 
          if (fileName == null || fileName.equals("")) 
          { 
                zipPanel.selectedPath.setText("choose file to decompress"); 
            
          }  
          else 
          { 
            if (compType.equalsIgnoreCase("ZIP")) { 
              outputPath = compressionLogic.unZip(directory, fileName); 
              zipPanel.selectedPath.setText(outputPath); 
                
            }  
            else 
            { 
              outputPath = compressionLogic.unGZip(directory + fileName); 
              zipPanel.selectedPath.setText(outputPath); 
                
            }
            } 
        }  
      }; 
      zipPanel.decompressButton.addActionListener(decompListener);     
  }
  public void resetAll() 
  { 
     ActionListener clearListener = new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
          zipPanel.errormsg.setText(" "); 
          zipPanel.Path.setText(" "); 
          zipPanel.selectedPath.setText(" "); 
          zipPanel.clearButton.setVisible(false); 
          zipPanel.compFormat.select(0); 
        }  
      }; 
      zipPanel.clearButton.addActionListener(clearListener);     
  }
}
