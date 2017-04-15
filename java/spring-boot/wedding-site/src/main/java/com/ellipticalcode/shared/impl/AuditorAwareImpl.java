package com.ellipticalcode.shared.impl;

import com.ellipticalcode.data.entity.user.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by crono on 1/22/2017.
 */

public class AuditorAwareImpl implements AuditorAware<User> {

    @Override
    public User getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        return	((UserDetailsImpl)authentication.getPrincipal()).getUser();

    }
}
