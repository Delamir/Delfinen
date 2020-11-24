public class Main {

    public static void main(String[] args) {
        runMenu();
    }

    /**
     * The method create an instance of the menu class, and then print the menu
     */
    public static void runMenu() {
        Menu menu = new Menu("Main Menu", "Please Choose: ",
                new String[]{"1. Choose ONE", "2. Choose TWO", "3. Choose THREE", "9. To log out"});
        menu.printMenu();
    }
}
