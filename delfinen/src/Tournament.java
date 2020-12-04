import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Tournament implements Serializable {

    private LocalDateTime dateTime;
    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private String name;
    private String address;
    private ArrayList<CompetitiveMember> participants  = new ArrayList<>();

    public Tournament(int year, int month, int day, int hour, int minutes, ArrayList<Discipline> disciplines,
                      String name, String address) {

        this.disciplines = disciplines;
        this.name = name;
        this.address = address;
        dateTime = LocalDateTime.of(year, month, day, hour, minutes);
    }

    public void addParticipant(CompetitiveMember participant){

        participants.add(participant);
    }

    public ArrayList<CompetitiveMember> getParticipants() {
        return participants;
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

    @Override
    public String toString() {
        return "Tournament: " + name + "\nDisciplines: " + disciplines +
                ", address: " + address + ", date & time: " + dateTime;
    }
}