import java.util.ArrayList;

public class Cashier {

    private static final String MENU_HEADER = "Welcome Chairman";
    private static final String LEAD_TEXT = "Please choose: ";
    private static final String[] MENU_POINT = {"1. Subscription Overview", "2. Arrears", "9. Log out"};

    Menu menu = new Menu(MENU_HEADER, LEAD_TEXT, MENU_POINT);
    ArrayList<Object> loadMemberList = new ArrayList<>();
    FileData<Object> fileData = new FileData<>(loadMemberList, "MemberList.ser");

    public void showMenu() {
        boolean logOut = false;

        while(!logOut) {
            menu.printMenu();
            switch(menu.readChoice()) {
                case 1:
                    subscriptionOverview();
                    break;
                case 2:
                    arrears();
                    break;
                case 9:
                    System.out.println("Logging out. Have a nice day");
                    logOut = true;
                    break;
                default:
                    System.out.print("Not a valid menu point, please try again: ");
            }
        }
    }

    public void subscriptionOverview() {

    }

    public void arrears() {

    }

    public void run() {
        showMenu();
    }
}
