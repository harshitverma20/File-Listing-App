import java.io.*;
import java.util.*;

//package filelisting;
public class FileListing{
    
    static void listFiles(String s1 , ArrayList aL){                //recursive function..
        File root = new File(s1.trim());
        File f[] = root.listFiles();
        
        for( int i=0 ; i<f.length ; i++)
        {
            if(f[i].isFile())
                aL.add(f[i].getAbsolutePath());
            
            else
                if(f[i].isDirectory())
                    listFiles(f[i].getAbsolutePath() , aL);
                
        }
    }

    public static void main(String[] args) throws IOException           //main fn..
    {
        ArrayList aL = new ArrayList();
        File f = new File("C:\\Users\\harshit\\Desktop\\abc.txt");
        try{
       
            if(!(f.exists())){
                throw new Exception("File path doesnot exists!!");
            }
            
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
        
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            File root = new File(s1.trim());
            File f2 = new File(s2.trim());
            
            if(!(root.exists()))
                throw new Exception("Input filepath "+root.getAbsolutePath()+"doesnot exist!!");
            if(!(f2.exists()))
                f2.createNewFile();
            
            if(root.isFile())
                System.out.println("It is a file. Name : "+root.getName()+" Path : "+root.getAbsolutePath());
            else
            {
               if(root.isDirectory())
               {
                   listFiles(root.getAbsolutePath() , aL);
               }
               
               System.out.println(aL);
                
               
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
