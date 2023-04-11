public class App {
    public static void main(String[] args) {
        Employee emp = new Employee("Raphael", "Alampay", "060081", 10000.00f);
        SalesEmployee salesEmp = new SalesEmployee("Leonardo", "Alampay", "060082", 20000.00f, 0.1f);
   
        emp.printSalary();
        salesEmp.printSalary();
    }
}
