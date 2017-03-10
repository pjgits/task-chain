package com.task.chain.define;

import com.google.common.base.Optional;
import com.task.chain.exception.IllegalNullException;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by pengj on 2017-03-10.
 *
 */
public class TaskChainContext {
    private Map<String,Object> TASK_INPUT_PARAMETERS = new HashMap<String,Object>();
    private Map<String,Object> TASK_OUTPUT_RESULT = new HashMap<String,Object>();

    public TaskChainContext(){

    }
    public TaskChainContext(Map<String,Object> params){
        if(null == params){
            throw new IllegalNullException(TaskChainErrorCode.createByCode(1001));
        }
        TASK_INPUT_PARAMETERS = params;
    }

    public Optional getParam(String key){
        return Optional.fromNullable(TASK_INPUT_PARAMETERS.get(key));
    }
    public TaskChainContext setParam(String key,Object val){
        TASK_INPUT_PARAMETERS.put(key,val);
        return this;
    }
    public TaskChainContext write(String key,Object val){
        TASK_OUTPUT_RESULT.put(key,val);
        return this;
    }
    public TaskChainContext write(Map<String,Object> params){
        if(null == params){
            throw new IllegalNullException(TaskChainErrorCode.createByCode(1001));
        }
        TASK_OUTPUT_RESULT = params;
        return this;
    }



}
