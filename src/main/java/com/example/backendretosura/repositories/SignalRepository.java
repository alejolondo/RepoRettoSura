package com.example.backendretosura.repositories;

import com.example.backendretosura.models.Signal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignalRepository extends MongoRepository<Signal, String> {

    List<Signal> findByTitleContains(String title);

}
