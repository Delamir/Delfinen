public class ExerciseMember extends Member {
    /**
     * Method that determines the price for a member based on age.
     *
     * @param age  determines if the member is senior, junior or hella old
     * @param name checks the name of the member
     * @author Sverri & Joachim
     */
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
}

