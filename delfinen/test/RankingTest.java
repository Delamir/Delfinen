import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RankingTest {

    /**
     * @author Sverri og Joachim
     */

    @Test
    void showResultsTest() {
        ArrayList<CompetitiveMember> c = new ArrayList<>();
        ArrayList<Discipline> d = new ArrayList<>();
        d.add(Discipline.FREESTYLE);
        d.add(Discipline.BUTTERFLY);
        c.add(new CompetitiveMember(20, "Tue", d));
        c.add(new CompetitiveMember(24, "Patrick", d));
        c.add(new CompetitiveMember(22, "Bacon", d));
        c.add(new CompetitiveMember(23, "Francis", d));
        c.add(new CompetitiveMember(98, "Shaniqua", d));
        c.get(0).addResults(Discipline.FREESTYLE, 0, 0, 1, 50);
        c.get(1).addResults(Discipline.FREESTYLE, 0, 0, 2, 50);
        c.get(2).addResults(Discipline.FREESTYLE, 0, 0, 3, 50);
        c.get(3).addResults(Discipline.FREESTYLE, 0, 0, 4, 50);
        c.get(4).addResults(Discipline.FREESTYLE, 0, 0, 5, 50);
        c.get(0).addResults(Discipline.BUTTERFLY, 0, 5, 1, 50);
        c.get(1).addResults(Discipline.BUTTERFLY, 0, 4, 2, 50);
        c.get(2).addResults(Discipline.BUTTERFLY, 0, 3, 3, 50);
        c.get(3).addResults(Discipline.BUTTERFLY, 0, 2, 4, 50);
        c.get(4).addResults(Discipline.BUTTERFLY, 0, 1, 5, 50);
        Ranking ranking = new Ranking(c);
        ranking.showResults();
    }
}