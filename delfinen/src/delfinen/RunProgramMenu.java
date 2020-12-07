package delfinen;

import java.util.ArrayList;

/**
 * A class that runs the entire program
 *
 * @author Sverri, Joachim, Patrick & Christian
 */

public class RunProgramMenu {

    private static final String MEMBER_FILENAME = "MemberList.ser";
    private static final String TOURNAMENT_FILENAME = "Tournament.ser";


    private static ArrayList<Member> memberList;
    private static ArrayList<Tournament> tournamentList;


    /**
     * A main method that runs a menu for the user to choose which part of the program they would like to access
     *
     * @author Sverri, Joachim, Patrick & Christian
     */

    public static void main(String[] args) {
        memberList = new FileData<Member>(memberList, MEMBER_FILENAME).readFile();
        tournamentList = new FileData<Tournament>(tournamentList, TOURNAMENT_FILENAME).readFile();



        final String MENU_HEADER = "Delfinen Swimming Club";
        final String LEAD_TEXT = "Please choose: ";
        final String[] MENU_POINT = {"1. Register Member - Chairman", "2. Coach", "3. For Cashier", "9. Log out"};
        boolean logOut = false;

        while (!logOut) {
            switch (InputMethods.mainMenuInput(MENU_HEADER, LEAD_TEXT, MENU_POINT)) {
                case 1:
                    new ChairmanRegister(memberList).run();
                    break;
                case 2:
                    teamMenu();
                    break;
                case 3:
                    new Cashier(memberList).run();
                    break;
                case 9:
                    System.out.println("Logging out. Have a nice day");
                    logOut = true;
                    break;
                default:
                    System.out.print("Not a valid menu point, please try again: ");
            }
        }
        new FileData<Member>(memberList, MEMBER_FILENAME).saveFile();
        new FileData<Tournament>(tournamentList, TOURNAMENT_FILENAME).saveFile();
    }

    /**
     * @author Sverri, Joachim, Patrick & Christian
     */
    public static void teamMenu() {
        ArrayList<CompetitiveMember> teamListJunior = new ArrayList<>();
        ArrayList<CompetitiveMember> teamListSenior = new ArrayList<>();
        for (Member m : memberList) {
            if (m instanceof CompetitiveMember) {
                if (m.getAge() < 18)
                    teamListJunior.add((CompetitiveMember) m);
                else
                    teamListSenior.add((CompetitiveMember) m);
            }
        }
        switch (InputMethods.mainMenuInput("Delfinen Teams", "Please choose: ", new String[]{"1. Junior Team", "2. Senior Team"})) {
            case 1 -> new Team(teamListJunior, tournamentList).run();
            case 2 -> new Team(teamListSenior, tournamentList).run();
        }

    }

}