public abstract class Member {
    int age;
    String name;
    double membershipFee;
    static final double SENIOR_PRICE = 1600;
    static final double SENIOR_DISCOUNT = 0.25;
    static final double JUNIOR_PRICE = 1000;
    static final double PASSIVE_PRICE = 500;

    abstract void setMembershipFee();

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

}
