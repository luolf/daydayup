package com.linewell.license.platform.security.facade.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author wusy
 * Company: 南威软件股份有限公司
 * Createtime : 2019/8/22 15:32
 * Description : 用户角色信息
 */
@Setter
@Getter
public class UserRoleDto {
    /**
     * 用户角色id
     */
    private Long roleId;
    /**
     * 用户角色名称
     */
    private String roleName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleDto that = (UserRoleDto) o;
        return Objects.equals(roleId, that.roleId) &&
                Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName);
    }
}
