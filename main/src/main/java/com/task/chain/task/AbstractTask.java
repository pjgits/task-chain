package com.task.chain.task;

import com.google.common.base.Objects;
import com.task.chain.define.TaskChainContext;
import com.task.chain.define.TaskLevel;

/**
 * Created by pengj on 2017-03-10.
 */
public abstract class AbstractTask implements Task {
    private String name;
    private String taskId;
    private TaskLevel level;

    public TaskLevel getLevel() {
        return level;
    }

    public void setLevel(TaskLevel level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractTask(String name) {
        this.name = name;
    }
    public AbstractTask(String name,TaskLevel level) {
        this.name = name;
        this.level = level;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public AbstractTask() {
        this.name = "Task";
    }

    protected void before(TaskChainContext context) {

    }

    protected void after(TaskChainContext context) {

    }

    protected void reset(TaskChainContext context) {

    }

    public void run(TaskChainContext context) {
        before(context);
        execute(context);
        after(context);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof AbstractTask)){
            return false;
        }
        AbstractTask task  = (AbstractTask) obj;
        if(!this.taskId.equals(task.getTaskId()) || !this.name.equals(task.getName())){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(taskId,name);
    }

    @Override
    public String toString() {
        return String.format("[taskId=%s,TaskName=%s]",taskId,name);
    }
}
