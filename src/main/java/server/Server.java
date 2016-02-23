package server;

import org.springframework.data.annotation.Id;

public class Server {

    @Id
    private String serverId;
    private String serverMachineReadableName;
    private String serverDescription;
    private String serverApplications;
    private String serverStatus;

    public Server() {};

    public Server(String serverDescription, String serverApplications, String serverStatus, String serverMachineReadableName) {
        this.serverMachineReadableName = serverMachineReadableName;
        this.serverDescription = serverDescription;
        this.serverApplications = serverApplications;
        this.serverStatus = serverStatus;
    }

    public String getServerId(){
        return serverId;
    }

    public void setServerId(String serverId){
	this.serverId = serverId;
    }

    public String getMachineReadableName(){
        return serverMachineReadableName;
    }

    public void setMachineReadableName(String serverMachineReadableName){
	this.serverMachineReadableName = serverMachineReadableName;
    }

    public String getServerDescription(){
	return serverDescription;
    }

    public void setServerDescription(String serverDescription){
	this.serverDescription = serverDescription;
    }

    public String getServerApplications(){
	return serverApplications;
    }

    public void setServerApplications(String serverApplications){
	this.serverApplications = serverApplications;
    }

    public String getServerStatus(){
	return serverStatus;
    }

    public void setServerStatus(String serverStatus){
	this.serverStatus = serverStatus;
    }

}
