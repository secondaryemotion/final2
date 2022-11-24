import java.io.*;
import java.util.HashMap;
@SuppressWarnings("unchecked")

public class DatabaseUtils {

    public <T> void saveDatabase(String path, HashMap<Integer,T> database) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(database);
        oos.flush();
        oos.close();
    }

    public <T> HashMap<Integer,T> readDatabase(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream oin = new ObjectInputStream(fis);
            HashMap<Integer,T> database = (HashMap<Integer,T>) oin.readObject();
            oin.close();
            fis.close();
            return database;
        } catch (Exception e) {
            return new HashMap<Integer,T>();
        }
    }

    public int readTaskCode(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream oin = new ObjectInputStream(fis);
            int taskCode = (int) oin.readObject();
            oin.close();
            fis.close();
            return taskCode;
        } catch (Exception e){
            return 0;
        }
    }

    public void saveTaskCode(String path, int taskCode) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(taskCode);
        oos.flush();
        oos.close();
    }

}
