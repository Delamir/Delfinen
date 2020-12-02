import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Ranking {

    private ArrayList<Result[]> results;
    private ArrayList<CompetitiveMember> competitiveMembers;


    public Ranking(ArrayList<CompetitiveMember> competitiveMembers) {
        this.competitiveMembers = competitiveMembers;
        results = new ArrayList<>();

        for (int i = 0; i < Discipline.values().length; i++) {
            Result[] result = new Result[5];
            for (int j = 0; j < result.length; j++) {
                result[j] = new Result(null, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, null);
            }

            results.add(result);
        }

        for (Result[] discipline : results) {
            for (CompetitiveMember c : competitiveMembers) {
                for (Result r : c.getResults()) {
                    if (r.getDisp().equals(Discipline.values()[results.indexOf(discipline)])) {
                        if (discipline[4] == null || r.compareTo(discipline[4]) < 0) {
                            discipline[4] = r;
                            Arrays.sort(discipline);
                        }
                    }
                }
            }
        }
    }


    /**
     * @author Sverri
     */
    public void showResults() {

        for(Result[] r : results) {
            System.out.printf("\nDiscipline: %s", Discipline.values()[results.indexOf(r)]);
            for (int i = 0; i < r.length; i++) {
                if (r[i].getCm() == null) {
                    System.out.println("");
                } else {
                    System.out.printf("\n%d. Place goes to %s with a time of: %s", i + 1, r[i].getCm().getName(), r[i].getTime());
                }
            }
        }
    }
}