package delfinen;

import delfinen.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    /**
     * @author Christian
     */
    @Test
    void registerResult() {
        CompetitiveMember m = new CompetitiveMember(18,"Bo",new ArrayList<>(Collections.singletonList(Discipline.BACKSTROKE)));
        Team t = new Team(new ArrayList<>(Collections.singletonList(m)), null);

        ScannerMethods.setIn("1\n1\n100\n10\n10\n10\n");

        t.registerResult();

        Result r = new Result(Discipline.BACKSTROKE, 10, 10, 10, 100, m);

        assertEquals(r.getCm(),m.getResults().get(0).getCm());
        assertEquals(r.getDisp(),m.getResults().get(0).getDisp());
        assertEquals(r.getDist(),m.getResults().get(0).getDist());
        assertEquals(r.getMilli(),m.getResults().get(0).getMilli());

    }

    /**
     * @author Joachim
     */
    @Test
    void showTournamentsTest() {
        ArrayList<Tournament> a = new ArrayList<>();
        ArrayList<Discipline> d = new ArrayList<>();
        d.add(Discipline.BACKSTROKE);
        a.add(new Tournament(LocalDateTime.of(2020, 12, 10, 10, 10), d, "swimming class", "Delphin Rd."));

        Team s = new Team(null, a);
        s.showTournaments();
    }

    /**
     * @author Joachim
     */
    @Test
    void showMemberListTest() {
        ArrayList<CompetitiveMember> c = new ArrayList<>();
        ArrayList<Discipline> d = new ArrayList<>();
        ArrayList<Result> r = new ArrayList<>();
        d.add(Discipline.FREESTYLE);
        c.add(new CompetitiveMember(20, "Sverri", d));
        r.add(new Result(Discipline.FREESTYLE, 10, 20, 25, 350, null));

        Team s = new Team(c, null);
        s.showMemberList();
    }
}