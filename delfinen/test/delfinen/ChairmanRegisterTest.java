package delfinen;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChairmanRegisterTest {

    /**
     * Sverri og Joachim
     */
    @Test
    void registerMemberTest() {
        InputMethods.setIn("1\n20\n1\n1\n1\n6\n");
        ArrayList<Member> memberList = new ArrayList<>();
        ChairmanRegister chairMan = new ChairmanRegister(memberList);

        memberList.add(chairMan.registerMember());

        assertEquals(1, memberList.size());
        assertTrue(memberList.get(0) instanceof CompetitiveMember);

        ArrayList<Discipline> disc = new ArrayList<>();
        disc.add(Discipline.FREESTYLE);
        assertEquals(20, memberList.get(0).getAge());
        assertEquals(disc, ((CompetitiveMember) memberList.get(0)).getDisciplines());
    }
}