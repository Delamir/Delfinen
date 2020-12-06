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

        Result r = new Result(Discipline.BACKSTROKE, 10, 10, 10, m);

        assertEquals(r.getCm(), m.getResults().get(0).getCm());
        assertEquals(r.getDisp(), m.getResults().get(0).getDisp());
        assertEquals(r.getDist(), m.getResults().get(0).getDist());
        assertEquals(r.getMilli(), m.getResults().get(0).getMilli());

    }

    /**
     * @author Sverri og Joachim
     */

    @Test
    void registerTournamentTest() {
        ArrayList<Discipline> d = new ArrayList<>();
        d.add(Discipline.FREESTYLE);

        Team team = new Team(new ArrayList<>(), new ArrayList<>());

        ScannerMethods.setIn("1\n6\nAssdaq\nBurmeistersgade 5, 1429 KBH K\n2021\n02\n29\n28\n10\n2\n");
        team.registerTournament();

        Tournament t = new Tournament(null, d, "Assdaq", "Burmeistersgade 5, 1429 KBH K");

        assertEquals(t.getAddress(), team.getTournamentList().get(0).getAddress());
        assertEquals(t.getName(), team.getTournamentList().get(0).getName());
        assertEquals(t.getDisciplines().get(0), team.getTournamentList().get(0).getDisciplines().get(0));
    }

    /**
     * Sverri og Joachim
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
        r.add(new Result(Discipline.FREESTYLE, 10, 20, 25, null));

        Team s = new Team(c, null);
        s.showMemberList();
    }

    /**
     * @author Joachim
     */
    @Test
    void appointParticipantTest() {
        ArrayList<CompetitiveMember> c = new ArrayList<>();
        ArrayList<Discipline> d = new ArrayList<>();
        ArrayList<Tournament> t = new ArrayList<>();

        d.add(Discipline.FREESTYLE);
        c.add(new CompetitiveMember(20, "Sverri", d));
        t.add(new Tournament(null, d, "Assdaq", "Burmeistersgade 5, 1429 KBH K"));

        ScannerMethods.setIn("1\n1\n1\n");
        Team q = new Team(c, t);
        q.appointParticipant();

        assertEquals("Sverri", t.get(0).getParticipants().get(0).getName());
    }
}