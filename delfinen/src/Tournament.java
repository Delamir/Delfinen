import java.time.LocalDateTime;
import java.util.ArrayList;


public class Tournament {

    private LocalDateTime dateTime;
    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private String name;
    private String address;
    private ArrayList<CompetitiveMember> participants  = new ArrayList<>();

    public Tournament(int year, int month, int day, int hour, int minutes, ArrayList<Discipline> disciplines, String name, String address) {

        this.disciplines = disciplines;
        dateTime = LocalDateTime.of(year, month, day, hour, minutes);
    }

    public void addParticipant(CompetitiveMember participant){

        participants.add(participant);
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}