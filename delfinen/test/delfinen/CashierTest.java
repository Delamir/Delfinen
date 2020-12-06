package delfinen;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {

    @Test
    void subscriptionOverviewTest() {
        Member m = new PassiveMember(22, "Bent");
        Member m1 = new CompetitiveMember(50, "Karen", new ArrayList<>());
        ArrayList<Member> members = new ArrayList<>();
        members.add(m);
        members.add(m1);

        m.setPaymentStatus(false);
        m1.setPaymentStatus(false);

        Cashier cashier = new Cashier(members);
        cashier.showMembersInArrears();
        ScannerMethods.setIn("1\n");
        assertEquals(2,cashier.getArrearsMembers().size());
    }

    @Test
    void payArrearsTest() {
        ScannerMethods.setIn("1\n");
        Member m = new PassiveMember(22, "Bent");
        Member m1 = new CompetitiveMember(50, "Karen", new ArrayList<>());
        ArrayList<Member> members = new ArrayList<>();
        members.add(m);
        members.add(m1);
        m.setPaymentStatus(false);
        m1.setPaymentStatus(false);

        Cashier cashier = new Cashier(members);
        cashier.payArrears();
        assertTrue(m.isPaymentStatus());
        assertEquals(1, cashier.getArrearsMembers().size());
    }

    @Test
    void addMemberToArrearsTest() {
        ScannerMethods.setIn("1\n");
        Member m2 = new PassiveMember(30, "Bodil");
        Member m = new PassiveMember(22, "Bent");
        Member m1 = new CompetitiveMember(50, "Karen", new ArrayList<>());
        ArrayList<Member> members = new ArrayList<>();
        members.add(m);
        members.add(m1);
        members.add(m2);

        Cashier cashier = new Cashier(members);
        cashier.addMemberToArrears();
        assertFalse(m.isPaymentStatus());
        assertEquals(1, cashier.getArrearsMembers().size());
    }

}