import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CompetitiveMemberTest {

    @Test
    void createCompetitiveMemberTest() {
        CompetitiveMember cmJr = new CompetitiveMember(17, "Bent", new ArrayList<>());
        CompetitiveMember cmSr = new CompetitiveMember(23, "Kurt", new ArrayList<>());
        CompetitiveMember cmPe = new CompetitiveMember(65, "Bo", new ArrayList<>());

        assertEquals(1000, cmJr.getMembershipFee());
        assertEquals(1600, cmSr.getMembershipFee());
        assertEquals(1200, cmPe.getMembershipFee());
    }

    /**
     * @author Sverri og Patrick
     */
    @Test
    void addResultTest() {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        disciplines.add(Discipline.BACKSTROKE);
        disciplines.add(Discipline.DROWNING);
        CompetitiveMember result = new CompetitiveMember(17, "Bent", disciplines);
        result.addResults(Discipline.BACKSTROKE, 1, 33,7, 5000);

        assertEquals(1, result.getResults().get(0).getMin());
        assertEquals(33, result.getResults().get(0).getSec());
        assertEquals(7, result.getResults().get(0).getMilli());
        assertEquals(5000, result.getResults().get(0).getDist());

        assertEquals(1, result.getResults().size());
        result.addResults(Discipline.SPLASHING, 1, 33,7, 5000);
        assertEquals(1, result.getResults().size());

        result.addResults(Discipline.BACKSTROKE, 1, 25,50, 5000);
        assertEquals(1, result.getResults().size());
        assertEquals(1, result.getResults().get(0).getMin());
        assertEquals(25, result.getResults().get(0).getSec());
        assertEquals(50, result.getResults().get(0).getMilli());
        assertEquals(5000, result.getResults().get(0).getDist());
    }

}