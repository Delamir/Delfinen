package delfinen;

import java.time.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Sverri og Joachim
 */

public class Team {
    private final String MENU_HEADER = "Menu";
    private final String LEAD_TEXT = "Please choose: ";
    private final String[] MENU_POINT = {"1. Register tournament", "2. Show swim results",
            "3. Appoint tournament participants", "4. Register swimming results", "5. Show tournaments","6. Show list of members", "9. To exit"};

    private ArrayList<CompetitiveMember> memberList;
    private ArrayList<Tournament> tournamentList;

    public Team(ArrayList<CompetitiveMember> memberList, ArrayList<Tournament> tournamentList) {

        this.memberList = memberList;
        this.tournamentList = tournamentList;

    }

    /**
     * @author Errbody
     */

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
                case 6:
                    showMemberList();
                    break;
                case 9:
                    logOut = true;
                    System.out.println("Returning to main menu");
                    break;
                default:
                    System.out.print("Not a valid menu point, please try again: ");

            }
        }
    }

    /**
     * A method for registering a tournament
     * @author Sverri og Joachim
     */

    public void registerTournament() {

        int year = 0;
        int month = 0;
        int day = 0;
        int hour = 0;
        int min = 0;
        int maxYear = 10;
        LocalDateTime time = null;
        String name, address;
        boolean valid = false;

        ArrayList<Discipline> disciplines = ScannerMethods.menuInputs("Discipline", "Choose:", Discipline.asList());
        if (disciplines.size() == 0) {
            return;
        }
        System.out.print("Write \"exit\" to exit. ");
        System.out.print("Enter name of the tournament: ");
        name = ScannerMethods.stringInput();
        if (name.equalsIgnoreCase("Exit")) {
            return;
        }
        System.out.print("Enter address of the tournament: ");
        address = ScannerMethods.stringInput();

        while (!valid) {
            System.out.print("Enter year: ");
            year = (int) ScannerMethods.validNumberInput(LocalDate.now().getYear(), LocalDate.now().getYear()+100, "Invalid year. Please try again: ");
            System.out.print("Enter month: ");
            month = (int) ScannerMethods.validNumberInput(1, Month.values().length, "Invalid month. Please try again: ");
            System.out.print("Enter day: ");
            day = (int) ScannerMethods.validNumberInput(1, Month.of(month).length(year % 4 == 0), "Invalid day. Please try again: ");
            System.out.print("Enter hour: ");
            hour = (int) ScannerMethods.validNumberInput(0, TimeUnit.DAYS.toHours(1) - 1, "Invalid hour. Please try again: ");
            System.out.print("Enter minute: ");
            min = (int) ScannerMethods.validNumberInput(0, TimeUnit.HOURS.toMinutes(1) - 1, "Invalid minute. Please try again: ");
            time = LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.of(hour, min));
            if (time.compareTo(LocalDateTime.now()) > 0) {
                valid = true;
            } else {
                System.out.println("\nThe date has already passed try again");
            }
        }
        System.out.printf("Tournament %s has been registered at %s. Date for tournament is: %d" + "-" + "%02d" + "-"
                + "%02d. Time: %02d" + "." + "%02d", name, address, year, month, day, hour, min);
        tournamentList.add(new Tournament(time, disciplines, name, address));
    }

    /**
     * @author Sverri og Joachim
     */
    public void showMemberList() {
        for (CompetitiveMember m : memberList) {
            System.out.println(m.getName() + "\nDisciplines: " + m.getDisciplines() + ", results: " + m.getResults());
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
        ArrayList<CompetitiveMember> listToChooseFrom = new ArrayList<>();
        for (CompetitiveMember cm : memberList){
            for(Discipline d : tournament.getDisciplines())
            {
                if(cm.getDisciplines().contains(d))
                    listToChooseFrom.add(cm);
            }
        }
        members = ScannerMethods.menuInputs("Members", "Choose member:", listToChooseFrom);
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
        int min, sec, milli;

        member = ScannerMethods.menuInput("Member", "Choose member:", memberList, true);
        if (member == null)
            return;
        discipline = ScannerMethods.menuInput("Discipline", "Choose discipline", member.getDisciplines(), true);
        if (discipline == null)
            return;
        System.out.print("Enter minutes: ");
        min = (int) ScannerMethods.validNumberInput(0, TimeUnit.HOURS.toMinutes(1) - 1, "Invalid minute. Please try again: ");
        System.out.print("Enter seconds: ");
        sec = (int) ScannerMethods.validNumberInput(0, TimeUnit.MINUTES.toSeconds(1) - 1, "Invalid second. Please try again: ");
        System.out.print("Enter milliseconds: ");
        milli = (int) ScannerMethods.validNumberInput(0, TimeUnit.SECONDS.toMillis(1) - 1, "Invalid milliseconds. Please try again: ");
        System.out.printf("The time was: %02d" + ":" + "%02d" + ":" + "%04d\n", min, sec, milli);
        System.out.printf("in the discipline %s", discipline);
        member.addResults(discipline, min, sec, milli);
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

    public ArrayList<CompetitiveMember> getMemberList() {
        return memberList;
    }

    public ArrayList<Tournament> getTournamentList() {
        return tournamentList;
    }
}