package server.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import server.model.Server;
import server.repository.ServerRepository;

@RestController
@RequestMapping("/server")
public class ServerController{
	@Autowired
	private ServerRepository serverRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createServer(@RequestBody Map<String, Object> serverMap){
		Server server = new Server(serverMap.get("serverDescription").toString(),
				serverMap.get("serverApplications").toString(),
				serverMap.get("serverStatus").toString(),
				serverMap.get("machineReadableName").toString(),
				serverMap.get("serverIP").toString());

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Server created successfully");
		response.put("server", serverRepository.save(server));

		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value="/{serverId}")
	public Server getServerDetails(@PathVariable("serverId") String serverId){
		return serverRepository.findOne(serverId);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> getAllServers(){
		List<Server> servers = serverRepository.findAll();
		Map<String, Object> response = new LinkedHashMap<String, Object>();

		response.put("totalServers", servers.size());
		response.put("servers", servers);

		return response;
	}

	@RequestMapping(method = RequestMethod.PUT, value="/{serverId}")
	public Map<String, Object> updateServer(@PathVariable("serverId") String serverId,
					@RequestBody Map<String, Object> serverMap){

		Server server = new Server(serverMap.get("serverDescription").toString(),
					serverMap.get("serverApplications").toString(),
					serverMap.get("serverStatus").toString(),
					serverMap.get("machineReadableName").toString(),
					serverMap.get("serverIP").toString());

		server.setServerId(serverId);
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Server updated successfully");
		response.put("server", serverRepository.save(server));

		return response;
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{serverId}")
	public Map<String, String> deleteServer(@PathVariable("serverId") String serverId){
		serverRepository.delete(serverId);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Server deleted successfully");

		return response;
	}
}
