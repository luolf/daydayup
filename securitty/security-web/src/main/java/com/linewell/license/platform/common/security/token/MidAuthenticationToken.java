package com.linewell.license.platform.common.security.token;

import com.linewell.license.platform.common.security.bean.MidLoginInfoBo;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.Collection;

/**
 * spring security内的手机、短信验证码的身份令牌
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-14
 * Time 16:52
 */

public class MidAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final Object principal;
    private String credentials;

    public MidAuthenticationToken(Object principal, String credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(false);
    }

    public MidAuthenticationToken(Object principal, String credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
    }


    @Override
    public String getCredentials() {
        return this.credentials;
    }
    @Override
    public Object getPrincipal() {
        return this.principal;
    }
    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }

        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        credentials = null;
    }
    @Override
    public String getName() {
        if (principal instanceof MidLoginInfoBo) {
            MidLoginInfoBo midLoginInfoBo = (MidLoginInfoBo)this.getPrincipal();
            return midLoginInfoBo.getAccount();
        }
        if (this.getPrincipal() instanceof UserDetails) {
            return ((UserDetails)this.getPrincipal()).getUsername();
        } else if (this.getPrincipal() instanceof AuthenticatedPrincipal) {
            return ((AuthenticatedPrincipal)this.getPrincipal()).getName();
        } else if (this.getPrincipal() instanceof Principal) {
            return ((Principal)this.getPrincipal()).getName();
        } else {
            return this.getPrincipal() == null ? "" : this.getPrincipal().toString();
        }

    }
}
