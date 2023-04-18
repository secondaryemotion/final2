import java.io.IOException;

public class Main {

    public static void main(String [] args) throws IOException {
        InMemoryManager manager = new InMemoryManager();
        manager.readDatabasesIfExist();
        Task testTask = new Task();
        testTask.setTaskName("Task ");
        testTask.setTaskStatus("IN_PROGRESS");
        testTask.setTaskDescription("Just do this plz");

        EpicTask testEpicTask = new EpicTask();
        testEpicTask.setTaskName("Epic " );
        testEpicTask.setTaskStatus("NEW");
        testEpicTask.setTaskDescription("epic task 1");

        SubTask testSubTask = new SubTask();
        testSubTask.setTaskName("Sub ");
        testSubTask.setTaskStatus("IN_PROGRESS");
        testSubTask.setTaskDescription("sub task 1");

        manager.createNewTask(testTask);
        manager.createNewEpicTask(testEpicTask);
        manager.createNewSubTask(testSubTask);
        manager.showAllTasks();
        manager.showAllEpicTasks();

        manager.addSubTaskCodeToEpic(testEpicTask.taskCode,testSubTask.taskCode);
        manager.getSubTaskByCode("bd14c85a-25f9-4e2d-a570-ece019d2d022");
        manager.getEpicTaskByCode("dfbde9ff-a2b0-4008-8ffb-0e1addb1d876");
        manager.getTaskByCode("6b77d0bc-213c-426d-a1e5-14f273c8210b");
        System.out.println(manager.getHistory().toString());
        manager.getSubTaskByCode("bd14c85a-25f9-4e2d-a570-ece019d2d022");
        System.out.println(manager.getHistory().toString());


        manager.saveDatabases();
    }



}
