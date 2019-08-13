package com.linewell.license.platform.common.security.author;

import com.linewell.license.platform.common.security.facade.api.UserDetailsFacade;
import com.linewell.license.platform.common.security.facade.dto.RolePermissionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-12
 * Time 14:42
 */
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    UserDetailsFacade userDetailsFacade;

    AntPathMatcher antPathMatcher = new AntPathMatcher();
    /**
     * 查询访问url需要具备的角色
     * @return 返回值说明
     * @param o 参数说明
     * @author luolifeng
     * Date  2019/8/12
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) {

        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        System.out.println(requestUrl);
        List<RolePermissionDto> allPermissions = userDetailsFacade.findAllPermissions();
        for (RolePermissionDto permissionDto : allPermissions) {
            if (antPathMatcher.match(permissionDto.getUrl(), requestUrl)
                    &&permissionDto.getRoles().size()>0) {
                List<Integer> roleIds = permissionDto.getRoles();
                int size = roleIds.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roleIds.get(i).toString();
                }
                return SecurityConfig.createList(values);
            }
        }

        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}