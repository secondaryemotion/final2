import java.util.ArrayList;
import java.util.HashMap;

public class EpicTask extends Task {

    public ArrayList<String> subTasksCodes = new ArrayList<>();

    public void addSubTaskCode(String taskCode){
        this.subTasksCodes.add(taskCode);
    }

    public String printEpicTask() {
        String epicTaskPrinted = this.printTask() + "\n Sub-tasks ids: ";

        for (int i = 0; i < this.subTasksCodes.toArray().length; i++) {
            epicTaskPrinted += this.subTasksCodes.get(i);
        }

        return epicTaskPrinted;
    }

    public String printEpicTaskSubTasks(HashMap<String,SubTask> subTasks) {
        String subTasksPrinted = "List of subtasks: \n";
        for (String i : this.subTasksCodes) {
            subTasksPrinted += subTasks.get(i).printTask() + " \n";
        }
        return subTasksPrinted;
    }

    public void checkEpicTaskStatus(HashMap<String,SubTask> subTasks) {
        int counter = 0;
        for (String i : this.subTasksCodes) {
            if (subTasks.get(i).taskStatus == TaskStatus.IN_PROGRESS) {
                this.setTaskStatus("IN_PROGRESS");
                break;
            } else if (subTasks.get(i).taskStatus == TaskStatus.NEW) {
                counter += 1;
            } else {
                counter -= 1;
            }
        }
        if (counter == this.subTasksCodes.size()){
            this.setTaskStatus("NEW");
        } else if (-1*counter == this.subTasksCodes.size()){
            this.setTaskStatus("DONE");
        } else {
            this.setTaskStatus("IN_PROGRESS");
        }
    }
    }

