import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileDataTest {

    @Test
    void FileDataTest() {
        ArrayList<String> testData = new ArrayList<>();
        String fileNameTest = "test.ser";
        testData.add("Sverri er bedste Sylas i DK og FO");
        FileData fileData = new FileData(testData,fileNameTest);
        // fileData.saveFile();
        ArrayList<String> testReadData = new ArrayList<>();
        FileData readFileData = new FileData(testReadData, fileNameTest);
        readFileData.readFile();
        assertTrue(testData.equals(testReadData));
        System.out.println(testData);

    }

    @Test
    void readFile() {
    }

    @Test
    void saveFile() {
    }
}