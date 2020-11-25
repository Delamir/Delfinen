import java.util.ArrayList;
import java.util.Scanner;

public class Team {

    private final String MENU_HEADER = "Register tournament";
    private final String LEAD_TEXT = "Please choose: ";
    private final String[] MENU_POINT = {"1. Register tournament", "2. Show swim results",
            "3. Appoint tournament participants", "4. Register swimming results"};
    ArrayList<Member> memberList = new ArrayList<>();

    Menu menu = new Menu(MENU_HEADER, LEAD_TEXT, MENU_POINT);
    Scanner in = new Scanner(System.in);

    public Team(ArrayList<Member> memberList) {
        this.memberList = memberList;
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
        int minuteMin = 1;
        int minuteMax = 59;

        String name, address;
        ArrayList<Discipline> disciplines;

        System.out.println("Enter name of the tournament: ");
        name = in.nextLine();
        System.out.println("Enter address of the tournament: ");
        address = in.nextLine();
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
    }
}

