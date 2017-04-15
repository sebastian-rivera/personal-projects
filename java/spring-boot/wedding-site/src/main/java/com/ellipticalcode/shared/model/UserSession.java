package com.ellipticalcode.shared.model;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.io.Serializable;

/**
 * Created by Sebastian Rivera on 1/22/2017.
 */
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession implements Serializable {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
