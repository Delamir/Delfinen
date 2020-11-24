public class CompetitiveMember extends Member {

    public CompetitiveMember(int age, String name) {
        this.age = age;
        this.name = name;
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
