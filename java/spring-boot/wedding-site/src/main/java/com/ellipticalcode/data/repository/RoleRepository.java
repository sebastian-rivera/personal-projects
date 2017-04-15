package com.ellipticalcode.data.repository;

import com.ellipticalcode.data.entity.role.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by crono on 1/22/2017.
 */
public interface RoleRepository extends MongoRepository<Role, String> {

}
