package delfinen;

import delfinen.Discipline;
import delfinen.Result;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

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