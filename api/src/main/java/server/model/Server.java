package server.model;

import org.springframework.data.annotation.Id;

public class Server {

    @Id
    private String serverId;
    private String serverMachineReadableName;
    private String serverDescription;
    private String serverApplications;
    private String serverStatus;
    private String serverIP;

    public Server() {};

    public Server(String serverDescription, String serverApplications, String serverStatus, String serverMachineReadableName, String serverIP) {
        this.serverMachineReadableName = serverMachineReadableName;
        this.serverDescription = serverDescription;
        this.serverApplications = serverApplications;
        this.serverStatus = serverStatus;
	this.serverIP = serverIP;
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

    public String getServerIP(){
	return serverIP;
    }

    public void setServerIP(){
	this.serverIP = serverIP;
    }

}
