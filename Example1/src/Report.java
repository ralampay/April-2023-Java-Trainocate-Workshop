public class Report {
    private String name;

    public Report(String name) {
        this.setName(name);
    }

    // Overloading: 
    // Using the same method or constructor name but
    // with different signature
    public Report() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
