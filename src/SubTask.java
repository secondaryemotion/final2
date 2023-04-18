public class SubTask extends Task {

    protected String epicTaskCode;


    public void setEpicTaskCode(String taskCode) {
        this.epicTaskCode = taskCode;
    }

    public String getEpicTaskCode() {
        return this.epicTaskCode;
    }

    public String printSubTask() {
        return this.printTask() + "\n Epic code: " + this.getEpicTaskCode();
    }

    public TaskStatus getTaskStatus() {
        return this.taskStatus;
    }

}
