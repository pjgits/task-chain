package com.task.chain.lang;

import com.task.chain.define.TaskChainContext;
import com.task.chain.task.AbstractTask;
import com.task.chain.task.ChainTask;
import org.junit.Assert;

/**
 * Created by pengj on 2017-03-10.
 */
public class Test {

    @org.junit.Test
    public void testInstance(){
        Assert.assertTrue(!(null instanceof AbstractTask));
        ChainTask task = new ChainTask() {
            public void execute(TaskChainContext context) {

            }

            public void run() {

            }
        };
        Assert.assertTrue(task instanceof AbstractTask);
    }
}
