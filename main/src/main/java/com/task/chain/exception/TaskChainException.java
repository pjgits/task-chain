package com.task.chain.exception;

import com.task.chain.define.TaskChainErrorCode;

/**
 * Created by pengj on 2017-03-10.
 */
public class TaskChainException extends RuntimeException {
    private String msg;
    private TaskChainErrorCode errorCode;

    public TaskChainException(){
        super();
    }
    public TaskChainException(String msg){
        super(msg);
        this.msg = msg;
        this.errorCode = TaskChainErrorCode.GLOBAL_ERROR;
    }

    public TaskChainException(String msg,int code){
        super(msg);
        this.msg = msg;
        this.errorCode = TaskChainErrorCode.createByCode(code);
    }
    public TaskChainException(TaskChainErrorCode code){
        super(code.getMsg());
        this.errorCode = code;
        this.msg = errorCode.getMsg();
    }

}
