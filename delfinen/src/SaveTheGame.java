import java.io.*;
import java.util.ArrayList;

public class SaveTheGame {

    private String fileName;
    ArrayList<Member> memberList;

    public SaveTheGame(String fileName, ArrayList<Member> memberList) {
        this.fileName = fileName;
        this.memberList = memberList;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public ArrayList<Member> readFile() {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            SaveTheGame saveTheGame = (SaveTheGame) objIn.readObject();
            objIn.close();
            fileIn.close();
            return saveTheGame.memberList;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
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
