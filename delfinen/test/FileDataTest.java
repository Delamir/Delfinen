import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileDataTest {

    /**
     * @author Sverri og Patrick
     */
    @BeforeAll
    static void before() {
        File f = new File("test.ser");
        f.delete();
    }

    @Test
    void fileDataTest() {
        ArrayList<String> testData = new ArrayList<>();
        String fileNameTest = "test.ser";
        testData.add("Sverri er bedste Sylas i DK og FO");
        FileData<String> fileData = new FileData<>(testData,fileNameTest);
        fileData.saveFile();
        ArrayList<String> testReadData = new ArrayList<>();
        FileData<String> readFileData = new FileData<>(testReadData, fileNameTest);
        testReadData = readFileData.readFile();
        assertEquals(testReadData, testData);
    }
}