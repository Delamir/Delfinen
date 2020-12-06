package delfinen;

import java.io.Serializable;

/**
 * @author Patrick
 */
public abstract class Member implements Serializable {
    private int age;
    private String name;
    private double membershipFee;
    static final double SENIOR_PRICE = 1600;
    static final double SENIOR_DISCOUNT = 0.75;
    static final double JUNIOR_PRICE = 1000;
    static final double PASSIVE_PRICE = 500;
    private boolean paymentStatus = true;

    /**
     * @author Patrick
     */
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

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * @author Patrick
     */
    @Override
    public String toString() {
        return name;
    }

}
