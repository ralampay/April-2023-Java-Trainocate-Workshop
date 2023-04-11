import java.util.ArrayList;
import java.util.List;

public class Report {
    public String name;
    public List<Item> items;

    public Report() {
        this.items = new ArrayList<Item>();
    }

    public void displayReport() {
        System.out.println("Report: " + this.name);

        for (Item item : items) {
            System.out.println(item.name);
        }
    }
}
