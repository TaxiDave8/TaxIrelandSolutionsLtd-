import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Payment {

    private LocalDate date;
    private double amount;
    private boolean wasOverDue;

    public Payment(LocalDate date, double amount, boolean wasOverDue){
        this.date = date;
        this.amount = amount;
        this.wasOverDue = wasOverDue;
    }

    @Override
    public String toString() {
        return "Amount paid: " + amount + ", Date paid: " + java.time.LocalDate.now() + ", Was this overdue? " + wasOverDue;
    }
}
