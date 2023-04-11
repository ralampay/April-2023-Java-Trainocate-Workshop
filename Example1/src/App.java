public class App {
    public static void main(String[] args) {
        Report report = new Report();
        report.setName("Report 1");

        Report report2 = new Report("Report 2");

        System.out.println("Name: " + report.getName());
        System.out.println("Report 2: " + report2.getName());
    }
}
