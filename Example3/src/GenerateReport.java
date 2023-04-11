public class GenerateReport {
    private Report report;
    private int numItems;

    public GenerateReport(String nameOfReport, int numItems) {
        this.report = new Report();
        this.report.name = nameOfReport;
        this.numItems = numItems;
    }

    public void run() {
        for(int i = 0; i < this.numItems; i++) {
            Item item = new Item();
            item.name = "Item " + i;
            this.report.items.add(item);
        }
    }

    public Report getReport() {
        return this.report;
    }
}
