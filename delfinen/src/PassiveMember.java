public class PassiveMember extends Member {

    public PassiveMember() {
        membershipFee = PASSIVE_PRICE;
    }

    @Override
    void setMembershipFee() {

    }
}