package com.task.chain.main;

import com.task.chain.task.AbstractTask;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;


/**
 * Created by pengj on 2017-03-09.
 */
public class TaskChainMain {

    private static final Map<String,Future> TASK_FUTURE = new ConcurrentHashMap<String, Future>();

    /**
     * 运行任务
     * @param task
     * @param params
     *
     */
    public static void run(Class<Runnable> task, Map<String,Object> params){

    }

    /**
     * 提交任务
     * @param task
     * @param params
     * @return
     */
    public static String submit(Class<AbstractTask> task, Map<String,Object> params){

        return null;
    }

    /**
     * 获取任务返回结果
     * 只有通过submit提交任务的才能取得到
     * @param taskId
     * @return
     */
    public static Future getFuture(String taskId){

        return null;
    }

    /**
     * 设置返回结果
     * @param taskId
     * @param value
     */
    public static void setFuture(String taskId,Object value){


    }

}
