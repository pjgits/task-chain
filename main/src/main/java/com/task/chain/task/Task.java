package com.task.chain.task;

import com.task.chain.define.TaskChainContext;

import java.io.Serializable;

/**
 * Created by pengj on 2017-03-10.
 */
public interface Task extends Serializable{
    void execute(TaskChainContext context);

}
