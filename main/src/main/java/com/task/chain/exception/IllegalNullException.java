package com.task.chain.exception;

import com.task.chain.define.TaskChainErrorCode;

/**
 * Created by pengj on 2017-03-10.
 */
public class IllegalNullException extends TaskChainException {
    public IllegalNullException(String msg){
        super(msg);
    }
    public IllegalNullException(TaskChainErrorCode code){
        super(code);
    }
}
