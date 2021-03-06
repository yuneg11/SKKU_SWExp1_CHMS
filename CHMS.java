public class CHMS {
    private static final String databaseFileName = "database.txt";

    public static void main(String[] args) {
        FileManagement fm = new FileManagement(databaseFileName);
        DataManagement dm = new DataManagement(fm.loadDatabase());
        boolean exit = false;

        do {
            int function = UI.printMain();
            switch (function) {
            case 1: dm.insert(); break;
            case 2: dm.modify(); break;
            case 3: dm.delete(); break;
            case 4: dm.search(); break;
            case 5: dm.sort(); break;
            case 6: dm.list(); break;
            case 7: dm.costCalc(); break;
            case 8: dm.compatTest(); break;
            case 9: exit = true; break;
            }
            fm.saveDatabase(dm.getProducts());
            System.out.println(UI.prompt("Database Saved."));
        } while(!exit);
                
        System.out.println(UI.prompt("Program over."));
    }
}