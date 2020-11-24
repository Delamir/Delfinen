import java.util.Scanner;

/**
 * Menu class, that create and print a menu of your choice
 */

public class Menu {
    private String menuHeader;
    private String leadText;
    private String[] menuPoints;

    Scanner in = new Scanner(System.in);

    /**
     * Constructor for the menu. You set up the menu interface in the parameters
     *
     * @param menuHeader is the title of the menu
     * @param leadText   is the text in the bottom of the menu, that prompt the user on what to do next
     * @param menuPoints is all the menu point you want in your menu
     */
    public Menu(String menuHeader, String leadText, String[] menuPoints) {
        setMenuHeader(menuHeader);
        setLeadText(leadText);
        setMenuPoints(menuPoints);
    }

    public void setMenuHeader(String menuHeader) {
        this.menuHeader = menuHeader;
    }

    public String getMenuHeader() {
        return menuHeader;
    }

    public void setLeadText(String leadText) {
        this.leadText = leadText;
    }

    public String getLeadText() {
        return leadText;
    }

    public void setMenuPoints(String[] menuPoints) {
        this.menuPoints = menuPoints;
    }

    public String[] getMenuPoints() {
        return menuPoints;
    }

    /**
     * Print out the constructed menu, with the menuHeader first, then all the menu points.
     */

    public void printMenu() {
        System.out.println("\n" + menuHeader);
        for (int i = 0; i < menuPoints.length; i++) {
            System.out.println(menuPoints[i]);
        }
        System.out.print("\n" + leadText);
    }

    /**
     * The method check if the user input the correct number, according to menu points
     *
     * @return the number the user inputs
     */

    public int readChoice() {
        int number = -1;
        boolean validNumber = false;

        while (!validNumber) {
            if (in.hasNextInt()) {
                number = in.nextInt();
                in.nextLine();
                if (number < 0) {
                    System.out.print(leadText);
                } else {
                    validNumber = true;
                }
            } else {
                in.nextLine();
                System.out.println("Not a valid menu point, please try again");
                printMenu();
            }
        }
        return number;
    }
}
