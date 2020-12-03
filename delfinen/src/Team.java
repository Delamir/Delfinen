import java.util.ArrayList;

/**
 * Sverri og Joachim
 */

public class Team {
    int year;
    int month;
    int day;
    int hour;
    int min;
    int sec;
    int milli;
    int dist;
    final int yearMin = 2020;
    final int yearMax = 3000;
    final int monthMin = 1;
    final int monthMax = 12;
    final int dayMin = 1;
    final int dayMax = 31;
    final int hourMin = 9;
    final int hourMax = 18;
    final int minuteMin = 0;
    final int minuteMax = 59;
    final int secMin = 0;
    final int secMax = 59;
    final int milliMin = 0;
    final int milliMax = 999;
    final int distMin = 10;
    final int distMax = 25000;


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
        ArrayList<Discipline> disciplines = new ArrayList<>();

        String[] disc = new String[Discipline.values().length + 1];

        for (int i = 0; i < disc.length - 1; i++) {
            disc[i] = (i + 1) + ". " + Discipline.values()[i].toString();
        }

        disc[disc.length - 1] = "9. EXIT";

        Menu menu = new Menu("Discipline", "Choose: ", disc);

        System.out.println("Which discipline do you wish to choose: ");
        menu.printMenu();
        boolean logOut = false;
        while (!logOut) {
            switch (menu.readChoice()) {
                case 1 -> disciplines.add(Discipline.FREESTYLE);
                case 2 -> disciplines.add(Discipline.BUTTERFLY);
                case 3 -> disciplines.add(Discipline.BACKSTROKE);
                case 4 -> disciplines.add(Discipline.BREASTSTROKE);
                case 5 -> disciplines.add(Discipline.DROWNING);
                case 6 -> disciplines.add(Discipline.SPLASHING);
                case 9 -> {
                    System.out.println("Choose your disciplines: ");
                    logOut = true;
                }
                default -> System.out.println("Not a valid input, please try again");
            }
        }
        System.out.println("Enter name of the tournament: ");
        name = ScannerMethods.stringInput();
        System.out.println("Enter address of the tournament: ");
        address = ScannerMethods.stringInput();
        System.out.println("Enter year:");
        year = (int) ScannerMethods.validNumberInput(yearMin, yearMax, "Invalid year. Please try again: ");
        System.out.println("Enter month: ");
        month = (int) ScannerMethods.validNumberInput(monthMin, monthMax, "Invalid month. Please try again: ");
        System.out.println("Enter day: ");
        day = (int) ScannerMethods.validNumberInput(dayMin, dayMax, "Invalid day. Please try again: ");
        System.out.println("Enter hour: ");
        hour = (int) ScannerMethods.validNumberInput(hourMin, hourMax, "Invalid hour. Please try again: ");
        System.out.println("Enter minute: ");
        min = (int) ScannerMethods.validNumberInput(minuteMin, minuteMax, "Invalid minute. Please try again: ");
        System.out.printf("Tournament %s has been registered at %s. Date for tournament is: %d" + "-" + "%d" + "-"
                + "%d. Time: %d" + "." + "%d", name, address, year, month, day, hour, min);
        tournamentList.add(new Tournament(year, month, day, hour, min, disciplines, name, address));
    }

    /**
     * @author Joachim
     */
    public void appointParticipant() {
        int choice;
        Menu menu;
        Tournament tournament;
        CompetitiveMember member;
        tournament = ScannerMethods.menuInput("Tournament", "Choose tournament:", tournamentList, false);
        member = ScannerMethods.menuInput("Member", "Choose member:", memberList, false);
        /*
        String[] tour = new String[tournamentList.size()];
        String[] memb = new String[memberList.size()];

        for (int i = 0; i < tour.length; i++)
            tour[i] = (i + 1) + ". " + tournamentList.get(i).getName();

        menu = new Menu("Tournament", "Choose tournament", tour);
        choice = getChoice(menu, tournamentList.size());
        tournament = tournamentList.get(choice-1);

        for (int i = 0; i < memb.length; i++)
            memb[i] = (i + 1) + ". " + memberList.get(i).getName();

        menu = new Menu("Member", "Choose member", memb);
        choice = getChoice(menu, memberList.size());
        member = memberList.get(choice-1);
*/
        System.out.printf("%s has been appointed to the tournament: %s ", member, tournament);
    }

    /**
     * @author Joachim
     */

    public void registerResult() {

        CompetitiveMember member;
        Discipline d;

        member = ScannerMethods.menuInput("Member", "Choose member:", memberList, false);
        if (member == null)
            return;
        d = ScannerMethods.menuInput("Dicipline", "Choose dicipline", member.getDisciplines(), false);
/*
        String[] memb = new String[memberList.size()];

        for (int i = 0; i < memb.length; i++)
            memb[i] = (i + 1) + ". " + memberList.get(i).getName();

        Menu menu = new Menu("Member", "Choose member", memb);
        int choice = getChoice(menu, memberList.size());
        member = memberList.get(choice-1);

        System.out.println("Discipline: ");
        String[] disp = new String[Discipline.values().length + 1];

        for (int i = 0; i < disp.length - 1; i++) {
            disp[i] = (i + 1) + ". " + Discipline.values()[i].toString();
        }
        disp[disp.length - 1] = 9 + ". Exit";
        menu = new Menu("Discipline", "Choose Discipline", disp);
        menu.printMenu();
        boolean valid = false;
        while (!valid) {
            switch (menu.readChoice()) {
                case 1 -> d = Discipline.FREESTYLE;
                case 2 -> d = Discipline.BUTTERFLY;
                case 3 -> d = Discipline.BACKSTROKE;
                case 4 -> d = Discipline.BREASTSTROKE;
                case 5 -> d = Discipline.DROWNING;
                case 6 -> d = Discipline.SPLASHING;
            }
            if (d != null)
                valid = true;
        }
        */
        System.out.println("Enter distance of the discipline in meters: ");
        dist = (int) ScannerMethods.validNumberInput(distMin, distMax, "Invalid distance. Please try again");
        System.out.println("Enter minutes: ");
        min = (int) ScannerMethods.validNumberInput(minuteMin, minuteMax, "Invalid minute. Please try again: ");
        System.out.println("Enter seconds: ");
        sec = (int) ScannerMethods.validNumberInput(secMin, secMax, "Invalid second. Please try again: ");
        System.out.println("Enter milliseconds: ");
        milli = (int) ScannerMethods.validNumberInput(milliMin, milliMax, "Invalid milliseconds. Please try again: ");
        System.out.printf("The time was: %02d" + ":" + "%02d" + ":" + "%04d\n", min, sec, milli);
        System.out.printf("The distance was: %d " + "meters" + "in the discipline %s", dist, d);
        member.addResults(d, min, sec, milli, dist);

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