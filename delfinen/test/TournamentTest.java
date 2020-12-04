import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TournamentTest {

    @Test
    void tournamentTest(){
        ArrayList<Discipline> disciplines = new ArrayList<>();
        disciplines.add(Discipline.FREESTYLE);
        Tournament tournament = new Tournament(LocalDateTime.now(),disciplines,"Tues svømaton","Lygten 37");

        assertEquals("Tues svømaton",tournament.getName());
        assertEquals("Lygten 37",tournament.getAddress());
    }

    @Test
    void addParticipant() {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        disciplines.add(Discipline.FREESTYLE);
        Tournament tournament = new Tournament(LocalDateTime.now(),disciplines,"Tues svømaton","Lygten 37");
        CompetitiveMember member = new CompetitiveMember(18,"Patrick",disciplines);

        assertEquals(0,tournament.getParticipants().size());
        tournament.addParticipant(member);
        assertEquals(1,tournament.getParticipants().size());

        assertEquals(member,tournament.getParticipants().get(0));

    }

    @Test
    void testToString() {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        disciplines.add(Discipline.FREESTYLE);
        Tournament tournament = new Tournament(LocalDateTime.now(),disciplines,"Tues svømaton","Lygten 37");
        CompetitiveMember member = new CompetitiveMember(18,"Patrick",disciplines);
        tournament.addParticipant(member);
        System.out.println(tournament);
    }
}