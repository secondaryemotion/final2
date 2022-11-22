import java.util.Arrays;
import java.util.List;

public class TaskStatus {

    private int taskStatus;
    private final List<String> possibleTaskStatuses = Arrays.asList("NEW", "IN_PROGRESS", "DONE");

    public void changeTaskStatus(String status) {
        if (possibleTaskStatuses.contains(status)) {
                this.taskStatus = possibleTaskStatuses.indexOf(status);
        } else {
            System.out.println("пошел нахуй переделывай");
        }
    }

    public String getTaskStatus() {
        String status =  possibleTaskStatuses.get(this.taskStatus);
        return status;
    }

}
