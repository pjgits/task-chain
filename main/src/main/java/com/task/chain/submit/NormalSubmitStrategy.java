package com.task.chain.submit;

import com.task.chain.queue.NormalTaskQueue;
import com.task.chain.task.AbstractTask;

/**
 * Created by pengj on 2017-03-10.
 */
public class NormalSubmitStrategy extends SubmitStrategy {
    private NormalTaskQueue queue = null;
    public NormalSubmitStrategy(NormalTaskQueue queue){
        this.queue = queue;
    }
    public void submit(AbstractTask task) {

    }
}
