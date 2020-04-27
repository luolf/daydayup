package org.llf.processor.common.msg;

import java.io.Serializable;

/**
 * 消息基类
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-04-26
 * Time 14:21
 */
public class TaskMessage implements Serializable {
    /**
     * 任务id
     */
    private Long taskId;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务类型包含证照生成、证照ofd生成、证照ofd转图片等
     */
    private String taskType;

    /**
     * 任务状态：finished 结束、processing 执行中、new 新建、error 异常
     */
    private String status;

    /**
     * 处理等级：1：在线实时、2：在线批量、3：离线批量
     */
    private Byte processingLevel;

    /**
     * 处理对象id:证照id、批文id
     */
    private Long objectId;

    /**
     * 处理对象类型
     */
    private String objectType;

    /**
     * 请求编号
     */
    private String requestId;

    /**
     * 回调的服务id,一个服务的多个实例共用同一个id；可由appid+serverid组成
     */
    private String callbackServerId;

    /**
     * 发起请求的服务id,一个服务的多个实例共用同一个id，可由appid+serverid组成
     */
    private String requestServerId;
}
