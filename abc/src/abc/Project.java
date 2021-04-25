package abc;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Project {
	public static void main(String args[])
	{
		int a;
		Scanner input = new Scanner(System.in);
		printmenu();
		while(true)
		{
			System.out.println("Enter your choice:");
            a = input.nextInt();   
            switch(a)
            {    
            	case 1: showfile(); 
                    break;  
            	case 2: submenu();
            			break;	
            	default: System.out.println("Exit");
           			exit();
           			break;
             }
		}
	}
	public static void submenu()
	{	
		String s;
		char choice;
		Scanner input = new Scanner(System.in);
		System.out.println("2.Business level operations");
		System.out.println("  a Add files in the directory");
		System.out.println("  b Delete files from the directory");
		System.out.println("  c Search file from the directory");
		
		System.out.println("Enter your option: a,b or c");
		s= input.next();
		choice=s.charAt(0);
		switch(choice)
		{
			case 'a': AddFile();
        		break;
			case 'b': DeleteFile();
        		break;
			case 'c': SearchFile();
        		break;
        	default: printmenu();
		}	
			
	}
	public static void printmenu()
	{
		System.out.println("****************************************************************");
		System.out.println(" 1.Show files in order");
		System.out.println(" 2.Business level operations");
		System.out.println(" 3.Exit");
	}

	public static void AddFile()
	{
		System.out.println("Enter the name of the file you want to create");
		Scanner scnr=new Scanner(System.in);
		
		String newName=scnr.next();
		try 
		{
			File file=new File("c://Users//tishr//OneDrive//Desktop//Documents//" +newName);
		    if(file.createNewFile())
		    {
			     System.out.println("file is created");
		    }
		     else
		     {
			      
			      System.out.println("file already exist");
		     }
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void DeleteFile() 
	{
		 System.out.println("Enter the name of the file which you want to delete");
		 Scanner scr=new Scanner(System.in);
		 String newName=scr.nextLine();
		
		 File file=new File("c:\\Users\\tishr\\OneDrive\\Desktop\\Documents\\" +newName);
		
		if(file.exists())
		{
			file.delete();
			System.out.println("File deleted successfully: " +newName);
		}
		else
		 System.out.println("File not found");
		
	}
	
	public static void showfile() 
	{
		System.out.println("Show files in ascending order from directory");
		File file=new File("c://Users//tishr//OneDrive//Desktop//Documents//");
		
		 	String[] flist = file.list();
		 	if (flist == null) 
	        {
	            System.out.println("Empty directory.");
	        }
	        else 
	        {
	        	for (int i = 0; i < flist.length; i++) 
	            {
	                String filename = flist[i];
	                System.out.println( filename);
	            }
	        }
	}
	
	public static void SearchFile() 
	{
		System.out.println("Enter the name of the file which you want to search");
		Scanner scr=new Scanner(System.in);
		String newName=scr.nextLine();
		 
		File file=new File("c://Users//tishr//OneDrive//Desktop//Documents//");
        
        String[] flist = file.list();
        int flag = 0;
        if (flist == null) 
        {
            System.out.println("Empty directory.");
        }
        else 
        {
        	for (int i = 0; i < flist.length; i++) 
            {
                String filename = flist[i];
                if (filename.equalsIgnoreCase(newName)) 
                {
                    System.out.println(filename + " found");
                    flag = 1;
                }
            }
        }
  
        if (flag == 0)
        {
            System.out.println("File Not Found");
        }
    }

	public static void exit()
	{
		System.exit(0);
	}

}
