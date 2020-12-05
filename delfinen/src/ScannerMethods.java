import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that accept input from the user
 *
 * @author Sverri & Christian
 */

public class ScannerMethods {

    private static Scanner in = new Scanner(System.in);

    /**
     * A method to check if the user input is legal
     *
     * @param numberFrom   is the lowest number the input accept
     * @param numberTo     is the highest number the input accept
     * @param errorMessage is the shown errormessage if the user input is illegal
     * @return a legal input from the user
     * @author Christian
     */
    public static double validNumberInput(double numberFrom, double numberTo, String errorMessage) {
        boolean validChoice = false;
        double legalNumber = -1;

        while (!validChoice) {
            if (in.hasNextDouble()) {
                legalNumber = in.nextDouble();
                in.nextLine(); //Scanner bug
                if (legalNumber >= numberFrom && legalNumber <= numberTo) {
                    validChoice = true;
                } else {
                    System.out.print(errorMessage);
                }
            } else {
                System.out.print(errorMessage);
                in.nextLine();
            }
        }
        return legalNumber;
    }

    /**
     * A method that return a String from use input
     *
     * @return an input string
     * @author Sverri
     */
    public static String stringInput() {
        return in.nextLine();
    }

    public static <T> ArrayList<T> menuInputs(String title, String prefix, ArrayList<T> menuPoints) {
        ArrayList<T> listToReturn = new ArrayList<>();

        boolean done = false;
        T t;
        while (!done) {
            t = menuInput(title, prefix, menuPoints, true);
            if (t == null) {
                done = true;
            } else {
                listToReturn.add(t);
            }
        }

        return listToReturn;
    }

    /**
     * @author Sverri
     */
    public static int mainMenuInput(String title, String prefix, String[] menuPoints){
        Menu menu = new Menu(title, prefix, menuPoints, in);
        menu.printMenu();
        return menu.readChoice();
    }

    /**
     * @author Sverri
     */
    public static <T> T menuInput(String title, String prefix, ArrayList<T> menuPoints, boolean hasExit) {

        Menu menu = new Menu(title, prefix, listAsStringArray(menuPoints, hasExit), in);
        int choice = getChoice(menu, menuPoints.size() + (hasExit ? 1 : 0));
        if (choice-1 == menuPoints.size() && hasExit)
            return null;
        return menuPoints.get(choice - 1);
    }

    /**
     * @author Sverri
     */
    private static <T> String[] listAsStringArray(ArrayList<T> list, boolean hasExit) {
        String[] arrayToReturn = new String[list.size() + (hasExit ? 1 : 0)];

        for (int i = 0; i < arrayToReturn.length-(hasExit ? 1 : 0); i++)
            arrayToReturn[i] = (i + 1) + ". " + list.get(i).toString();
        if (hasExit)
            arrayToReturn[arrayToReturn.length - 1] = arrayToReturn.length + ". Exit";

        return arrayToReturn;
    }

    /**
     * @author Joachim
     */
    private static int getChoice(Menu menu, int size) {
        menu.printMenu();

        int choice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            choice = menu.readChoice();
            if (choice > 0 && choice <= size)
                validChoice = true;
        }
        return choice;
    }

    public static Scanner getIn() {
        return in;
    }

    /**
     * for testing purposes
     * @author Sverri
     */
    public static void setIn(String input){
        in = new Scanner(input);

    }
}
