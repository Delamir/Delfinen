public class ExerciseMember extends Member {

    public ExerciseMember(int age, String name) {
        super(age, name);
        if (age > 60) {
            setMembershipFee(SENIOR_PRICE * SENIOR_DISCOUNT);
        } else if (age > 18) {
            setMembershipFee(SENIOR_PRICE);
        } else {
            setMembershipFee(JUNIOR_PRICE);
        }
    }

        @Override
        void setMembershipFee() {

        }
    }

