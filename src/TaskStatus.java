import java.util.Arrays;
import java.util.List;
import java.io.Serializable;


public class TaskStatus implements Serializable{

    private int taskStatus;
    private final List<String> possibleTaskStatuses = Arrays.asList("IN_PROGRESS", "NEW", "DONE");


    public void changeTaskStatus(String status) {
        if (possibleTaskStatuses.contains(status)) {
                this.taskStatus = possibleTaskStatuses.indexOf(status);
        } else {
            System.out.println("пошел нахуй переделывай");
        }
    }

    public void changeNumericalTaskStatus(int status){
        if (status >= 0 && status <= 2){
            this.taskStatus = status;
        }
    }

    public String getTaskStatus() {
        String status =  possibleTaskStatuses.get(this.taskStatus);
        return status;
    }

    public int getNumericalTaskStatus() {
        return this.taskStatus;
    }

}
