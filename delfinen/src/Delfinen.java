import java.util.ArrayList;

public class Delfinen {

    private final String MENU_HEADER = "Delfinen";
    private final String LEAD_TEXT = "Please choose: ";
    private final String[] MENU_POINT = {"1. Register member", "2. Total Revenue", "3. Show swim results"};
    ArrayList<Member> memberList = new ArrayList<>();

    IO io = new IO();
    Menu menu = new Menu(MENU_HEADER, LEAD_TEXT, MENU_POINT);

    public void showMenu() {
        boolean logOut = false;
        Results results = new Results();

        while (!logOut) {
            menu.printMenu();
            switch (menu.readChoice()) {
                case 1:
                    registerMember();
                    break;
                case 2:
                    totalRevenue();
                    break;
                case 3:
                    results.showResults();
                    break;
                case 9:
                    logOut = true;
                default:
                    System.out.print("Not a valid menu point, please try again: ");

            }
        }
    }

    public void registerMember() {

    }

    public void totalRevenue() {

    }

    public void run() {
        showMenu();
    }
}
