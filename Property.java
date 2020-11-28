import java.util.Random;

/**
 * if weve time at the end, fuck tax stuff into it's own class
 */
public class Property {

    private String ownerName;
    private String address;
    private String postCode;
    private double marketValue;
    private int location;
    private boolean ppr;

    protected double taxDue;
    protected int yearsOverDue;
    protected double taxOverDue;


    public Property(String ownerName, String address, String postCode,
                    double marketValue, int location, boolean ppr, int yOD) {
        this.ownerName = ownerName;
        this.address = address;
        this.postCode = postCode;
        this.marketValue = marketValue;
        this.location = location;
        this.ppr = ppr;

        this.yearsOverDue = yOD;
        this.taxDue = this.getTaxDue();
        this.taxOverDue = this.getTaxOverDue();
    }

    public String getOwner() {
        return ownerName;
    }

    public String getPostCode() {
        return postCode;
    }

    public double getMarketValue() { return marketValue;
    }

    public int getLocation() {
        return location;
    }

    public boolean getPpr() {
        return ppr;
    }

    public double getTaxDue() {
        double thisYearsTax = this.calcAnnualTax();
        if( yearsOverDue != 0 ){
            thisYearsTax = thisYearsTax * Math.pow(1.07, yearsOverDue );
        }
        return thisYearsTax;
    }

    public double calcAnnualTax() {
        double annualTax = 100;

        if ( marketValue <= 150000) {
            annualTax += 0;
        } else if (marketValue > 150000 && marketValue <= 400000) {
            annualTax += marketValue * .0001;
        } else if (marketValue > 400000 && marketValue <= 650000) {
            annualTax += marketValue * .0002;
        } else if (marketValue > 650000) {
            annualTax += marketValue * .0004;
        }

        switch (location) {
            case 0: annualTax += 100;
                break;
            case 1: annualTax += 80;
                break;
            case 2: annualTax += 60;
                break;
            case 3: annualTax += 50;
                break;
            case 4: annualTax += 25;
                break;
        }

        if ( ppr ) {
            annualTax += 100;
        }
        return annualTax;
    }

    public double getTaxOverDue(){
        double overDue = 0;
        if ( yearsOverDue == 0){
            return 0;
        } else {
            overDue = this.calcAnnualTax() * ( 1 - Math.pow( 1.07, yearsOverDue) )/ ( 1 - 1.07 );
        }
        return overDue;
    }

    public double payTaxDue(){
        taxDue = 0;
        return taxDue;
    }

    public String toString(){
        String s = "Address: " + address + ", Post Code: " + postCode +
                ", Market Value: " + marketValue + ", Location: " +
                location + ", Principal Private Residence? " + ppr  + ", Tax Due: " + taxDue +  ", Tax OverDue: " + taxOverDue;
        return s;
    }
}
