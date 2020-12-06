package delfinen;

import delfinen.Member;
import delfinen.PassiveMember;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassiveMemberTest {


    /**
     * @author Patrick
     */
    @Test
    void passiveMemberTest() {
        Member cmJr = new PassiveMember(17, "Bent");
        Member cmSr = new PassiveMember(23, "Kurt");
        Member cmPe = new PassiveMember(65, "Bo");

        assertEquals(500, cmJr.getMembershipFee());
        assertEquals(500, cmSr.getMembershipFee());
        assertEquals(500, cmPe.getMembershipFee());
    }



}