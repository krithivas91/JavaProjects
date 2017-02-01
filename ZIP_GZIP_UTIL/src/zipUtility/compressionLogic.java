package zipUtility;
import java.util.zip.ZipOutputStream; 
import java.io.BufferedInputStream; 
import java.io.BufferedOutputStream; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.IOException;
import java.util.zip.GZIPInputStream; 
import java.util.zip.GZIPOutputStream; 
import java.util.zip.ZipEntry; 
import java.util.zip.ZipInputStream; 
public class compressionLogic
{ 
	public static String zip(String dir, String fname, String outfname) 
	{ 
    try 
    { 
    	BufferedInputStream in = null; 
        FileOutputStream destination = new FileOutputStream(dir + outfname); 
        ZipOutputStream outStream = new ZipOutputStream(new BufferedOutputStream(destination)); 
        outStream.setMethod(ZipOutputStream.DEFLATED); 
        byte data[] = new byte[buff]; 
        FileInputStream fileInStream = new FileInputStream(dir + fname); 
        in = new BufferedInputStream(fileInStream, buff); 
        ZipEntry entry = new ZipEntry(fname); 
        outStream.putNextEntry(entry); 
        int c; 
        while ((c = in.read(data, 0, buff)) != -1) 
        { 
          outStream.write(data, 0, c); 
        } 
        in.close(); 
        outStream.close(); 
        filePathName = "File Zipped: " + dir + outfname; 
       }
    catch (Exception e) 
    { 
      filePathName = e.getMessage(); 
    }  
    return filePathName;
    } 

  public static String unZip(String dir, String fname)
  { 
      try 
      { 
        if (!getFormat(fname).equalsIgnoreCase("zip"))
        { 
          filePathName = "Error- file name must have Extension " + ".zip"; 
        } 
        else
        { 
          BufferedOutputStream destination = null; 
          FileInputStream fileIn = new FileInputStream(dir + fname); 
          ZipInputStream zipIn = new ZipInputStream(new BufferedInputStream(fileIn)); 
          ZipEntry entry;    
          while ((entry = zipIn.getNextEntry()) != null) 
          { 
            int c; 
            byte data[] = new byte[buff]; 
            FileOutputStream fileOutput = new FileOutputStream(dir + entry.getName()); 
            filePathName = dir + entry.getName(); 
            destination = new BufferedOutputStream(fileOutput, buff); 
            while ((c = zipIn.read(data, 0, buff)) != -1) 
            { 
              destination.write(data, 0, c); 
            } 
            destination.flush(); 
            destination.close(); 
          } 
          zipIn.close(); 
          filePathName = "File Unzipped: " + filePathName; 
        } 
        } catch (Exception e) 
      { 
          filePathName = e.getMessage(); 
      
      } 
      return filePathName; 
    } 

  public static String gZip(String fname) 
  { 
      try { 
        opFileName = fname + ".gz"; 
        GZIPOutputStream gzipOut = null; 
        try { 
          gzipOut = new GZIPOutputStream(new FileOutputStream(opFileName)); 
          } 
        catch (FileNotFoundException e) 
        { 
          opFileName = "Error- Unable to create " + opFileName; 
        } 

        FileInputStream in = null; 
        try { 
          in = new FileInputStream(fname); 
        } 
        catch (FileNotFoundException e) 
        { 
          opFileName = "ERROR: File not found " + fname; 
        } 
        byte[] buf = new byte[1024]; 
        int len; 
        while ((len = in.read(buf)) > 0) 
        { 
          gzipOut.write(buf, 0, len); 
        } 
        in.close(); 
        gzipOut.finish(); 
        gzipOut.close(); 
        opFileName = "File GZipped: " + opFileName; 
        } 
      catch (IOException e) 
      { 
          opFileName = e.getMessage(); 
        } 
      return opFileName; 
  } 
  public static String unGZip(String fname) 
  { 
	  try
	  { 
        if (!getFormat(fname).equalsIgnoreCase("gz")) 
        { 
          opFileName = "Error- file name must have Extension " + ".gz"; 
        } 
        else 
        { 
          GZIPInputStream in = null; 
          try 
          { 
            in = new GZIPInputStream(new FileInputStream(fname)); 
          }
          catch (FileNotFoundException e) 
          { 
            opFileName = "ERROR: File not found " + fname; 
          } 
          opFileName = getFileName(fname); 
          FileOutputStream out = null; 
          try
          { 
            out = new FileOutputStream(opFileName); 
          }
          catch (FileNotFoundException e) 
          { 
            opFileName = "Error -Unable to create " + opFileName; 
          } 
          byte[] buf = new byte[1024]; 
          int l; 
          while ((l = in.read(buf)) > 0) 
          { 
            out.write(buf, 0, l); 
          } 
          in.close(); 
          out.close(); 
          opFileName = "File Unzipped: " + getFileName(fname); 
        } 
        } 
	  catch (IOException e) 
	  { 
        opFileName = e.getMessage(); 
      } 
      return opFileName; 
  } 

  public static String getFormat(String fname) 
  { 
    String extension = ""; 
    int j = fname.lastIndexOf('.'); 
    if (j > 0 && j < fname.length() - 1) 
    { 
      extension = fname.substring(j + 1); 
    } 
    return extension; 
  } 

  public static String getFileName(String f)
  { 
    String fname = ""; 
      int j = f.lastIndexOf('.'); 

      if (j > 0 && j < f.length() - 1) 
      {  
        fname = f.substring(0, j); 
      } 
      return fname; 
  }
  static final int buff = 2048; 
  static String filePathName = "";       
  static String opFileName = "";  
}

