import java.io.Serializable;

public abstract class Member implements Serializable {
    private int age;
    private String name;
    private double membershipFee;
    static final double SENIOR_PRICE = 1600;
    static final double SENIOR_DISCOUNT = 0.25;
    static final double JUNIOR_PRICE = 1000;
    static final double PASSIVE_PRICE = 500;
    private boolean paymentStatus;

    abstract void setMembershipFee();

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMembershipFee() {
        return membershipFee;
    }

    public void setMembershipFee(double membershipFee) {
        this.membershipFee = membershipFee;
    }

    public static double getSeniorPrice() {
        return SENIOR_PRICE;
    }

    public static double getSeniorDiscount() {
        return SENIOR_DISCOUNT;
    }

    public static double getJuniorPrice() {
        return JUNIOR_PRICE;
    }

    public static double getPassivePrice() {
        return PASSIVE_PRICE;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
