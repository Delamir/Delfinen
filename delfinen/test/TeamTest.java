import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void registerResult() {
        Team t = new Team();
        ByteArrayInputStream in = new ByteArrayInputStream("12\n34\n25\n".getBytes());
        t.registerResult();
        System.
    }
}