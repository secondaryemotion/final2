import java.io.Serializable;

public class Task implements Serializable {

    public String taskName;
    public String taskDescription;
    protected String taskCode;
    protected TaskStatus taskStatus;

    Task(){
        this.taskCode = java.util.UUID.randomUUID().toString();

    }

    public void setTaskName(String name) {
        this.taskName = name;
    }

    public void setTaskDescription(String description) {
        this.taskDescription = description;
    }


    public String printTask() {
        return String.format("Code: %s \n Name: %s \n Description: %s \n Status: %s",this.taskCode,this.taskName,this.taskDescription,this.taskStatus);
    }

    public void setTaskStatus(String status){
        this.taskStatus = TaskStatus.valueOf(status);
    }
}
