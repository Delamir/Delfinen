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
        Results results = new Results();

        while (!logOut) {
            menu.printMenu();
            switch (menu.readChoice()) {
                case 1:
                    registerTournament();
                    break;
                case 2:
                    results.showResults();
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

    }

    public void appointParticipant() {

    }

    public void registerResult(){

    }
}
