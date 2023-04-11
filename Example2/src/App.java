public class App {
    public static void main(String[] args) {
        Employee emp = new Employee("Raphael", "Alampay", "060081", 10000.00f);
        SalesEmployee salesEmp = new SalesEmployee("Leonardo", "Alampay", "060082", 20000.00f, 0.1f);
        FullTimeEmployee ftEmp = new FullTimeEmployee("Michael", "Alampay", "060083", 25000.00f, 5000.00f);
   
        //emp.printSalary();
        //salesEmp.printSalary();
        //ftEmp.printSalary();

        // Polymorphism
        // --> Poly: Many things
        // --> morphism: To change 
        // Rule: Parent class can be instantiated to child class but not the other way around
        //Employee emp2 = new SalesEmployee("New", "Employee", "IDNUMX", 20000f, 0.1f);
    
        App.printSalary(salesEmp);
    }

    public static void printSalary(Employee emp) {
        emp.printSalary();
    }
}
