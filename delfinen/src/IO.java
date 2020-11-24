import java.io.*;

public class IO {

    private String fileName;

    public IO(String fileName) {
        this.fileName = fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public IO readFile() {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            IO IO = (IO) objIn.readObject();
            objIn.close();
            fileIn.close();
            return IO;
        } catch (FileNotFoundException e) {
            return new IO(fileName) ;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(fileName);
            objOut.close();
            fileOut.close();
            System.out.println("Information is now stored in " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
