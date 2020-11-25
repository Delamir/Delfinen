/**
 * A class that runs the entire program
 * @author Sverri, Joachim, Patrick & Christian
 */
public class RunProgramMenu {

    /**
     * A main method that runs a menu for the user to choose which part od the program they would like to access
     * @author Sverri, Joachim, Patrick & Christian
     */
    public static void main(String[] args) {

        final String MENU_HEADER = "Delfinen Swimming Club";
        final String LEAD_TEXT = "Please choose: ";
        final String[] MENU_POINT = {"1. Register Member - Chairman", "2. For Cashier Menu", "3. Coach", "9. Log out"};
        boolean logOut = false;

        Menu menu = new Menu(MENU_HEADER, LEAD_TEXT, MENU_POINT);

        while (!logOut) {
            menu.printMenu();
            switch (menu.readChoice()) {
                case 1:
                    new ChairmanRegister().run();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 9:
                    System.out.println("Logging out. Have a nice day");
                    logOut = true;
                default:
                    System.out.print("Not a valid menu point, please try again: ");

            }
        }
    }
}
