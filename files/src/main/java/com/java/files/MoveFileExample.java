package com.java.files;
import java.io.File;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
public class MoveFileExample implements org.quartz.Job
{
	public void execute(JobExecutionContext arg0) throws JobExecutionException 
	{
		try
		{
    	   File afile =new File("D:\\program\\a.txt");
    	   if(afile.renameTo(new File("D:\\git\\" + afile.getName()))){
    		System.out.println("File is moved successful!");
    	   }else{
    		System.out.println("File is failed to move!");
    	   }
    	}
		catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
		
}