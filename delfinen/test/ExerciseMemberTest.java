import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseMemberTest {

    @Test
    void exerciseMemberTest(){
        Member member1 = new ExerciseMember(10,"Hans");
        Member member2 = new ExerciseMember(20,"Jens");
        Member member3 = new ExerciseMember(66,"Poul");

        assertEquals(1000, member1.getMembershipFee());
        assertEquals(1600, member2.getMembershipFee());
        assertEquals(1200, member3.getMembershipFee());

    }

}