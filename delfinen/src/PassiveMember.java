public class PassiveMember extends Member {

    public PassiveMember(int age, String name) {
        super(age, name);
        membershipFee = PASSIVE_PRICE;
    }

    @Override
    void setMembershipFee() {

    }
}