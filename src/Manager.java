import java.io.*;
import java.util.HashMap;

public class Manager {

    public static int newTaskCode;
    public static HashMap<Integer,Task> tasksDatabase;
    public static HashMap<Integer,EpicTask> epicTasksDatabase;
    public static HashMap<Integer,SubTask> subTasksDatabase;
    DatabaseUtils databaseUtility = new DatabaseUtils();

    public void readDatabasesIfExist() throws IOException, ClassNotFoundException {

        tasksDatabase = databaseUtility.readDatabase("data/tasks.out");
        epicTasksDatabase = databaseUtility.readDatabase("data/epicTasks.out");
        subTasksDatabase = databaseUtility.readDatabase("data/subTasks.out");
        newTaskCode = databaseUtility.readTaskCode("data/taskCode.out");

    }

    public void saveDatabases() throws IOException {

        databaseUtility.saveDatabase("data/tasks.out",tasksDatabase);
        databaseUtility.saveDatabase("data/epicTasks.out",epicTasksDatabase);
        databaseUtility.saveDatabase("data/subTasks.out",subTasksDatabase);
        databaseUtility.saveTaskCode("data/taskCode.out",newTaskCode);

    }

    public void showAllTasks() { //2.1

        for (int key : tasksDatabase.keySet()) {
            System.out.println(tasksDatabase.get(key).printTask());
        }

    }

    public void showAllEpicTasks() { //2.1
        for (int key : epicTasksDatabase.keySet()) {
            System.out.println(epicTasksDatabase.get(key).printEpicTask());
        }
    }

    public void showAllSubTasks() { //2.1
        for (int key : subTasksDatabase.keySet()) {
            System.out.println(subTasksDatabase.get(key).printSubTask());
        }

    }

    public void removeAllTasks() { //2.2
        tasksDatabase.clear();
    }

    public void removeAllEpicTasks() { //2.2
        epicTasksDatabase.clear();
    }

    public void removeAllSubTasks() { //2.2
        subTasksDatabase.clear();
    }

    public void getTaskByCode(int tempTaskCode) { //2.3
        System.out.println(tasksDatabase.get(tempTaskCode).printTask());
    }

    public void getEpicTaskByCode(int tempEpicTaskCode) { //2.3
        System.out.println(epicTasksDatabase.get(tempEpicTaskCode).printEpicTask());
    }

    public void getSubTaskByCode(int tempSubTaskCode) { //2.3
        System.out.println(subTasksDatabase.get(tempSubTaskCode).printSubTask());
    }

    public void removeTaskByCode(int tempTaskCode) { //2.6
        tasksDatabase.remove(tempTaskCode);
    }

    public void removeEpicTaskByCode(int tempEpicTaskCode) { //2.6
        epicTasksDatabase.remove(tempEpicTaskCode);
    }

    public void removeSubTaskByCode(int tempSubTaskCode) { //2.6
        subTasksDatabase.remove(tempSubTaskCode);
    }

    public void createNewTask(Task newTask) { //2.4
        tasksDatabase.put(newTask.taskCode,newTask);
    }

    public void createNewEpicTask(EpicTask newEpicTask) { //2.4
        epicTasksDatabase.put(newEpicTask.taskCode,newEpicTask);
    }

    public void createNewSubTask(SubTask newSubTask) { //2.4
        subTasksDatabase.put(newSubTask.taskCode,newSubTask);
    }

    public void updateExistingTask(int updatedTaskCode, Task updatedTask) { //2.5
        tasksDatabase.replace(updatedTaskCode,updatedTask);
    }

    public void updateExistingEpicTask(int updatedEpicTaskCode, EpicTask updatedEpicTask) { //2.5
        epicTasksDatabase.replace(updatedEpicTaskCode,updatedEpicTask);
    }

    public void updateExistingSubTask(int updatedSubTaskCode, SubTask updatedSubTask) { //2.5
        subTasksDatabase.replace(updatedSubTaskCode,updatedSubTask);
    }

    public String showEpicTaskSubTasks(int epicTaskCode) { //3.1
        return epicTasksDatabase.get(epicTaskCode).printEpicTaskSubTasks();
    }



}
