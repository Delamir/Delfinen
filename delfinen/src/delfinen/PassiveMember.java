package delfinen;

public class PassiveMember extends Member {

    /**
     * @author Patrick
     */
    public PassiveMember(int age, String name) {
        super(age, name);
        setMembershipFee(PASSIVE_PRICE);
    }
}