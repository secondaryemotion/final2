import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EpicTask extends Task {

    public ArrayList<Integer> subTasksCodes = new ArrayList<>();

    public void addSubTaskCode(int taskCode) {
        if (taskCode < Manager.newTaskCode) {
            this.subTasksCodes.add(taskCode);
            this.checkEpicTaskStatus();
            Manager.subTasksDatabase.get(taskCode).forceEpicTaskCode(this.taskCode);
        }
    }

    public void forceSubTaskCode(int taskCode) {
        this.subTasksCodes.add(taskCode);
    }

    public String printEpicTask() {
        String epicTaskPrinted = this.printTask() + "\n Sub-tasks ids: ";

        for (int i = 0; i < this.subTasksCodes.toArray().length; i++) {
            epicTaskPrinted += this.subTasksCodes.get(i);
        }

        return epicTaskPrinted;
    }

    public String printEpicTaskSubTasks() {
        String subTasksPrinted = "List of subtasks: \n";
        for (int i = 0; i < this.subTasksCodes.toArray().length; i++) {
            subTasksPrinted += Manager.subTasksDatabase.get(this.subTasksCodes.get(i)).printTask() + " \n";
        }
        return subTasksPrinted;
    }

    public void checkEpicTaskStatus() {
        int status = 1;
        for (Object o : this.subTasksCodes.toArray()) {
            if (Manager.subTasksDatabase.get(o).getNumericalTaskStatus() == 0) {
                status = 0;
                break;
            } else {
                status += Manager.subTasksDatabase.get(o).getNumericalTaskStatus();
            }
        }
        if (status == this.subTasksCodes.toArray().length) {
            this.taskStatus.changeNumericalTaskStatus(1);
        } else if (status != 0) {
            this.taskStatus.changeNumericalTaskStatus(2);
        } else {
            this.taskStatus.changeNumericalTaskStatus(0);
        }
    }
}
