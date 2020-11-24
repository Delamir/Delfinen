import java.util.ArrayList;
import java.util.Scanner;

public class Delfinen {

    private final String MENU_HEADER = "Delfinen";
    private final String LEAD_TEXT = "Please choose: ";
    private final String[] MENU_POINT = {"1. Register member", "2. Total Revenue", "3. Show swim results"};
    ArrayList<Member> memberList = new ArrayList<>();

    IO io = new IO("MemberList");
    Menu menu = new Menu(MENU_HEADER, LEAD_TEXT, MENU_POINT);

    Scanner in = new Scanner(System.in);

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
        String name;
        int age;

        System.out.println("Register new member");
        System.out.print("Enter the name: ");
        name = in.nextLine();
        System.out.print("Enter age: ");
        age = (int) validNumberInput(0, 100, "Not a valid age, please input a valid age: ");

    }

    public void totalRevenue() {

    }

    public double validNumberInput(double numberFrom, double numberTo, String errorMessage) {
        boolean validChoice = false;
        double legalNumber = -1;

        while (!validChoice) {
            if (in.hasNextDouble()) {
                legalNumber = in.nextDouble();
                in.nextLine(); //Scanner bug
                if (legalNumber >= numberFrom && legalNumber <= numberTo) {
                    validChoice = true;
                } else {
                    System.out.println(errorMessage);
                }
            } else {
                System.out.println(errorMessage);
                in.nextLine();
            }
        }
        return legalNumber;
    }


        public void run () {
            io.readFile();
            showMenu();
            io.saveFile();
        }
    }
