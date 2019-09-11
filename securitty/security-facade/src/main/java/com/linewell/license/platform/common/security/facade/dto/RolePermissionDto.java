package com.linewell.license.platform.common.security.facade.dto;

import com.linewell.license.platform.security.facade.dto.GrantedAuthorityDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.Set;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-12
 * Time 14:57
 */
@Setter
@Getter
@ToString
public class RolePermissionDto extends GrantedAuthorityDto {
    public String url;
    public Set<Integer> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePermissionDto that = (RolePermissionDto) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, roles);
    }
}
