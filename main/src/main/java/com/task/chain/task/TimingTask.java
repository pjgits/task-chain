package com.task.chain.task;

/**
 * Created by pengj on 2017-03-10.
 */
public abstract class TimingTask extends AbstractTask {
    private long runTime;

    public TimingTask() {
    }

    public TimingTask(long time) {
        this.runTime = time;
    }

    public TimingTask(String name,
                      long time) {
        super(name);
        this.runTime = time;
    }


}
