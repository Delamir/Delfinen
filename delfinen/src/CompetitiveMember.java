import java.util.ArrayList;


public class CompetitiveMember extends Member {
    private ArrayList<Discipline> disciplines = new ArrayList<>();

    private ArrayList<Result> results = new ArrayList<>();

    /**
     * Method that determines the price for a member based on age.
     *
     * @param age         determines if the member is senior, junior or hella old
     * @param name        checks the name of the competitive member
     * @param disciplines checks the disciplines that the competitive member is a part of
     * @author Sverri & Joachim
     */

    public CompetitiveMember(int age, String name, ArrayList<Discipline> disciplines) {
        super(age, name);
        if (age > 60) {
            setMembershipFee(SENIOR_PRICE - (SENIOR_PRICE * SENIOR_DISCOUNT));
        } else if (age > 18) {
            setMembershipFee(SENIOR_PRICE);
        } else {
            setMembershipFee(JUNIOR_PRICE);
        }
        this.disciplines = disciplines;
    }

    public void ResultsFromDisciplines() {

    }

    /**
     * Method that the user can enter a time in.
     *
     * @param disp  confirms the discipline
     * @param min   the minutes it took the swim the lap
     * @param sec   the seconds
     * @param milli the milliseconds
     * @param dist  the distance of the discipline
     * @author Sverri og Joachim
     */
    public void addResults(Discipline disp, int min, int sec, int milli, int dist) {
        if (disciplines.contains(disp)) {
            for (Result r : results) {
                if (r.disp.equals(disp)) {
                    if (r.getMin() > min) {
                    } else if (r.getSec() > sec) {
                    } else if (r.getMilli() > milli) {
                    } else {
                        System.out.println("Previous result was better!");
                        return;
                    }
                }
                System.out.printf("WOW!!!!!!!!!! You beat your best result by: %d", sec);
                results.remove(r);
                results.add(new Result(disp, min, sec, milli, dist));
                return;
            }
            results.add(new Result(disp, min, sec, milli, dist));
        }
    }

    @Override
    void setMembershipFee() {

    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public ArrayList<Result> getResults() {
        return results;
    }
}
