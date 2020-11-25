import java.util.Scanner;

public class ScannerMethods {

    private static Scanner in = new Scanner(System.in);

    /**
     * A method to check if the user input is legal
     * @param numberFrom is the lowest number the input accept
     * @param numberTo is the highest number the input accept
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

    public static String stringInput(){
        return in.nextLine();
    }


}
