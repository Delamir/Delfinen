import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

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

    @Test
    void showTournamentsTest() {
        ArrayList<Tournament> a = new ArrayList<>();
        ArrayList<Discipline> d = new ArrayList<>();
        d.add(Discipline.BACKSTROKE);
        a.add(new Tournament(2020, 12, 10, 10, 10, d, "swimming class", "Delphin Rd."));

        Team s = new Team(null, a);
        s.showTournaments();
    }

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