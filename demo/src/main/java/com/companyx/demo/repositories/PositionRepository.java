package com.companyx.demo.repositories;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.companyx.demo.models.Position;

@Repository
public interface PositionRepository extends CouchbaseRepository<Position, String> {
    
}
