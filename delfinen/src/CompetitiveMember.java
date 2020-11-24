import java.util.ArrayList;


public class CompetitiveMember extends Member {
    ArrayList<Discipline> disciplines = new ArrayList<>();

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

    public void addResults() {
    }

    @Override
    void setMembershipFee() {

    }
}
