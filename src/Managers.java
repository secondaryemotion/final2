public class Managers {
    TaskManager getDefault(){
        return new InMemoryManager();
    }

    HistoryManager getDefaultHistory(){
        return new InMemoryHistoryManager();
    }
}
