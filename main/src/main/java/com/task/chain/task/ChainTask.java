package com.task.chain.task;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pengj on 2017-03-10.
 */
public abstract class ChainTask extends AbstractTask {
    private volatile List<ChainTask> beforeChain = null;
    private volatile List<ChainTask> afterChain = null;
    private Lock beforeLock = new ReentrantLock();
    private Lock afterLock = new ReentrantLock();

    public ChainTask addBeforeTask(ChainTask task) {
        try {
            beforeLock.lock();
            if (null == beforeChain) {
                beforeChain = new LinkedList<ChainTask>();
            }
            this.beforeChain.add(task);
        } finally {
            beforeLock.unlock();
        }
        task.addAfterTask(this);
        return this;
    }

    private ChainTask addAfterTask(ChainTask task) {
        try {
            afterLock.lock();

            if (null == this.afterChain) {
                afterChain = new LinkedList<ChainTask>();
            }
            this.afterChain.add(task);
        } finally {

            afterLock.unlock();
        }
        return this;
    }

    public void runComplete() {
        try {
            afterLock.lock();
            if (null != afterChain) {
                for (ChainTask task : afterChain) {
                    task.removeBeforeTask(this);
                }
            }
        }finally {
            afterLock.unlock();
        }

    }

    public void removeBeforeTask(ChainTask task) {
        try {
            beforeLock.lock();
            if (null != beforeChain) {
                Iterator<ChainTask> iterator = beforeChain.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().equals(task)) {
                        iterator.remove();
                        break;
                    }
                }

            }
        } finally {
            beforeLock.unlock();
        }
    }

}
