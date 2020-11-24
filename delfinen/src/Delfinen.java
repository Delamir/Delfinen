import java.util.ArrayList;
import java.util.Scanner;

public class Delfinen {

    private static final String MENU_HEADER = "Delfinen";
    private static final String LEAD_TEXT = "Please choose: ";
    private static final String[] MENU_POINT = {"1. Register member", "2. Total Revenue", "3. Show swim results"};
    private static final String MEMBER_FILENAME = "MemberList.txt";
    ArrayList<Member> memberList = new ArrayList<>();

    Menu menu = new Menu(MENU_HEADER, LEAD_TEXT, MENU_POINT);
    Scanner in = new Scanner(System.in);

    public void showMenu() {
        boolean logOut = false;
        Results results = new Results();

        while (!logOut) {
            menu.printMenu();
            switch (menu.readChoice()) {
                case 1:
                    memberList.add(registerMember());
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
        name = in.nextLine();
        System.out.print("Enter age: ");
        age = (int) validNumberInput(validAgeMin, validAgeMax, "Not a valid age, please input a valid age: ");
        System.out.print("Choose 1 to be an ACTIVE member, choose 2 to be a PASSIVE member: ");
        activePassive = (int) validNumberInput(optionOne, optionTwo, "Not a valid number: ");

        if (activePassive == optionOne) {
            System.out.println("For a COMPETITIVE membership press 1");
            System.out.println("For an EXERCISE membership press 2");
            System.out.print("Make your choice: ");
            exerciseCompetitive = (int) validNumberInput(optionOne, optionTwo, "Not a valid choice: ");
            if (exerciseCompetitive == optionOne) {
                while (notDone) {
                    Menu disciplineMenu = new Menu("Choose your desired discipline", LEAD_TEXT,
                            new String[]{"1. FREESTYLE", "2. BUTTERFLY", "3. BACKSTROKE", "4. BREASTSTROKE",
                                    "5. DROWNING", "6. SPLASHING", "9. Finish"});

                    disciplineMenu.printMenu();
                    switch (menu.readChoice()) {
                        case 1:
                            competitiveDisciplines.add(Discipline.FREESTYLE);
                            break;
                        case 2:
                            competitiveDisciplines.add(Discipline.BUTTERFLY);
                            break;
                        case 3:
                            competitiveDisciplines.add(Discipline.BACKSTROKE);
                            break;
                        case 4:
                            competitiveDisciplines.add(Discipline.BREASTSTROKE);
                            break;
                        case 5:
                            competitiveDisciplines.add(Discipline.DROWNING);
                            break;
                        case 6:
                            competitiveDisciplines.add(Discipline.SPLASHING);
                            break;
                        case 9:
                            notDone = false;
                        default:
                            System.out.println("Not a valid input, please try again");
                    }
                }
                return new CompetitiveMember(age, name, competitiveDisciplines);
            } else {
                return new ExerciseMember(age, name);
            }
        } else {
            return new PassiveMember(age, name);
        }
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
                    System.out.print(errorMessage);
                }
            } else {
                System.out.print(errorMessage);
                in.nextLine();
            }
        }
        return legalNumber;
    }


    public void run() {
        FileData.readFile(MEMBER_FILENAME);
        //load coach list
        //load cashier list
        showMenu();
        FileData.saveFile(new FileData(memberList, MEMBER_FILENAME));
        // gemme coach list
        // Fuck cahsier
    }
}
