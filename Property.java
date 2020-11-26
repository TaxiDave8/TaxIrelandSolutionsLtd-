import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Property {

    private String owner;
    private String address;
    private String postCode;
    private double marketValue;
    private int location;
    protected boolean ppr;
    public double annualTax;


    public void acceptInput(){
        Scanner nFile = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter owner's name: ");
        owner = nFile.nextLine(); // Read user input

        System.out.println("Enter address: ");
        address = nFile.nextLine(); // Read user input

        System.out.println("Enter postCode: ");
        postCode = nFile.nextLine(); // Read user input

        System.out.println("Enter MarketValue ");
        marketValue = nFile.nextDouble(); // Read user input

        System.out.println("Enter location: 1 for city, 2 for large town, 3 small town, 4 for village ");
        location = nFile.nextInt(); // Read user input

        System.out.println("Is this the owner's principle residence; enter 1 for yes and 0 for no ");
        ppr = 1 == nFile.nextInt();
    }

    public void writeToFile() throws IOException {
        File nFile = new File(owner + ".csv");
        if (nFile.createNewFile()) {
            System.out.println("File created: " + nFile.getName());
        } else {
            System.out.println("File already exists.");
        }

        FileWriter fr = new FileWriter(nFile, true);
        fr.append(owner).append(",");
        fr.append(address).append(",");
        fr.append(postCode).append(",");
        fr.append(String.valueOf(marketValue)).append(",");
        switch (location) {
            case 1:
                fr.append("City,");
                break;

            case 2:
                fr.append("Large Town,");
                break;

            case 3:
                fr.append("Small town,");
                break;

            case 4:
                fr.append("Village,");
                break;
            default:
                return;
        }

        if (ppr) {
            fr.append("ppr = true, \n");
        } else fr.append("ppr = false, \n");
        fr.flush();
        fr.close();
    }

    public double calculateAnnualTax() {
        annualTax += 100;

        if (marketValue <= 150000) {
            annualTax += 0;
        } else if (marketValue > 150000 && marketValue <= 400000) {
            annualTax += marketValue * .0001;
        } else if (marketValue > 400000 && marketValue <= 650000) {
            annualTax += marketValue * .0002;
        } else if (marketValue > 650000) {
            annualTax += marketValue * .0004;
        }

        switch (location) {
            case 1 -> annualTax += 100;
            case 2 -> annualTax += 80;
            case 3 -> annualTax += 60;
            case 4 -> annualTax += 50;
            case 5 -> annualTax += 25;
            default -> System.out.print("Please enter number between 1-5.");
        }

            if (ppr) {
                annualTax += 100;
            }
        return annualTax;

    }
}