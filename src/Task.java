import java.io.Serializable;

public class Task implements Serializable {

    public String taskName;
    public String taskDescription;
    protected int taskCode;
    protected TaskStatus taskStatus = new TaskStatus();

    Task(){
        this.taskCode = Manager.newTaskCode;
        Manager.newTaskCode += 1;
    }

    public void setTaskName(String name) {
        this.taskName = name;
    }

    public void setTaskDescription(String description) {
        this.taskDescription = description;
    }

    public void setTaskStatus(String status) {
        this.taskStatus.changeTaskStatus(status);
    }

    public String printTask() {
        return String.format("Code: %s \n Name: %s \n Description: %s \n Status: %s",this.taskCode,this.taskName,this.taskDescription,this.taskStatus.getNumericalTaskStatus());
    }


}
