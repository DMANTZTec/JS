package com.java.IndexingSolr;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
public class QuartzScheduling
{
   
    public static void main(String[] args) throws Exception 
    {  
        
    	
		try {
			String startDateStr = "2017-10-12 10:00:00.0";
	        Date startDate;
			startDate = (Date) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDateStr);
       
        
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("indexjob", "group4").build();
        Trigger trigger = TriggerBuilder.newTrigger().startAt(startDate)
        .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(15).repeatForever()).build();
        // Tell quartz to schedule the job using our trigger
        Properties prop = new Properties();
			prop.put("org.quartz.scheduler.rmi.proxy", "true");
			prop.put("org.quartz.scheduler.rmi.registryHost", "localhost");
			prop.put("org.quartz.scheduler.rmi.registryPort", "1099");
			prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
			prop.put("org.quartz.threadPool.threadCount", "4");
			 SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory(prop);
		        Scheduler scheduler = schedFact.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
      //  scheduler.shutdown();
    }  
       
        catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}