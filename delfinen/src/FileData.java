import java.io.*;
import java.util.ArrayList;

public class FileData<T> implements Serializable {

    private String fileName;
    private ArrayList<T> saveAll;

    public FileData(ArrayList<T> saveAll, String fileName) {
        this.saveAll = saveAll;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public ArrayList<T> getSaveAll() {
        return saveAll;
    }

    public ArrayList<T> readFile() {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            FileData<T> save = (FileData<T>) objIn.readObject();
            objIn.close();
            fileIn.close();
            return save.getSaveAll();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveFile(FileData<T> save) {
        try {
            FileOutputStream fileOut = new FileOutputStream(save.getFileName());
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(save);
            objOut.close();
            fileOut.close();
            System.out.println("Information is now stored in " + save.getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
