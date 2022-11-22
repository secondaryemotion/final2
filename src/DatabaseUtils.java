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

    public <T> HashMap<Integer,T> readDatabase(String path) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream oin = new ObjectInputStream(fis);
        HashMap<Integer,T> database = (HashMap<Integer,T>) oin.readObject();
        oin.close();
        fis.close();
        return database;
    }

}
