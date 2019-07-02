package com.example.remoteupgradesdk.utils;

import java.util.Timer;
import java.util.TimerTask;

public class MTimerTask {
    private Timer timer;
    private TimerTask task;
    private long time;

    public MTimerTask(long time, TimerTask task) {
        this.task = task;
        this.time = time;
        if (timer == null) {
            timer = new Timer();
        }
    }

    /**
     * @desc 启动任务
     * @author XL
     * @create_time 2019/4/16
     */
    public void start() {
        timer.schedule(task, 0, time);//每隔time时间段就执行一次
    }

    /**
     * @desc 停止任务
     * @author XL
     * @create_time 2019/4/16
     */
    public void stop() {
        if (timer != null) {
            timer.cancel();
            if (task != null) {
                task.cancel();  //将原任务从队列中移除
            }
        }
    }
}
