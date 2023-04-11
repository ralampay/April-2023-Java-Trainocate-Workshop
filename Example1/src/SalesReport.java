public class SalesReport extends Report {

    private float totalAmount;

    public SalesReport(String name, float totalAmount) {
        // Invokes a constructor of the parent
        super(name); 
        this.setTotalAmount(totalAmount);     
    }

    public float getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
