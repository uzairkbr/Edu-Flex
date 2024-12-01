import java.util.Date;

public class Payment {
    private int id;
    private float amount;
    private Date date;
    private String paymentMethod;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setPaymentMethod(String method) {
        this.paymentMethod = method;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void processPayment() {
        this.date = new Date();
        System.out.println("Payment of $" + amount + " processed using " + paymentMethod + " on " + date);
    }

    public Date getDate() {
        return date;
    }
}
