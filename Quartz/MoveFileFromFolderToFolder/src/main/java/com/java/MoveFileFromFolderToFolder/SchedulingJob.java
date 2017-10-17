package com.java.files;
import java.util.Date;
import java.util.Properties;
import java.text.SimpleDateFormat;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
//import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
public class Schedulers
{
    public static void main(String[] args) throws Exception 
    {  
    	try
    	{
        String startDateStr = "2017-10-09 9:39:00.0";
        Date startDate = (Date) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(startDateStr);
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        JobDetail jobDetail = JobBuilder.newJob(MoveFileExample.class)
                .withIdentity("moveFileJob", "group3").build();
        Trigger trigger = TriggerBuilder.newTrigger().startAt(startDate)
        .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(15).repeatForever()).build();
              
           Properties prop = new Properties();
   			prop.put("org.quartz.scheduler.rmi.proxy", "true");
   			prop.put("org.quartz.scheduler.rmi.registryHost", "localhost");
   			prop.put("org.quartz.scheduler.rmi.registryPort", "1099");
   			prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
   			prop.put("org.quartz.threadPool.threadCount", "1");
   			
         scheduler.scheduleJob(jobDetail, trigger);
        
               scheduler.shutdown();
    }
    	catch (SchedulerException e)
    	{
            e.printStackTrace();
        		}
    }
}