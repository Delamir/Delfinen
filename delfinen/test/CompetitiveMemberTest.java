import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CompetitiveMemberTest {

    @Test
    void createCompetitiveMember() {
        CompetitiveMember cmJr = new CompetitiveMember(17, "Bent", new ArrayList<>());
        CompetitiveMember cmSr = new CompetitiveMember(23, "Kurt", new ArrayList<>());
        CompetitiveMember cmPe = new CompetitiveMember(65, "Bo", new ArrayList<>());

        assertEquals(1000, cmJr.getMembershipFee());
        assertEquals(1600, cmSr.getMembershipFee());
        assertEquals(1200, cmPe.getMembershipFee());
    }

}