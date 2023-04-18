import java.io.*;
import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.RandomAccess;

public class InMemoryManager implements TaskManager {

    private static HashMap<String,Task> tasksDatabase;
    private static HashMap<String,EpicTask> epicTasksDatabase;
    private static HashMap<String,SubTask> subTasksDatabase;
    DatabaseUtils databaseUtility = new DatabaseUtils();
    HistoryManager historyManager = new InMemoryHistoryManager();


    @Override
    public void readDatabasesIfExist() {
        tasksDatabase = databaseUtility.readDatabase("data/tasks.out");
        epicTasksDatabase = databaseUtility.readDatabase("data/epicTasks.out");
        subTasksDatabase = databaseUtility.readDatabase("data/subTasks.out");

    }
    @Override
    public void saveDatabases() throws IOException {

        databaseUtility.saveDatabase("data/tasks.out",tasksDatabase);
        databaseUtility.saveDatabase("data/epicTasks.out",epicTasksDatabase);
        databaseUtility.saveDatabase("data/subTasks.out",subTasksDatabase);

    }
    @Override
    public void showAllTasks() { //2.1

        for (String key : tasksDatabase.keySet()) {
            System.out.println(tasksDatabase.get(key).printTask());
        }

    }
    @Override
    public void showAllEpicTasks() { //2.1
        for (String key : epicTasksDatabase.keySet()) {
            System.out.println(epicTasksDatabase.get(key).printEpicTask());
        }
    }
    @Override
    public void showAllSubTasks() { //2.1
        for (String key : subTasksDatabase.keySet()) {
            System.out.println(subTasksDatabase.get(key).printSubTask());
        }

    }
    @Override
    public void removeAllTasks() { //2.2
        tasksDatabase.clear();
    }
    @Override
    public void removeAllEpicTasks() { //2.2
        epicTasksDatabase.clear();
    }
    @Override
    public void removeAllSubTasks() { //2.2
        subTasksDatabase.clear();
    }
    @Override
    public void getTaskByCode(String tempTaskCode) { //2.3
        System.out.println(tasksDatabase.get(tempTaskCode).printTask());
        historyManager.add(tasksDatabase.get(tempTaskCode));

    }
    @Override
    public void getEpicTaskByCode(String tempEpicTaskCode) { //2.3
        System.out.println(epicTasksDatabase.get(tempEpicTaskCode).printEpicTask());
        historyManager.add(epicTasksDatabase.get(tempEpicTaskCode));
    }
    @Override
    public void getSubTaskByCode(String tempSubTaskCode) { //2.3
        System.out.println(subTasksDatabase.get(tempSubTaskCode).printSubTask());
        historyManager.add(subTasksDatabase.get(tempSubTaskCode));
    }
    @Override
    public void removeTaskByCode(String tempTaskCode) { //2.6
        tasksDatabase.remove(tempTaskCode);
        historyManager.remove(tempTaskCode);
    }
    @Override
    public void removeEpicTaskByCode(String tempEpicTaskCode) { //2.6
        epicTasksDatabase.remove(tempEpicTaskCode);
        historyManager.remove(tempEpicTaskCode);
    }
    @Override
    public void removeSubTaskByCode(String tempSubTaskCode) { //2.6
        subTasksDatabase.remove(tempSubTaskCode);
        historyManager.remove(tempSubTaskCode);
    }
    @Override
    public void createNewTask(Task newTask) { //2.4
        tasksDatabase.put(newTask.taskCode,newTask);
    }
    @Override
    public void createNewEpicTask(EpicTask newEpicTask) { //2.4
        epicTasksDatabase.put(newEpicTask.taskCode,newEpicTask);
    }
    @Override
    public void createNewSubTask(SubTask newSubTask) { //2.4
        subTasksDatabase.put(newSubTask.taskCode,newSubTask);
    }
    @Override
    public void updateExistingTask(String updatedTaskCode, Task updatedTask) { //2.5
        tasksDatabase.replace(updatedTaskCode,updatedTask);
    }
    @Override
    public void updateExistingEpicTask(String updatedEpicTaskCode, EpicTask updatedEpicTask) { //2.5
        epicTasksDatabase.replace(updatedEpicTaskCode,updatedEpicTask);
    }
    @Override
    public void updateExistingSubTask(String updatedSubTaskCode, SubTask updatedSubTask) { //2.5
        subTasksDatabase.replace(updatedSubTaskCode,updatedSubTask);
    }
    @Override
    public String showEpicTaskSubTasks(String epicTaskCode) { //3.1
        return epicTasksDatabase.get(epicTaskCode).printEpicTaskSubTasks(subTasksDatabase);
    }
    @Override
    public void addSubTaskCodeToEpic(String epicTaskCode,String subTaskCode){
        epicTasksDatabase.get(epicTaskCode).addSubTaskCode(subTaskCode);
        subTasksDatabase.get(subTaskCode).setEpicTaskCode(epicTaskCode);
        epicTasksDatabase.get(epicTaskCode).checkEpicTaskStatus(subTasksDatabase);
    }

    public ArrayList<String> getHistory(){
        return historyManager.getHistory();
    }




}
