public class SalesEmployee extends Employee {
    private float commission;

    public SalesEmployee(String firstName, String lastName, String employeeNumber, float baseSalary, float commission) {
        super(firstName, lastName, employeeNumber, baseSalary);
        setCommission(commission);
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public float getCommission() {
        return commission;
    }

    // Overriding
    public void printSalary() {
        //System.out.println("Base Salary: " + super.getBaseSalary());
        super.printSalary();
        System.out.println("Commission: " + this.commission);
    }
}