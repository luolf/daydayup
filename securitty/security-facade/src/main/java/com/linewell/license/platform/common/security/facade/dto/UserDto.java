package com.linewell.license.platform.common.security.facade.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author wusy
 * Company: 南威软件股份有限公司
 * Createtime : 2019-07-16 22:05
 * Description :
 */
@Setter
@Getter
public class UserDto implements Serializable {

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("用户状态")
    private int status;

    @ApiModelProperty("用户密码")
    private String password;

}
