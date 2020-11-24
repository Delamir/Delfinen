public class ExerciseMember extends Member {

    public ExerciseMember(int age, String name) {
        super(age, name);
        if (age > 60) {
            membershipFee = SENIOR_PRICE * SENIOR_DISCOUNT;
        } else if (age > 18) {
            membershipFee = SENIOR_PRICE;
        } else {
            membershipFee = JUNIOR_PRICE;
        }
    }

        @Override
        void setMembershipFee() {

        }
    }

