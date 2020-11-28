import java.util.Scanner;

public class PropertyOwnerMenu {

    private final Scanner keyboard;

    public PropertyOwnerMenu(){
        keyboard = new Scanner(System.in);
    }

    public void run(){
        System.out.println("Owner's name: ");
        String ownerName = keyboard.nextLine();
        Owner owner = new Owner(ownerName);

        while (true){
            System.out.println("A)dd Properties, S)how Properties P)ay Tax");
            String command = keyboard.nextLine().toUpperCase();

            switch (command) {
                case "A":
                    System.out.println("Address: ");
                    String address = keyboard.nextLine();
                    System.out.println("PostCode: ");
                    String postCode = keyboard.nextLine();
                    System.out.println("Market Value: ");
                    double marketValue = keyboard.nextDouble();
                    System.out.println("Location Category 0- City, 1- Large Town, 2- Small Town: 3- Village, 4- Countryside");
                    int locationCategory = keyboard.nextInt();
                    System.out.println("Is this your principal private residence?: Enter 1 if it is and enter 0 if it isn'nt");
                    boolean ppr = false;
                    if (keyboard.nextInt() == 1) {
                        ppr = true;
                    }
                    System.out.println("Years of overdue tax? ");
                    int yearsOfOverDueTax = keyboard.nextInt();
                    owner.addProperty(new Property(owner.getName(), address, postCode, marketValue, locationCategory, ppr, yearsOfOverDueTax));

                    break;
                case "S":
                    for (Property p : owner.getProperties()) {
                        System.out.println(p.toString());
                    }
                    break;
                case "P":
                    System.out.print("Choose property from Postcode: " + "\n");
                    for (Property p : owner.getProperties()) {
                        System.out.println(p.getPostCode());
                    }
                    String choice = keyboard.nextLine();
                    for (Property p : owner.getProperties()) {
                        if (choice.equalsIgnoreCase(p.getPostCode())) {
                            p.payTaxDue();
                        }
                    }

                    break;
            }

        }
    }


}
