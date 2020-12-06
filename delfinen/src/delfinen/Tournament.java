package delfinen;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Patrick
 */
public class Tournament implements Serializable {

    private LocalDateTime dateTime;
    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private String name;
    private String address;
    private ArrayList<CompetitiveMember> participants  = new ArrayList<>();

    /**
     * @author Patrick
     */
    public Tournament(LocalDateTime dateTime, ArrayList<Discipline> disciplines,
                      String name, String address) {

        this.disciplines = disciplines;
        this.name = name;
        this.address = address;
        this.dateTime = dateTime;
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

    /**
     * @author Patrick
     */
    @Override
    public String toString() {
        return "Tournament: " + name + "\nDisciplines: " + disciplines +
                ", address: " + address + ", date & time: " + dateTime;
    }
    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }
}