import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChairmanRegisterTest {

    private static InputStream sysIn;
    
    @Test
    void registerMemberTest() {
        ScannerMethods.setIn("1\n20\n1\n1\n1\n7\n");
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