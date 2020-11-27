import java.util.ArrayList;
import java.util.Arrays;

public class Cashier {

    private static final String MAIN_MENU_HEADER = "Cashiers Register";
    private static final String SUB_MENU_HEADER = "Arrears Menu";
    private static final String LEAD_TEXT = "Please choose: ";
    private static final String[] MAIN_MENU_POINT = {"1. Subscription Overview", "2. Arrears", "9. Log out"};
    private static final String[] SUB_MENU_POINT = {"1. Pay Arrears", "2. Add Members to Arrears", "3. Arrears Overview", "9. Log out"};
    private ArrayList<Member> memberList;
    private ArrayList<Member> arrearsMembers = new ArrayList<>();
    private boolean logOut = false;

    Menu mainMenu = new Menu(MAIN_MENU_HEADER, LEAD_TEXT, MAIN_MENU_POINT);
    Menu subMenu = new Menu(SUB_MENU_HEADER, LEAD_TEXT, SUB_MENU_POINT);

    public Cashier(ArrayList<Member> memberList) {
        this.memberList = memberList;
        for(Member m : memberList) {
            if(!m.isPaymentStatus()) {
                arrearsMembers.add(m);
            }
        }
    }

    public void showMenu() {

        while (!logOut) {
            mainMenu.printMenu();
            switch (mainMenu.readChoice()) {
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

        for (Member m : memberList) {
            total += m.getMembershipFee();
        }
        System.out.printf("Total amount of membership fee (dough): %.2fDKK\n", total);
    }

    public void arrears() {
        while (!logOut) {
            subMenu.printMenu();
            switch (subMenu.readChoice()) {
                case 1:
                    payArrears();
                    break;
                case 2:
                    addMemberToArrears();
                    break;
                case 3:
                    System.out.println(arrearsMembers.toString());
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

    public void payArrears() {

    }

    public void addMemberToArrears() {
        String name;

        System.out.print("Add a member to the list of arrears: ");
        name = ScannerMethods.stringInput();

        for(Member m : memberList) {
            if(m.getName().toLowerCase().contains(name.toLowerCase())) {
                arrearsMembers.add(m);
                m.setPaymentStatus(false);
            }
        }
        if(arrearsMembers.size() == 0) {
            System.out.println("There is no member with that name");
        }
    }

    public void run() {
        showMenu();
    }
}
