import java.time.LocalDateTime;
import java.util.ArrayList;

public class Team {

    private final String MENU_HEADER = "Register tournament";
    private final String LEAD_TEXT = "Please choose: ";
    private final String[] MENU_POINT = {"1. Register tournament", "2. Show swim results",
            "3. Appoint tournament participants", "4. Register swimming results"};
    ArrayList<Member> memberList = new ArrayList<>();
    ArrayList<Tournament> tournamentList = new ArrayList<>();

    Menu menu = new Menu(MENU_HEADER, LEAD_TEXT, MENU_POINT);


    public Team(ArrayList<Member> memberList, ArrayList<Tournament> tournamentList) {
        this.memberList = memberList;
        this.tournamentList = tournamentList;
    }

    public Team() {
    }

    public void showMenu() {
        boolean logOut = false;
        Ranking ranking = new Ranking();

        while (!logOut) {
            menu.printMenu();
            switch (menu.readChoice()) {
                case 1:
                    registerTournament();
                    break;
                case 2:
                    ranking.showResults();
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
     * @Author Joachim
     */

    public void registerTournament() {
        int year;
        int month;
        int day;
        int hour;
        int minute;
        int yearMin = 2020;
        int yearMax = 3000;
        int monthMin = 1;
        int monthMax = 12;
        int dayMin = 1;
        int dayMax = 31;
        int hourMin = 9;
        int hourMax = 18;
        int minuteMin = 0;
        int minuteMax = 59;

        String name, address;
        ArrayList<Discipline> disciplines;

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
        minute = (int) ScannerMethods.validNumberInput(minuteMin, minuteMax, "Invalid minute. Please try again: ");
        System.out.printf("Tournament %s has been registered at %s. Date for tournament is: %d" + "-" + "%d" + "-"
                + "%d. Time: %d" + "." + "%d", name, address, year, month, day, hour, minute);
    }

    public void appointParticipant() {
    }

    public void registerResult() {
        int min;
        int sec;
        int milli;
        int minuteMin = 0;
        int minuteMax = 59;
        int secMin = 0;
        int secMax = 59;
        int milliMin = 0;
        int milliMax = 999;

        System.out.println("Enter minutes: ");
        min = (int) ScannerMethods.validNumberInput(minuteMin, minuteMax, "Invalid minute. Please try again: ");
        System.out.println("Enter seconds: ");
        sec = (int) ScannerMethods.validNumberInput(secMin, secMax, "Invalid second. Please try again: ");
        System.out.println("Enter milliseconds: ");
        milli = (int) ScannerMethods.validNumberInput(milliMin, milliMax, "Invalid milliseconds. Please try again: ");
        System.out.printf("The time was: %02d" + ":" + "%02d" + ":" + "%04d", min, sec, milli);

    }

    public void run() {
        showMenu();
    }
}

