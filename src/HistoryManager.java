import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface HistoryManager {
    void add(Task task);
    void remove(String id);

    ArrayList<String> getHistory();

}
