import java.util.ArrayList;
import java.util.List;

public class CompetitiveMember extends Member {
    ArrayList<Discipline> disciplines = new ArrayList<>();

    public CompetitiveMember(int age, String name, ArrayList<Discipline> disciplines) {
        this.age = age;
        this.name = name;
        if (age > 60) {
            membershipFee = SENIOR_PRICE * SENIOR_DISCOUNT;
        } else if (age > 18) {
            membershipFee = SENIOR_PRICE;
        } else {
            membershipFee = JUNIOR_PRICE;
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
