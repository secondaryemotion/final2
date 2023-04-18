import java.io.IOException;

public interface TaskManager {


    void readDatabasesIfExist();

    void saveDatabases() throws IOException;

    void showAllTasks();

    void showAllEpicTasks();

    void showAllSubTasks();

    void removeAllTasks();

    void removeAllEpicTasks();

    void removeAllSubTasks();

    void getTaskByCode(String tempTaskCode);

    void getEpicTaskByCode(String tempEpicTaskCode);

    void getSubTaskByCode(String tempSubTaskCode);

    void removeTaskByCode(String tempTaskCode);

    void removeEpicTaskByCode(String tempEpicTaskCode);

    void removeSubTaskByCode(String tempSubTaskCode);

    void createNewTask(Task newTask);

    void createNewEpicTask(EpicTask newEpicTask);

    void createNewSubTask(SubTask newSubTask);

    void updateExistingTask(String updatedTaskCode, Task updatedTask);

    void updateExistingEpicTask(String updatedEpicTaskCode, EpicTask updatedEpicTask);

    void updateExistingSubTask(String updatedSubTaskCode, SubTask updatedSubTask);
    String showEpicTaskSubTasks(String epicTaskCode);

    void addSubTaskCodeToEpic(String epicTaskCode,String subTaskCode);

}
