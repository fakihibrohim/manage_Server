package Manage_Server.enumation;

public enum Status {

    SERVER_UP("SERVER UP"),
    SERVER_DOWN("SERVER DOWN");
    private final String Status;

    Status(String status){
        this.Status = status;
    }

    public String getStatus(){
        return this.Status;
    }
}
