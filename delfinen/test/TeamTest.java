import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

class TeamTest {

    @Test
    void registerResult() {
        Team t = new Team(new ArrayList<>(Arrays.asList(new CompetitiveMember(18,"Bo",new ArrayList<>(Arrays.asList(Discipline.BACKSTROKE))))), null);
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n100\n10\n10\n10\n".getBytes());
        System.setIn(in);
        t.registerResult();
    }

    @Test
    void showTournamentsTest() {
        ArrayList<Tournament> a = new ArrayList<>();
        ArrayList<Discipline> d = new ArrayList<>();
        d.add(Discipline.BACKSTROKE);
        a.add(new Tournament(LocalDateTime.of(2020, 12, 10, 10, 10), d, "swimming class", "Delphin Rd."));

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