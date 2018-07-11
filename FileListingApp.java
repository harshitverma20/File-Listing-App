

import java.awt.Component;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class FileListingApp {
    static int count = 0;

    static void listFiles(String s1 , ArrayList aL){                //recursive function..
        File root = new File(s1.trim());
        File f[] = root.listFiles();
        
        for( int i=0 ; i<f.length ; i++)
        {
            if(f[i].isFile()){
                aL.add(count+") Name : "+f[i].getName()+", Path : "+f[i].getAbsolutePath());
                count++;
            }
            
            else
                if(f[i].isDirectory())
                    listFiles(f[i].getAbsolutePath() , aL);
                
        }
    }
    
    public static void main(String[] args) throws IOException           //main function
    {
        ArrayList aL = new ArrayList();
        String s1 , s2;
        try{
       
            s1 = JOptionPane.showInputDialog("Enter path of input folder to read content : ");
            File root = new File(s1.trim());
            
            if(!(root.exists()))
                throw new Exception("Input filepath "+root.getAbsolutePath()+"doesnot exist!!");
            
            if(root.isFile()){    
                throw new Exception("It is a File not a Directory \n"+
                                    " Name : " +root.getName()+"\n"+
                                    " Path : "+root.getAbsolutePath());
            }
            
            s2 = JOptionPane.showInputDialog("Enter path of .csv file to list content : ");
            File f2 = new File(s2.trim());
            if(!(f2.exists()))
                f2.createNewFile();
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(f2));
            
               if(root.isDirectory())
               {
                   listFiles(root.getAbsolutePath() , aL);
               }
               
               System.out.println(aL);
               
               Iterator it = aL.iterator();
               while(it.hasNext()){
                   bw.write(String.valueOf(it.next()));
                   bw.nextLine();
               }
            Component cmpnt = null;
             JOptionPane.showMessageDialog(cmpnt, "Operation Successful \n All files listed to : "+f2.getAbsolutePath());
               
               bw.close();
 
          
        }
        catch(Exception e){
            Component frame = null;
            JOptionPane.showMessageDialog(frame, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }  
}
