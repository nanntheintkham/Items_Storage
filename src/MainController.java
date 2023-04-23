import Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    ItemsStorage<Notebook> notebookStorage;
    ItemsStorage<Pencil> pencilStorage;
    ItemsStorage<Gloves> glovesStorage;
    ItemsStorage<Mask> maskStorage;

    private final Storage storage;
    private final Scanner scanner;

    public void run() {
        do{
            System.out.println("1. Register stocks");
            System.out.println("2. List the full stock");
            System.out.println("3. Search");
            System.out.println("4. Pick items");
            System.out.println("0. Exit");
            System.out.println();
        }while (processChoice());
    }

    private boolean processChoice(){
        int choice = getInt(0, 4);
        switch (choice) {
            case 1 -> registerBoxes();
            case 2 -> {
                System.out.println("Listing all the stocks..");
                storage.list();
                pencilStorage.list();
            }
            //case 3 -> searchBox();
            //case 4 -> pickItems();
        }
        if (choice != 0){
            System.out.println();
            System.out.println("Press ENTER to continue...");
            scanner.nextLine();
        }
        return choice != 0;
    }

    private int getInt(int min, int max) {
        int i = 0;
        boolean isCorrect;
        do {
            System.out.printf("Enter a number (%d-%d)%n", min, max);
            isCorrect = true;
            try {
                i = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                isCorrect = false;
            }
        } while (!isCorrect || i < min || i > max);

        return i;
    }

    private void registerBoxes() {
        String color, itemType = null;
        int price, itemCount, pages, filtersize, safetylevel, size;

        int choice = chooseType();
        int productionDate = BoxPacking.createProductionDate();
        switch (choice) {
            case 1 -> {
                System.out.print("color: ");
                color = scanner.nextLine();
                System.out.print("price: ");
                price = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter the quantity: ");
                itemCount = Integer.parseInt(scanner.nextLine());
                pencilStorage.add(new Pencil(price, color, itemCount, productionDate));
                storage.add(pencilStorage);

                System.out.println("Items packed into the box!!!");
            }
            case 2 -> {
                System.out.print("pages: ");
                pages = Integer.parseInt(scanner.nextLine());
                System.out.print("price: ");
                price = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter the quantity: ");
                itemCount = Integer.parseInt(scanner.nextLine());
                notebookStorage.add(new Notebook(price, pages, itemCount, productionDate));
                System.out.println("Items packed into the box!!!");
            }
            case 3 -> {
                System.out.print("filter size: ");
                filtersize = Integer.parseInt(scanner.nextLine());
                System.out.print("safety level: ");
                safetylevel = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter the quantity: ");
                itemCount = Integer.parseInt(scanner.nextLine());
                maskStorage.add(new Mask(safetylevel, filtersize, itemCount, productionDate));
                System.out.println("Items packed into the box!!!");
            }
            case 4 -> {
                System.out.print("size: ");
                size = Integer.parseInt(scanner.nextLine());
                System.out.print("Safety level: ");
                safetylevel = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter the quantity: ");
                itemCount = Integer.parseInt(scanner.nextLine());
                glovesStorage.add(new Gloves(safetylevel, size, itemCount, productionDate));
                System.out.println("Items packed into the box!!!");
            }
            default -> System.out.println("The typed item cannot be packed into boxes!!!!");
        }

        storage.add(notebookStorage);
        storage.add(maskStorage);
        storage.add(glovesStorage);

    }


    public void searchBox(){
        String itemType;

        System.out.println("\tSearch boxes");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("\nSearched Results\n");
        System.out.println("Enter the item type:(please use this form 'property type (price/safetyLevel_)')");
        String input = scanner.nextLine();

    }

    public int chooseType(){
        System.out.println("What types of item you wanna register?");
        System.out.println("1. Pencil");
        System.out.println("2. Notebook");
        System.out.println("3. Mask");
        System.out.println("4. Gloves");
        return getInt(0, 4);
    }
   /* public void pickItems(){
        String itemType;
        int quantity;

        System.out.println("\tPick items");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.print("Item Type: ");
        itemType = scanner.nextLine();
        System.out.print("Quantity: ");
        quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("\nSearched Results\n");
        storage.pick(itemType, quantity);
        storage.remove();
    }
*/
    public MainController() {
        scanner = new Scanner(System.in);
        this.pencilStorage = new ItemsStorage<>();
        this.notebookStorage = new ItemsStorage<>();
        this.maskStorage = new ItemsStorage<>();
        this.glovesStorage = new ItemsStorage<>();

        this.storage = new Storage();


        /*storage.add(BoxPacking.createBox("red pencil", 30));
        storage.add(BoxPacking.createBox("437 pages notebook", 12));
        storage.add(BoxPacking.createBox("safety level_4 glove(size 12)", 42));
        storage.add(BoxPacking.createBox("safety level_5 mask(filter 3)", 55));*/
    }
}
