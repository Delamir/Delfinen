import java.util.ArrayList;


public class CompetitiveMember extends Member {
    ArrayList<Discipline> disciplines = new ArrayList<>();
    ArrayList<Result> results = new ArrayList<>();

    public CompetitiveMember(int age, String name, ArrayList<Discipline> disciplines) {
        super(age, name);
        if (age > 60) {
            setMembershipFee(SENIOR_PRICE * SENIOR_DISCOUNT);
        } else if (age > 18) {
            setMembershipFee(SENIOR_PRICE);
        } else {
            setMembershipFee(JUNIOR_PRICE);
        }
        this.disciplines = disciplines;
    }

    public void ResultsFromDisciplines() {

    }

    public void addResults(Discipline disp, int min, int sec, int milli, int dist) {
        if (disciplines.contains(disp)) {
            for (Result r : results) {
                if (r.disp.equals(disp)) {
                    if (r.min > min) {
                    } else if (r.sec > sec) {
                    } else if (r.milli > milli) {
                    } else {
                        System.out.println("Previous result was better!");
                        return;
                    }
                }
                System.out.printf("WOW!!!!!!!!!! You beat your all result by: %d", sec);
                results.remove(r);
                results.add(new Result(disp, min, sec, milli, dist));
            }
        }
    }

    @Override
    void setMembershipFee() {

    }
}
