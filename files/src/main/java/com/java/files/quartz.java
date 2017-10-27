package com.java.files;

import java.util.Properties;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
//import org.quartz.JobListener;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class quartz {
     public static void main(String[] args) {
          try {
               Properties prop = new Properties();

               //RMI configuration to make the client to connect to the Quartz server
               prop.put("org.quartz.scheduler.rmi.export", "true");
               prop.put("org.quartz.scheduler.rmi.createRegistry", "true");
               prop.put("org.quartz.scheduler.rmi.registryHost", "localhost");
               prop.put("org.quartz.scheduler.rmi.registryPort", "1099");
               prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
               prop.put("org.quartz.threadPool.threadCount", "2");

               //Quartz Server Properties
               prop.put("quartz.scheduler.instanceName", "Scheduler");
               prop.put("org.quartz.scheduler.instanceId", "AUTO");
               prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
               prop.put("org.quartz.scheduler.instanceId", "NON_CLUSTERED");
              // prop.put("org.quartz.JobListener.NAME.class","com.java.files.MoveFileExample");

               prop.put("org.quartz.scheduler.jobFactory.class", "org.quartz.simpl.SimpleJobFactory");
               prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
               prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
               prop.put("org.quartz.jobStore.dataSource", "quartzDataSource");
               prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
               prop.put("org.quartz.jobStore.isClustered", "false");

               //MYSQL DATABASE CONFIGURATION
               //If we do not specify this configuration, QUARTZ will use RAM(in-memory) to store jobs
               //Once we restart QUARTZ, the jobs will not be persisted
               prop.put("org.quartz.dataSource.quartzDataSource.driver", "com.mysql.jdbc.Driver");
               prop.put("org.quartz.dataSource.quartzDataSource.URL", "jdbc:mysql://localhost:3306/quartz");
               prop.put("org.quartz.dataSource.quartzDataSource.user", "root");
               prop.put("org.quartz.dataSource.quartzDataSource.password", "secret");
               prop.put("org.quartz.dataSource.quartzDataSource.maxConnections", "2");

               SchedulerFactory stdSchedulerFactory = new StdSchedulerFactory(prop);
               Scheduler scheduler = stdSchedulerFactory.getScheduler();
               scheduler.start();
               //scheduler.shutdown();

          } catch (SchedulerException e) {
               e.printStackTrace();
          }
     }
}