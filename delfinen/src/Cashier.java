import java.util.ArrayList;

public class Cashier {

    private static final String MENU_HEADER = "Welcome Chairman";
    private static final String LEAD_TEXT = "Please choose: ";
    private static final String[] MENU_POINT = {"1. Subscription Overview", "2. Arrears", "9. Log out"};
    private static final String MEMBER_FILENAME = "MemberList.ser";
    private static ArrayList<Member> memberList;

    Menu menu = new Menu(MENU_HEADER, LEAD_TEXT, MENU_POINT);

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
        memberList = new FileData<>(memberList, MEMBER_FILENAME).readFile();
        System.out.print(memberList);
    }

    public void arrears() {

    }

    public void run() {
        showMenu();
    }
}
