package org.llf.processor.common.constant;

/**
 * 处理要求的枚举类
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-04-23
 * Time 14:37
 */
public enum ProcessingLevelConstants {
    //在线实时
    ONLINE_PROMPTLY(1,"在线实时"),

    //在线批量
    ONLINE_BATCH(2,"在线批量"),

    //离线批量
    OFFLINE(3,"离线批量");
    /**
    处理等级：1：在线实时、2：在线批量、3：离线批量
     **/
    private int processingLevel;
    private String desc;

    ProcessingLevelConstants(int processingLevel, String desc){
        this.setProcessingLevel(processingLevel);
        this.desc = desc;
    }

    public int getProcessingLevel() {
        return processingLevel;
    }

    public void setProcessingLevel(int processingLevel) {
        this.processingLevel = processingLevel;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
