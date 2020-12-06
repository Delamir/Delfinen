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

    }

    @Test
    void addMemberToArrearsTest() {

    }

}