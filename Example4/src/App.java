public class App {
    public static void main(String[] args) {
        BuildBirthdayCelebrantReport cmd = new BuildBirthdayCelebrantReport("1st Quarter Celebrants", 1, 3);
        cmd.run();

        System.out.println(cmd.getReport());
    }
}
