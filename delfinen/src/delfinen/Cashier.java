package delfinen;

import java.util.ArrayList;

/**
 * A class for the cashier to manage subscriptions
 *
 * @author Patrick & Christian
 */
public class Cashier {

    private static final String MAIN_MENU_HEADER = "Cashiers Register";
    private static final String SUB_MENU_HEADER = "Arrears Menu";
    private static final String LEAD_TEXT = "Please choose: ";
    private static final String[] MAIN_MENU_POINT = {"1. Subscription Overview", "2. Arrears", "9. Log out"};
    private static final String[] SUB_MENU_POINT = {"1. Pay Arrears", "2. Add Members to Arrears", "3. Arrears Overview", "9. Log out"};
    private ArrayList<Member> memberList;

    private ArrayList<Member> arrearsMembers = new ArrayList<>();

    private boolean logOut = false;
    /**
     * The constructor for the class
     *
     * @param memberList is the list of the members of the swimming club
     * @author Patrick & Chrsitian
     */
    public Cashier(ArrayList<Member> memberList) {
        this.memberList = memberList;
        for (Member m : memberList) {
            if (!m.isPaymentStatus()) {
                arrearsMembers.add(m);
            }
        }
    }

    /**
     * A method to show the cashier menu
     *
     * @author Christian
     */
    public void showMenu() {

        while (!logOut) {
            switch (ScannerMethods.mainMenuInput(MAIN_MENU_HEADER, LEAD_TEXT, MAIN_MENU_POINT)) {
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

    /**
     * Show the total amount of membership fee that the club can expect
     *
     * @author Patrick
     */
    public void subscriptionOverview() {
        double total = 0;

        for (Member m : memberList) {
            total += m.getMembershipFee();
        }
        System.out.printf("Total amount of membership fee (dough): %.2fDKK\n", total);
    }

    /**
     * A method that shows the menu of options for the different state of arrears
     *
     * @author Patrick
     */
    public void arrears() {
        while (!logOut) {
            switch (ScannerMethods.mainMenuInput(SUB_MENU_HEADER, LEAD_TEXT, SUB_MENU_POINT)) {
                case 1:
                    payArrears();
                    break;
                case 2:
                    addMemberToArrears();
                    break;
                case 3:
                    showMembersInArrears();
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

    public void showMembersInArrears() {
        for (Member m : arrearsMembers) {
            System.out.println(m.getName() + ": " + m.getMembershipFee());
        }
    }

    /**
     * A method to pay arrears
     *
     * @author Christian og Patrick
     */
    public void payArrears() {

        System.out.println("Remove a member from the arrears list: ");
        Member m = (ScannerMethods.menuInput("Arrear list", "Pay arrears for member: ", arrearsMembers, true));
        if (m == null)
            return;
        arrearsMembers.remove(m);
        m.setPaymentStatus(true);
    }

    /**
     * A method to add members to a list of arrears
     *
     * @author Patrick og Christian
     */
    public void addMemberToArrears() {
        ArrayList<Member> members = new ArrayList<>();
        for(Member m : memberList){
            if(m.isPaymentStatus())
                members.add(m);
        }
        Member m = (ScannerMethods.menuInput("Arrear list", "Pay arrears for member: ", arrearsMembers, true));
        if(m == null)
            return;
        arrearsMembers.add(m);
        m.setPaymentStatus(false);
    }


    /**
     * The run method to run the whole class
     *
     * @author Christian
     */
    public void run() {
        showMenu();
    }

    public ArrayList<Member> getArrearsMembers() {
        return arrearsMembers;
    }
}
