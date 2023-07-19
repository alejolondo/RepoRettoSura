package com.example.backendretosura.repositories;

import com.example.backendretosura.models.Signal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignalRepository extends MongoRepository<Signal, String> {

}
