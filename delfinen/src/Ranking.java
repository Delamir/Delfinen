import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Ranking {

    private ArrayList<CompetitiveMember> competitiveMembers;


    public Ranking(ArrayList<CompetitiveMember> competitiveMembers) {
        this.competitiveMembers = competitiveMembers;
        ArrayList<Result[]> results = new ArrayList<>();

        for (int i = 0; i < Discipline.values().length; i++) {
            results.add(new Result[5]);
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


    public void showResults() {
        System.out.printf("");
    }
}
