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
            "3. Appoint tournament participants", "4. Register swimming results"};

    ArrayList<CompetitiveMember> memberList;
    ArrayList<Tournament> tournamentList;

    Menu menu = new Menu(MENU_HEADER, LEAD_TEXT, MENU_POINT);


    public Team(ArrayList<CompetitiveMember> memberList, ArrayList<Tournament> tournamentList) {

        this.memberList = memberList;
        this.tournamentList = tournamentList;

    }

    public void showMenu() {
        boolean logOut = false;

        while (!logOut) {
            menu.printMenu();
            switch (menu.readChoice()) {
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

        // Needs localdate to register, as they shouldn't be able to create a tournament before today's date

        String name, address;
        ArrayList<Discipline> disciplines = ScannerMethods.menuInputs("Discipline", "Choose:", Discipline.asList());

        System.out.println("Enter name of the tournament: ");
        name = ScannerMethods.stringInput();
        System.out.println("Enter address of the tournament: ");
        address = ScannerMethods.stringInput();

        boolean valid = false;
        int year = 0;
        int month = 0;
        int day = 0;
        int hour = 0;
        int min = 0;
        while (!valid) {
            System.out.println("Enter year:");
            year = (int) ScannerMethods.validNumberInput(LocalDate.now().getYear(), Integer.MAX_VALUE, "Invalid year. Please try again: ");
            System.out.println("Enter month: ");
            month = (int) ScannerMethods.validNumberInput(1, Month.values().length, "Invalid month. Please try again: ");
            System.out.println("Enter day: ");
            day = (int) ScannerMethods.validNumberInput(1, Month.of(month).length(year % 4 == 0), "Invalid day. Please try again: ");
            System.out.println("Enter hour: ");
            hour = (int) ScannerMethods.validNumberInput(0, TimeUnit.DAYS.toHours(1) - 1, "Invalid hour. Please try again: ");
            System.out.println("Enter minute: ");
            min = (int) ScannerMethods.validNumberInput(0, TimeUnit.HOURS.toMinutes(1) - 1, "Invalid minute. Please try again: ");
            System.out.printf("Tournament %s has been registered at %s. Date for tournament is: %d" + "-" + "%d" + "-"
                    + "%d. Time: %d" + "." + "%d", name, address, year, month, day, hour, min);
            LocalDateTime time = LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.of(hour, min));
            if (time.compareTo(LocalDateTime.now()) > 0) {
                valid = true;
            } else {
                System.out.println("the date has already passed try again");
            }

        }
        tournamentList.add(new Tournament(year, month, day, hour, min, disciplines, name, address));
    }

    /**
     * @author Joachim
     */
    public void appointParticipant() {
        Tournament tournament;
        CompetitiveMember member;
        tournament = ScannerMethods.menuInput("Tournament", "Choose tournament:", tournamentList, false);
        member = ScannerMethods.menuInput("Member", "Choose member:", memberList, false);
        tournament.addParticipant(member);
        System.out.printf("%s has been appointed to the tournament: %s ", member, tournament);
    }

    /**
     * @author Joachim
     */

    public void registerResult() {

        CompetitiveMember member;
        Discipline discipline;
        int dist, min, sec, milli;

        member = ScannerMethods.menuInput("Member", "Choose member:", memberList, false);
        if (member == null)
            return;
        discipline = ScannerMethods.menuInput("Dicipline", "Choose dicipline", member.getDisciplines(), false);

        System.out.println("Enter distance of the discipline in meters: ");
        dist = (int) ScannerMethods.validNumberInput(0, Integer.MAX_VALUE, "Invalid distance. Please try again");
        System.out.println("Enter minutes: ");
        min = (int) ScannerMethods.validNumberInput(0, TimeUnit.HOURS.toMinutes(1)-1, "Invalid minute. Please try again: ");
        System.out.println("Enter seconds: ");
        sec = (int) ScannerMethods.validNumberInput(0, TimeUnit.MINUTES.toSeconds(1)-1, "Invalid second. Please try again: ");
        System.out.println("Enter milliseconds: ");
        milli = (int) ScannerMethods.validNumberInput(0, TimeUnit.SECONDS.toMillis(1)-1, "Invalid milliseconds. Please try again: ");
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

        }
    }

    public void run() {
        showMenu();
    }

    /**
     * @author Sverri og Joachim
     */
    public void showMemberList() {
        for (CompetitiveMember m : memberList) {
            System.out.println(m);
        }
    }
}