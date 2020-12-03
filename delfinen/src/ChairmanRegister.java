import java.util.ArrayList;

/**
 * A class for the chairman to register new members
 * @author Christian & Sverri
 */
public class ChairmanRegister {

    private static final String MENU_HEADER = "Welcome Chairman";
    private static final String LEAD_TEXT = "Please choose: ";
    private static final String[] MENU_POINT = {"1. Register member", "9. Log out"};

    ArrayList<Member> memberList;
    Menu menu = new Menu(MENU_HEADER, LEAD_TEXT, MENU_POINT);

    public ChairmanRegister(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    /**
     * A method that shows the chairman menu, where he can pick the specific menu points
     * @author Christian
     */
    public void showMenu() {
        boolean logOut = false;

        while (!logOut) {
            menu.printMenu();
            switch (menu.readChoice()) {
                case 1:
                    memberList.add(registerMember());
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
     * A method that register a member based on age, preferred activity, and discipline. Put the registered
     * member into an arraylist
     * @return a member based on the above
     * @author Christian & Sverri
     */
    public Member registerMember() {
        int age;
        int validAgeMin = 0;
        int validAgeMax = 100;
        int optionOne = 1;
        int optionTwo = 2;
        int activePassive;
        int exerciseCompetitive;
        boolean notDone = true;
        String name;
        ArrayList<Discipline> competitiveDisciplines = new ArrayList<>();

        System.out.println("Register new member");
        System.out.print("Enter the name: ");
        name = ScannerMethods.stringInput();
        System.out.print("Enter age: ");
        age = (int) ScannerMethods.validNumberInput(validAgeMin, validAgeMax, "Not a valid age, please input a valid age: ");
        System.out.print("Choose 1 to be an ACTIVE member, choose 2 to be a PASSIVE member: ");
        activePassive = (int) ScannerMethods.validNumberInput(optionOne, optionTwo, "Not a valid number: ");

        if (activePassive == optionOne) {
            System.out.println("For a COMPETITIVE membership press 1");
            System.out.println("For an EXERCISE membership press 2");
            System.out.print("Make your choice: ");
            exerciseCompetitive = (int) ScannerMethods.validNumberInput(optionOne, optionTwo, "Not a valid choice: ");
            if (exerciseCompetitive == optionOne) {
                competitiveDisciplines = ScannerMethods.menuInputs("Choose your desired diciplines",LEAD_TEXT,Discipline.asList());
                return new CompetitiveMember(age, name, competitiveDisciplines);
            } else {
                return new ExerciseMember(age, name);
            }
        } else {
            return new PassiveMember(age, name);
        }
    }

    /**
     * A method that is able to execute the whole class, including loading and saving data input from the user
     * @author Christian & Sverri
     */
    public void run() {
        showMenu();
    }
}