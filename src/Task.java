import java.io.Serializable;

public class Task implements Serializable {

    public String taskName;
    public String taskDescription;
    protected int taskCode;
    protected TaskStatus taskStatus;

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



}
