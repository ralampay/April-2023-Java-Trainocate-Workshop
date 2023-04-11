public class Employee {
    private String firstName;
    private String lastName;
    private String employeeNumber;
    private float baseSalary;

    public Employee(String firstName, String lastName, String employeeNumber, float baseSalary) {
        setEmployeeNumber(employeeNumber);
        setFirstName(firstName);
        setLastName(lastName);
        setBaseSalary(baseSalary);
    }

    public void printSalary() {
        System.out.println("Base Salary: " + this.baseSalary);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public float getBaseSalary() {
        return baseSalary;
    }
}
