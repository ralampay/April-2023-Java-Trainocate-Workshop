public class App {
    public static void main(String[] args) {
        // Build a report called "Sales" with 3 items
        GenerateReport cmd = new GenerateReport("Sales", 3);
        cmd.run();

        cmd.getReport().displayReport();
    }
}
