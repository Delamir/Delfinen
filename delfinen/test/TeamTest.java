import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

class TeamTest {

    @Test
    void registerResult() {
        Team t = new Team(null, null);
        ByteArrayInputStream in = new ByteArrayInputStream("12\n23\n25\n666\n\n23\n25\n12\n\n23\nki\n".getBytes());
        System.setIn(in);
        t.registerResult();

        System.setIn(in);
        t.registerResult();

        System.setIn(in);
        t.registerResult();

    }
}