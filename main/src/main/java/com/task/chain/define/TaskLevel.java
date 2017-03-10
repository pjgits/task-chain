package com.task.chain.define;

/**
 * Created by pengj on 2017-03-10.
 */
public enum TaskLevel {
    HIGHT_LEVEL((short)1,"The best"),
    MIDDLE_LEVEL((short)5,"The middle"),
    LOW_LEVEL((short)9,"The low");

    TaskLevel(short level,String str){
        this.level = level;
        this.msg = str;
    }
    public static TaskLevel createByLevel(int level){
        if(level==5){
            return MIDDLE_LEVEL;
        }else if (level == 1){
            return HIGHT_LEVEL;
        }else{
            return LOW_LEVEL;
        }

    }
    private short level;
    private String msg;

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
