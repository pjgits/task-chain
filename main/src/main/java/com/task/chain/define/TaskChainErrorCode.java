package com.task.chain.define;

/**
 * Created by pengj on 2017-03-10.
 */
public enum TaskChainErrorCode {


    GLOBAL_ERROR(0,"has error"),

    /**
     * 1000-2000
     * 与使用者相关错误
     */
    SET_OBJECT_NULL(1001,"exist null");



    public static TaskChainErrorCode createByCode(int errorCode){
        for(TaskChainErrorCode val : values()){
            if(val.getCode() == errorCode){
                return val;
            }
        }
        return GLOBAL_ERROR;
    }


    private int code;
    private String msg;
    TaskChainErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getCode() {
        return this.code;
    }

}
