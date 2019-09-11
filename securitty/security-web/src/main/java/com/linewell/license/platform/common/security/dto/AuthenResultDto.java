package com.linewell.license.platform.common.security.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-28
 * Time 10:56
 */
@Setter
@Getter
public class AuthenResultDto {

    /**
     * 中台令牌
     */
   private  MidToken midToken;

    /**
     * 密码是否过期
     */
    private  Boolean isPasswdExpired=false;

    public AuthenResultDto(MidToken midToken, Boolean isPasswdExpired) {
        this.midToken = midToken;
        this.isPasswdExpired = isPasswdExpired;
    }


    public AuthenResultDto(MidToken midToken) {
        this.midToken = midToken;
    }
}
