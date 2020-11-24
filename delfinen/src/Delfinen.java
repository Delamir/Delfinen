public class Delfinen {

    private String menuHeader = "Delfinen";
    private String leadText = "Please choose: ";
    private String[] menuPoint = {"1. Register member", "2. Total Revenue", "3. Show swim results"};

    Menu menu = new Menu(menuHeader, leadText, menuPoint);

    public void showMenu() {
        Results results = new Results();
        menu.printMenu();

        switch(menu.readChoice()) {
            case 1:
                registerMember();
                break;
            case 2:
                totalRevenue();
            case 3:
                results.showResults();

        }
    }
}
