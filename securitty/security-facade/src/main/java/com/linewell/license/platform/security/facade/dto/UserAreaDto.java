package com.linewell.license.platform.security.facade.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wusy
 * Company: 南威软件股份有限公司
 * Createtime : 2019/8/22 15:23
 * Description :用户区域信息
 */
@Setter
@Getter
public class UserAreaDto {
    /**
     * 用户区域id
     */
    private Long areaId;
    /**
     * 用户区域名称
     */
    private String areaName;
}
