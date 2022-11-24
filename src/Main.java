import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) throws IOException, ClassNotFoundException {
        Manager manager = new Manager();
        manager.readDatabasesIfExist();
        Task testTask = new Task();
        testTask.setTaskName("Task " + (Manager.newTaskCode - 1));
        testTask.setTaskStatus("IN_PROGRESS");
        testTask.setTaskDescription("Just do this plz");

        EpicTask testEpicTask = new EpicTask();
        testEpicTask.setTaskName("Epic " + (Manager.newTaskCode - 1));
        testEpicTask.setTaskStatus("NEW");
        testEpicTask.setTaskDescription("epic task 1");

        SubTask testSubTask = new SubTask();
        testSubTask.setTaskName("Sub " + (Manager.newTaskCode - 1));
        testSubTask.setTaskStatus("IN_PROGRESS");
        testSubTask.setTaskDescription("sub task 1");

        manager.createNewTask(testTask);
        manager.createNewEpicTask(testEpicTask);
        manager.createNewSubTask(testSubTask);
        manager.showAllTasks();
        manager.showAllEpicTasks();

        testEpicTask.addSubTaskCode(testSubTask.taskCode);
        manager.showAllTasks();
        manager.showAllEpicTasks();
        manager.showAllSubTasks();

        manager.saveDatabases();
    }



}
