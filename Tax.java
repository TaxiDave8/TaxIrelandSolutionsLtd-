import java.util.Scanner;

public class Tax{

    protected double taxDue;
    protected int yearsOverDue;
    protected double taxOverDue;
    protected Property property;

    public Tax(int yearsOverDue){
        this.yearsOverDue = yearsOverDue;
    }

    public void addTheProperty(Property property){
        this.property = property;
        this.taxDue = this.getTaxDue();
        this.taxOverDue = this.getTaxOverDue();
    }

    public double calcAnnualTax() {
        double annualTax = 100;

        if ( property.getMarketValue() <= 150000) {
            annualTax += 0;
        } else if  ( property.getMarketValue() > 150000 && property.getMarketValue() <= 400000) {
            annualTax += property.getMarketValue() * .0001;
        } else if  ( property.getMarketValue() > 400000 && property.getMarketValue() <= 650000) {
            annualTax += property.getMarketValue() * .0002;
        } else if  ( property.getMarketValue() > 650000) {
            annualTax += property.getMarketValue() * .0004;
        }

        switch (property.getLocation()) {
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

        if ( property.getPpr() == true ) {
            annualTax += 100;
        }
        return annualTax;
    }

    public double getTaxDue() {
        double thisYearsTax = calcAnnualTax();
        if( yearsOverDue != 0 ){
            thisYearsTax = thisYearsTax * Math.pow(1.07, yearsOverDue );
        }
        return thisYearsTax;
    }

    public double getTaxOverDue(){
        double overDue = 0;
        if ( yearsOverDue == 0){
            return 0;
        } else {
            overDue = calcAnnualTax() * ( 1 - Math.pow( 1.07, yearsOverDue) )/ ( 1 - 1.07 );
        }
        return overDue;
    }

    public String toString(){
        String s = ", Tax Due: " + taxDue + ", Tax OverDue: " + taxOverDue;
        return s;
    }
}