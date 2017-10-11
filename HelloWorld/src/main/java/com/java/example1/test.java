package com.java.example1;

import static org.quartz.JobBuilder.*;
import java.util.Properties;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class test {
	    public static void main(String[] args) {
		        try {
            			JobDetail job = newJob(HelloJob.class).withIdentity("myJob1", "group1").build();

            			Trigger trigger = newTrigger().withIdentity("myTrigger1", "group1").startNow().withSchedule(simpleSchedule().withIntervalInSeconds(10).repeatForever()).build();

            //Quartz Server Properties
            			Properties prop = new Properties();
            			prop.put("org.quartz.scheduler.rmi.proxy", "true");
            			prop.put("org.quartz.scheduler.rmi.registryHost", "localhost");
            			prop.put("org.quartz.scheduler.rmi.registryPort", "1099");
            			prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
            			prop.put("org.quartz.threadPool.threadCount", "1");

            			Scheduler scheduler = new StdSchedulerFactory(prop).getScheduler();
            			// scheduler.start();
            			scheduler.scheduleJob(job, trigger);
        		} 
        catch (SchedulerException e) {
            e.printStackTrace();
        		}
    	}
}