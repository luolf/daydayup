package com.linewell.license.ops.common.espojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-06-21
 * Time 10:45
 */
@Getter
@Setter
public class EsOpsBaseInfo implements Serializable {
    private static final long serialVersionUID = -4534847834150774978L;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date timestamp;
    /**
     * 记录ID
     */
    private String id;
    /**
     * 插件名称
     */
    private String plugin;
    /**
     * 插件ID
     */
    private String pluginId;
    /**
     * 应用实例ID、服务实例ID
     */
    private String instanceId;
    /**
     * 服务器标识
     */
    private String clientIdentifying;
}
