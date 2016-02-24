package server.repository;

import server.model.Server;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServerRepository extends MongoRepository<Server, String> {

}
