package server.repository;

import server.model.Server;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServerRepository extends MongoRepository<Server, String> {
	List<Server> findByServerApplicationsLike(String application);
	List<Server> findByServerIPLike(String ip);

}
