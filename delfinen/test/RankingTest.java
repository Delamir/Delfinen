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
        c.add(new CompetitiveMember(20, "Tue", d));
        c.add(new CompetitiveMember(24, "Patrick", d));
        c.add(new CompetitiveMember(22, "Bacon", d));
        c.add(new CompetitiveMember(23, "Francis", d));
        c.add(new CompetitiveMember(98, "Shaniqua", d));
        c.get(0).addResults(Discipline.FREESTYLE, 4, 20, 454, 50);
        c.get(1).addResults(Discipline.FREESTYLE, 4, 20, 355, 50);
        c.get(2).addResults(Discipline.FREESTYLE, 3, 45, 255, 50);
        c.get(3).addResults(Discipline.FREESTYLE, 1, 33, 155, 50);
        c.get(4).addResults(Discipline.FREESTYLE, 4, 25, 655, 50);
        System.out.println(c);
        Ranking ranking = new Ranking(c);
        ranking.showResults();
        System.out.println(c);

    }
}