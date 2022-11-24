public class SubTask extends Task {

    protected int epicTaskCode;

    public void setEpicTaskCode(int taskCode) {
        if (taskCode < Manager.newTaskCode) {
            this.epicTaskCode = taskCode;
            Manager.epicTasksDatabase.get(taskCode).forceSubTaskCode(this.taskCode);
            Manager.epicTasksDatabase.get(taskCode).checkEpicTaskStatus();
        }
    }

    public void forceEpicTaskCode(int taskCode) {
        this.epicTaskCode = taskCode;
    }

    public int getEpicTaskCode() {
        return this.epicTaskCode;
    }

    public String printSubTask() {
        return this.printTask() + "\n Epic code: " + this.getEpicTaskCode();
    }

    public String getTaskStatus() {
        return this.taskStatus.getTaskStatus();
    }

    public int getNumericalTaskStatus() {
        return this.taskStatus.getNumericalTaskStatus();
    }
}
