package com.linewell.license.platform.common.security.facade.dto;

import com.linewell.license.platform.common.security.facade.constants.AuthenticationPrincipalType;
import lombok.Getter;
import lombok.Setter;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-21
 * Time 15:03
 */
@Setter
@Getter
public class PrincipalDto {
    /**
     * 用户账号、手机号、客户端标识等
     */
    String name;
    /**
     * name属于什么身份类别
     */
    AuthenticationPrincipalType type;

}
