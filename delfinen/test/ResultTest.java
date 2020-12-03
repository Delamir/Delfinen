import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void compareTo() {

        Result r1 = new Result(Discipline.DROWNING, 1, 35, 12, 50, null);
        Result r2 = new Result(Discipline.DROWNING, 2, 0, 50, 50, null);
        ArrayList<Result> results = new ArrayList<>();
        results.add(r2);
        results.add(r1);
        Collections.sort(results);
        assertEquals(r1, results.get(0));

    }
}