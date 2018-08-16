package com.ucl.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;


/**
 *
 */
@DisallowConcurrentExecution//可以保证一个job执行完才开始下一个job，避免出错。
public class QuartzTest {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //新建调度器工厂
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        //通过调度器工厂新建调度器
        Scheduler scheduler = schedulerFactory.getScheduler();
        //启动调度器
        scheduler.start();

        //定义Job任务
        JobBuilder jobBuilder = newJob(EmailJob.class);
        jobBuilder.withIdentity("Email", "EmailGroup");
        JobDetail job = jobBuilder.build();

        //定义定时器
        TriggerBuilder triggerBuilder = newTrigger();
        SimpleScheduleBuilder simpleScheduleBuilder = simpleSchedule().withIntervalInSeconds(3).repeatForever();

        triggerBuilder.withIdentity("EmailTrigger", "EmailGroup")
                .startNow()
                .usingJobData("email", "63742284@qq.com")
                .withSchedule(simpleScheduleBuilder);
        Trigger trigger = triggerBuilder.build();

        //将任务和触发器放入调度器中
        scheduler.scheduleJob(job, trigger);
        Thread.sleep(5000);
        //停止调度器
//        sched.shutdown();
    }
}
