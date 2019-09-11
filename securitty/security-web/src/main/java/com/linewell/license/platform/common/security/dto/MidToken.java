package com.linewell.license.platform.common.security.dto;

import com.linewell.license.platform.common.security.util.UUIDUtil;
import lombok.Getter;
import lombok.Setter;

/**
 *  令牌套装
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-28
 * Time 18:28
 */
@Setter
@Getter
public class MidToken {


    /**
     * 身份令牌
     */
    private String token;
    /**
     * 刷新令牌
     */
    private String reflushtoken;
}
