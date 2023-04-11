public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String firstName, String lastName, String employeeNumber, float baseSalary, float benefitsAmount) {
        super(firstName, lastName, employeeNumber, baseSalary);
        setBenefitsAmount(benefitsAmount);
    }

    private float benefitsAmount;

    public void setBenefitsAmount(float benefitsAmount) {
        this.benefitsAmount = benefitsAmount;
    }

    public float getBenefitsAmount() {
        return benefitsAmount;
    }

    // Overriding
    public void printSalary() {
        //System.out.println("Base Salary: " + super.getBaseSalary());
        super.printSalary();
        System.out.println("Benefits: " + this.benefitsAmount);

        float totalCompensation = this.benefitsAmount + this.getBaseSalary();
        System.out.println("Total Compensation: " + totalCompensation);
    }
}
