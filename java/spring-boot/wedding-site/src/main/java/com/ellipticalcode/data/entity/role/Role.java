package com.ellipticalcode.data.entity.role;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by crono on 1/6/2017.
 */
@Document(collection = "role")
public class Role {

    @Id
    private String id;

    @Indexed(unique = true)
    private String roleName;

    public String getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
