import java.util.ArrayList;

public class BalancingStatement {

    int year;
    double taxDue;
    ArrayList<Payment> payments;

    public BalancingStatement(int year){
        this.year = year;
        this.payments = new ArrayList<Payment>();
    }

    public void addPayment(Payment payment){
        payments.add(payment);
    }

    @Override
    public String toString() {
        String s = "BalancingStatement for " + "Year:" + year + "\n Payments:";
        for(Payment p: payments){
            s += p.toString() + "\n";
        }
        return s;
    }
}
