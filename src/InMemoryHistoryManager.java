import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{
    private static HashMap<String,LinkedListNode> watchHistoryHashMap = new HashMap<>();
    private static LinkedListNode lastNode = new LinkedListNode();
    @Override
    public void add(Task task){
        if (watchHistoryHashMap.containsKey(task.taskCode)){
            removeNode(watchHistoryHashMap,task.taskCode);
        }
        linkLast(watchHistoryHashMap,task.taskCode);
    }
    @Override
    public void remove(String id){
        removeNode(watchHistoryHashMap,id);
    }
    void linkLast(HashMap<String,LinkedListNode> linkedListHashMap,String id){
        LinkedListNode newNode = new LinkedListNode();
        newNode.data = id;
        if(lastNode.data != null){
            lastNode.next = newNode;
            newNode.previous = lastNode;
        }
        lastNode = newNode;
        linkedListHashMap.put(id,newNode);
    }
    @Override
    public ArrayList<String> getHistory(){
        ArrayList<String> tasksHistory = new ArrayList<>();
        LinkedListNode currentNode = lastNode;
        for (int i = watchHistoryHashMap.size()-1; i >= 0; i--){
            tasksHistory.add(currentNode.data);
            currentNode = currentNode.previous;
        }
        return tasksHistory;
    }
    void removeNode(HashMap<String,LinkedListNode> linkedListHashMap,String id){
        LinkedListNode removedNode = linkedListHashMap.get(id);
        if (removedNode.previous != null){
            removedNode.previous.next = null;
        }
        linkedListHashMap.remove(id);
    }
}
