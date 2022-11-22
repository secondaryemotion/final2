import java.util.List;

public class EpicTask extends Task {

    public List<Integer> subTasksCodes;

    public void addSubTaskCode(int taskCode) {
        if (taskCode < Manager.newTaskCode) {
            subTasksCodes.add(taskCode);
        }
    }

}
