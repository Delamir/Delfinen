import java.util.ArrayList;

public class Cashier {

    private static final String MENU_HEADER = "Welcome Chairman";
    private static final String LEAD_TEXT = "Please choose: ";
    private static final String[] MENU_POINT = {"1. Subscription Overview", "2. Arrears", "9. Log out"};
    private static final String MEMBER_FILENAME = "MemberList.ser";
    private final ArrayList<Member> MEMBER_LIST;

    Menu menu = new Menu(MENU_HEADER, LEAD_TEXT, MENU_POINT);

    public Cashier(ArrayList<Member> MEMBER_LIST) {
        this.MEMBER_LIST = MEMBER_LIST;
    }

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
        double total = 0;

        for(Member m : MEMBER_LIST) {
            total += m.getMembershipFee();
        }
        System.out.printf("Total amount of membership fee (dough): %.2fDKK\n", total);
    }

    public void arrears() {

    }

    public void run() {
        showMenu();
    }
}
