package com.ellipticalcode.data.repository;

import com.ellipticalcode.data.entity.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by crono on 1/7/2017.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUserName(String userName);

    Long countById();

}
