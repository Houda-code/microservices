package com.microservices.anime;

import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AnimeRepository extends MongoRepository<Anime,String> {
}
