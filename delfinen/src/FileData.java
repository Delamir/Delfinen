import java.io.*;
import java.util.ArrayList;

/**
 * A class that handles all the files such as saving and reading files
 * @param <T> is a placeholder, for using different lists
 * @author Sverri & Christian
 */
public class FileData<T> implements Serializable {

    private final String FILE_NAME;
    private final ArrayList<T> SAVE_ALL;

    /**
     * A constructor to create an object with a list and a filename
     * @param SAVE_ALL is the list which is saved to the file
     * @param FILE_NAME is the name of the file
     * @author Christian & Sverri
     */
    public FileData(ArrayList<T> SAVE_ALL, String FILE_NAME) {
        this.SAVE_ALL = SAVE_ALL;
        this.FILE_NAME = FILE_NAME;
    }

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    public ArrayList<T> getSAVE_ALL() {
        return SAVE_ALL;
    }

    /**
     * A method that read a file. If it cannot read the requested filename, it will create a new array list to create
     * the new file with
     * @return a saved file
     * @author Sverri
     */
    public ArrayList<T> readFile() {
        try {
            FileInputStream fileIn = new FileInputStream(FILE_NAME);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            FileData<T> save = (FileData<T>) objIn.readObject();
            objIn.close();
            fileIn.close();
            return save.getSAVE_ALL();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * A method to save files. It prints out a statement that the data is stored in the specific file
     * @author Christian
     */
    public void saveFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this);
            objOut.close();
            fileOut.close();
            System.out.println("Information is now stored in " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
