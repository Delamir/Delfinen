package delfinen;

import java.time.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Sverri og Joachim
 */

public class Team {
    private final String MENU_HEADER = "Register tournament";
    private final String LEAD_TEXT = "Please choose: ";
    private final String[] MENU_POINT = {"1. Register tournament", "2. Show swim results",
            "3. Appoint tournament participants", "4. Register swimming results", "5. Show tournaments", "9. To exit"};

    ArrayList<CompetitiveMember> memberList;
    ArrayList<Tournament> tournamentList;

    public Team(ArrayList<CompetitiveMember> memberList, ArrayList<Tournament> tournamentList) {

        this.memberList = memberList;
        this.tournamentList = tournamentList;

    }

    public void showMenu() {
        boolean logOut = false;

        while (!logOut) {

            switch (ScannerMethods.mainMenuInput(MENU_HEADER,LEAD_TEXT,MENU_POINT)) {
                case 1:
                    registerTournament();
                    break;
                case 2:
                    new Ranking(memberList).showResults();
                    break;
                case 3:
                    appointParticipant();
                    break;
                case 4:
                    registerResult();
                    break;
                case 5:
                    showTournaments();
                    break;
                case 9:
                    logOut = true;
                default:
                    System.out.print("Not a valid menu point, please try again: ");

            }
        }
    }

    /**
     * A method for registering a tournament
     *
     * @author Sverri og Joachim
     */

    public void registerTournament() {

        String name, address;
        ArrayList<Discipline> disciplines = ScannerMethods.menuInputs("Discipline", "Choose:", Discipline.asList());
        if (disciplines.size() == 0)
            return;
        System.out.println("Enter name of the tournament: ");
        System.out.println("Write \"exit\" to exit. ");
        name = ScannerMethods.stringInput();
        if (name.equalsIgnoreCase("Exit"))
            return;
        System.out.println("Enter address of the tournament: ");
        address = ScannerMethods.stringInput();

        int year = 0;
        int month = 0;
        int day = 0;
        int hour = 0;
        int min = 0;
        LocalDateTime time = null;

        boolean valid = false;
        while (!valid) {
            System.out.println("Enter year: ");
            year = (int) ScannerMethods.validNumberInput(LocalDate.now().getYear(), Integer.MAX_VALUE, "Invalid year. Please try again: ");
            System.out.println("Enter month: ");
            month = (int) ScannerMethods.validNumberInput(1, Month.values().length, "Invalid month. Please try again: ");
            System.out.println("Enter day: ");
            day = (int) ScannerMethods.validNumberInput(1, Month.of(month).length(year % 4 == 0), "Invalid day. Please try again: ");
            System.out.println("Enter hour: ");
            hour = (int) ScannerMethods.validNumberInput(0, TimeUnit.DAYS.toHours(1) - 1, "Invalid hour. Please try again: ");
            System.out.println("Enter minute: ");
            min = (int) ScannerMethods.validNumberInput(0, TimeUnit.HOURS.toMinutes(1) - 1, "Invalid minute. Please try again: ");
            time = LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.of(hour, min));
            if (time.compareTo(LocalDateTime.now()) > 0) {
                valid = true;
            } else {
                System.out.println("\nThe date has already passed try again");
            }
        }
        System.out.printf("Tournament %s has been registered at %s. Date for tournament is: %d" + "-" + "%d" + "-"
                + "%d. Time: %d" + "." + "%d", name, address, year, month, day, hour, min);
        tournamentList.add(new Tournament(time, disciplines, name, address));
    }

    /**
     * @author Sverri og Joachim
     */
    public void showMemberList() {
        for (CompetitiveMember m : memberList) {
            System.out.println(m);
        }
    }

    /**
     * @author Joachim
     */

    public void appointParticipant() {
        Tournament tournament;
        ArrayList<CompetitiveMember> members;
        tournament = ScannerMethods.menuInput("Tournament", "Choose tournament:", tournamentList, true);
        if (tournament == null)
            return;
        members = ScannerMethods.menuInputs("Member", "Choose member:", memberList);
        if (members.size() == 0)
            return;
        for (CompetitiveMember m : members)
            tournament.addParticipant(m);
        System.out.printf("%s has been appointed to the tournament: %s ", members, tournament);
    }

    /**
     * @author Joachim
     */

    public void registerResult() {

        CompetitiveMember member;
        Discipline discipline;
        int dist, min, sec, milli;


        member = ScannerMethods.menuInput("Member", "Choose member:", memberList, true);
        if (member == null)
            return;
        discipline = ScannerMethods.menuInput("Discipline", "Choose discipline", member.getDisciplines(), true);
        if (discipline == null)
            return;
        System.out.println("Enter distance of the discipline in meters: ");
        dist = (int) ScannerMethods.validNumberInput(0, Integer.MAX_VALUE, "Invalid distance. Please try again");
        System.out.println("Enter minutes: ");
        min = (int) ScannerMethods.validNumberInput(0, TimeUnit.HOURS.toMinutes(1) - 1, "Invalid minute. Please try again: ");
        System.out.println("Enter seconds: ");
        sec = (int) ScannerMethods.validNumberInput(0, TimeUnit.MINUTES.toSeconds(1) - 1, "Invalid second. Please try again: ");
        System.out.println("Enter milliseconds: ");
        milli = (int) ScannerMethods.validNumberInput(0, TimeUnit.SECONDS.toMillis(1) - 1, "Invalid milliseconds. Please try again: ");
        System.out.printf("The time was: %02d" + ":" + "%02d" + ":" + "%04d\n", min, sec, milli);
        System.out.printf("The distance was: %d " + "meters" + "in the discipline %s", dist, discipline);
        member.addResults(discipline, min, sec, milli, dist);
    }

    /**
     * @author Sverri og Joachim
     */
    public void showTournaments() {
        for (Tournament t : tournamentList) {
            System.out.println(t);
            for (CompetitiveMember m : t.getParticipants())
                System.out.println(m.getName());
        }
    }

    public void run() {
        showMenu();
    }
}