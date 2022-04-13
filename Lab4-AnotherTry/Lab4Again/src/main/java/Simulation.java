import java.util.Scanner;

public class Simulation {
    public void interactWithUser(DatabaseManager dm){
        System.out.println("What do you want to do?" +
                "\n0-End"+
                "\n1-Add Mage \n2-Add Tower " +
                "\n3-Delete Mage \n4-Delete Tower  " +
                "\n5-Print  mages in towers higher then x and have level greater then y" +
                "\n6-Print mages that have have level greater then x" +
                "\n7-Print Database ");
        Scanner sc = new Scanner(System.in);

        boolean choosing=true;
        while (choosing) {
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    choosing = false;
                    break;
                case 1:
                    createMage(sc, dm);
                    break;
                case 2:
                    createTower(sc,dm);
                    break;
                case 3:
                    System.out.println("Give the name of the mage: ");
                    Mage mage = dm.getMage(sc.nextLine());
                    while(mage == null){
                        System.out.println("Mage not found give name of the tower again: ");
                        mage = dm.getMage(sc.nextLine());
                    }
                    dm.deleteEntity(mage);
                    break;
                case 4:
                    System.out.println("Give the name of the tower: ");
                    Tower tower = dm.getTower(sc.nextLine());
                    while(tower == null){
                        System.out.println("Tower not found give name of the tower again: ");
                        tower = dm.getTower(sc.nextLine());
                    }
                    dm.deleteEntity(tower);
                    break;
                case 5:
                    System.out.println("Give the height of the tower: ");
                    int x = sc.nextInt();
                    System.out.println("Give the level of mage: ");
                    int y = sc.nextInt();
                    dm.printOnHeightAndLevel(x, y);
                    break;
                case 6:
                    System.out.println("Give the level of mage: ");
                    dm.printOnLevel(sc.nextInt());
                    break;
                case 7:
                    dm.printDatabase();
                    break;
            }
        }
    }

    private void createMage(Scanner sc, DatabaseManager dm) {
        System.out.println("Give the name of the mage: ");
        String name = sc.next();
        System.out.println("Give the level of the mage: ");
        int level = sc.nextInt();
        sc.nextLine();
        System.out.println("Give the name of the tower: ");
        Tower tower = dm.getTower(sc.nextLine());
        while(tower == null){
            System.out.println("Tower not found give name of the tower again: ");
            tower = dm.getTower(sc.nextLine());
        }
        dm.addEntity(new Mage(name,level,tower));
    }
    private void createTower(Scanner sc, DatabaseManager dm) {
        System.out.println("Give the name of the tower: ");
        String name = sc.next();
        System.out.println("Give the height of the tower: ");
        int height = sc.nextInt();
        dm.addEntity(new Tower(name,height));
    }
}
