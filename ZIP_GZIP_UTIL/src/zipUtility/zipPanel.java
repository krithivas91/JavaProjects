package zipUtility;
import java.awt.GridBagLayout; 
import java.awt.Insets; 
import javax.swing.JButton; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JTextField; 
import javax.swing.border.Border; 
import javax.swing.border.TitledBorder; 
import java.awt.Choice; 
import java.awt.Color; 
import java.awt.FlowLayout; 
import java.awt.GridBagConstraints; 

public class zipPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	static JLabel formatLabel, pathLabel, selectedPath, errormsg; 
	static JButton fileButton, compressButton, decompressButton, clearButton; 
	static JTextField Path; 
	static Choice compFormat;  
	Border mainBorder; 
	public zipPanel() 
	{ 
    createGUI(); 
    } 
	public void createGUI()
	{ 
    this.setBackground(Color.GRAY); 
    JPanel panel = new JPanel(); 
    panel.setSize(400, 400); 
    panel.setBackground(Color.white); 
    Border mainBorder = new TitledBorder("ZIP/GZIP"); 
    panel.setBorder(mainBorder); 
    panel.setLayout(new GridBagLayout()); 
    GridBagConstraints gridBag = new GridBagConstraints(); 
    gridBag.insets = new Insets(10,10,10,10); 
    gridBag.fill = GridBagConstraints.HORIZONTAL; 
    this.add(panel); 
    
    formatLabel = new JLabel("Format"); 
    gridBag.gridx = 0; 
    gridBag.gridy = 0; 
    panel.add(formatLabel, gridBag); 
     
    compFormat = new Choice(); 
    compFormat.addItem(""); 
    compFormat.addItem("GZip"); 
    compFormat.addItem("Zip"); 
    gridBag.gridx = 1; 
    gridBag.gridy = 0; 
    gridBag.gridwidth = 2; 
    panel.add(compFormat, gridBag); 
     
    fileButton = new JButton("Select File"); 
    gridBag.gridx = 0; 
    gridBag.gridy = 1; 
    gridBag.gridwidth = 2; 
    panel.add(fileButton, gridBag); 
     
    errormsg = new JLabel(""); 
    gridBag.gridx = 2; 
    gridBag.gridy = 1; 
    gridBag.gridwidth = 2; 
    panel.add(errormsg, gridBag); 
     
    pathLabel = new JLabel("Path:"); 
    gridBag.gridx = 0; 
    gridBag.gridy = 2; 
    panel.add(pathLabel, gridBag); 
     
    Path = new JTextField(); 
    gridBag.gridx = 1; 
    gridBag.gridy = 2; 
    gridBag.gridwidth = 3; 
    panel.add(Path, gridBag); 
     
   JPanel layoutPanel = new JPanel(); 
    layoutPanel.setLayout(new FlowLayout()); 
    layoutPanel.setBackground(Color.white); 
   
    gridBag.gridx = 0; 
    gridBag.gridy = 3; 
    gridBag.gridwidth = 4; 
    panel.add(layoutPanel, gridBag);
     
    compressButton = new JButton("Compress"); 
    decompressButton = new JButton("Decompress"); 
    layoutPanel.add(compressButton); 
    layoutPanel.add(decompressButton); 
         
    selectedPath = new JLabel(" "); 
    gridBag.gridx = 0; 
    gridBag.gridy = 4; 
    gridBag.gridwidth = 4; 
    panel.add(selectedPath, gridBag); 

    clearButton = new JButton("Clear"); 
    gridBag.gridx = 0; 
    gridBag.gridy = 5; 
    gridBag.gridwidth = 3; 
    panel.add(clearButton, gridBag); 
    clearButton.setVisible(false); 
  } 
}
