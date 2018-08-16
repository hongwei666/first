package com.ucl.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class EmailJob implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("发送邮件成功" + new Date());
        int i = 0;
        try {
//            System.out.println(100 / i);
        } catch (Exception e) {
            System.out.println("发生异常");
            JobExecutionException je = new JobExecutionException(e);
            //停止触发器
            je.setUnscheduleAllTriggers(true);
            throw je;
        }
    }
}
