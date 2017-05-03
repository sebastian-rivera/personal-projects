package com.ellipticalcode.data.repository;

import com.ellipticalcode.data.entity.rsvp.Rsvp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by crono on 4/16/2017.
 */
@Repository
public interface RsvpRepository extends MongoRepository<Rsvp, String> {
}
