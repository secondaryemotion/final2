import java.io.*;
import java.util.HashMap;

public class Manager {

    public static int newTaskCode = 1;
    public HashMap<Integer,Task> tasksDatabase;
    public HashMap<Integer,EpicTask> epicTasksDatabase;
    public HashMap<Integer,SubTask> subTasksDatabase;
    DatabaseUtils databaseUtility = new DatabaseUtils();

    public void readDatabasesIfExist() throws IOException, ClassNotFoundException {

        tasksDatabase = databaseUtility.readDatabase("/data/tasks.out");
        epicTasksDatabase = databaseUtility.readDatabase("/data/epicTasks.out");
        subTasksDatabase = databaseUtility.readDatabase("/data/subTasks.out");

    }

    public void saveDatabases() throws IOException {

        databaseUtility.saveDatabase("/data/tasks.out",tasksDatabase);
        databaseUtility.saveDatabase("/data/epicTasks.out",epicTasksDatabase);
        databaseUtility.saveDatabase("/data/subTasks.out",subTasksDatabase);

    }



    public void showAllTasks() { //2.1

    }

    public void showAllEpicTasks() { //2.1

    }

    public void showAllSubTasks() { //2.1

    }

    public void removeAllTasks() { //2.2

    }

    public void removeAllEpicTasks() { //2.2

    }

    public void removeAllSubTasks() { //2.2

    }

    public void getTaskByCode(int taskCode) { //2.3

    }

    public void removeTaskByCode(int taskCode) { //2.6

    }

    public void createNewTask(Task newTask) { //2.4

    }

    public void createNewEpicTask(EpicTask newEpicTask) { //2.4

    }

    public void createNewSubTask(SubTask newSubTask) { //2.4

    }

    public void editExistingTask(int taskCode) { //2.5

    }

    public void showEpicTaskSubTasks(int epicTaskCode) { //3.1

    }


}
