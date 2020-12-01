import java.util.Scanner;

public class Property {

    private String ownerName;
    private String address;
    private String postCode;
    private double marketValue;
    private int location;
    private boolean ppr;
    private Tax tax;


    public Property(String ownerName, String address, String postCode,
                    double marketValue, int location, boolean ppr, Tax tax) {
        this.ownerName = ownerName;
        this.address = address;
        this.postCode = postCode;
        this.marketValue = marketValue;
        this.location = location;
        this.ppr = ppr;
        this.tax = tax;
    }

    public Property(String ownerName, String address, String postCode,
                    double marketValue, int location, boolean ppr) {
        this.ownerName = ownerName;
        this.address = address;
        this.postCode = postCode;
        this.marketValue = marketValue;
        this.location = location;
        this.ppr = ppr;
    }

    public String getOwner() {
        return ownerName;
    }

    public String getPostCode() {
        return postCode;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public int getLocation() {
        return location;
    }

    public boolean getPpr() {
        return ppr;
    }

    public void payTaxDue(){
        if(tax.taxDue == 0){
            System.out.println("You're tax is all paid up on this property");
        }else if (tax.taxOverDue != 0){
            System.out.println("Press 0 if you would like to just pay your overdue tax and 1 if you wish to pay all due tax.");
            Scanner keyboard = new Scanner( System.in);
            int choice = keyboard.nextInt();
            switch(choice){
                case 0: System.out.println("You have paid $" + tax.taxOverDue + " worth of overdue tax on this property");
                        tax.taxOverDue = 0;
                        break;
                case 1: System.out.println("You have paid $" + tax.taxOverDue + " worth of overdue tax on this property");
                        System.out.println("You have also paid $" + tax.taxDue + " worth of tax due on this property");
                        tax.taxOverDue = 0;
                        tax.taxDue = 0;
            }
        } else {
            System.out.println("You have paid $" + tax.taxDue + " worth of tax on this property");
            tax.taxDue = 0;
        }
    }

    public String locationToString(){
        String s = "";
        switch (location){
            case 0: s+= "City";
                break;
            case 1: s+= "Large Town";
                break;
            case 2: s+= "Small Town";
                break;
            case 3: s+= "Village";
                break;
            case 4: s+= "Countryside";
                break;

        }
        return s;
    }

    public String toString(){
        String s = "Address: " + address + ", Post Code: " + postCode + ", Market Value: " + marketValue + "," +
                " Location: " + this.locationToString() + ", Principal Private Residence? " + ppr + tax.toString();
        return s;
    }
}
