package server;

public class Server {

    private long serverId;
    private String serverMachineReadableName;
    private String serverDescription;
    private String serverApplications;
    private String serverStatus;

    public Server(long serverId, String serverMachineReadableName, String serverDescription, String serverApplications, String serverStatus) {
        this.serverId = serverId;
        this.serverMachineReadableName = serverMachineReadableName;
	this.serverDescription = serverDescription;
	this.serverApplications = serverApplications;
	this.serverStatus = serverStatus;
    }

    public long getServerId(){
        return serverId;
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
