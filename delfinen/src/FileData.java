import java.io.*;
import java.util.ArrayList;

public class FileData implements Serializable {

    private String fileName;
    private ArrayList saveAll;

    public FileData(ArrayList saveAll, String fileName) {
        this.saveAll = saveAll;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public ArrayList getSaveAll() {
        return saveAll;
    }

    public static ArrayList readFile(String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            FileData save = (FileData) objIn.readObject();
            objIn.close();
            fileIn.close();
            return save.getSaveAll();
        } catch (FileNotFoundException e) {
            return new ArrayList();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveFile(FileData save) {
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
