import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class BuildBirthdayCelebrantReport {
    private HashMap<String, Object> report;
    private String name;
    private int startMonth;
    private int endMonth;

    public BuildBirthdayCelebrantReport(String name, int startMonth, int endMonth) {
        this.name = name;
        this.startMonth = startMonth;
        this.endMonth = endMonth;

        this.report = new HashMap<String, Object>();
    }

    public HashMap<String, Object> getReport() {
        return report;
    }

    public void run() {
        report.put("name", this.name);
        report.put("startMonth", this.startMonth);
        report.put("endMonth", this.endMonth);

        HashMap<String, Object> positionManagingDirector = new HashMap<String, Object>();
        positionManagingDirector.put("id", 1);
        positionManagingDirector.put("name", "Managing Director");

        HashMap<String, Object> positionFranchiseBuilder = new HashMap<String, Object>();
        positionFranchiseBuilder.put("id", 2);
        positionFranchiseBuilder.put("name", "Franchise Builder");

        HashMap<String, Object> positionFranchiseManager = new HashMap<String, Object>();
        positionFranchiseManager.put("id", 3);
        positionFranchiseManager.put("name", "Franchise Manager");

        HashMap<String, Object> positionFranchiseDirector = new HashMap<String, Object>();
        positionFranchiseDirector.put("id", 4);
        positionFranchiseDirector.put("name", "Franchise Director");

        List<HashMap<String, Object>> positions = new ArrayList<HashMap<String,Object>>();
        positions.add(positionManagingDirector);
        positions.add(positionFranchiseBuilder);
        positions.add(positionFranchiseManager);
        positions.add(positionFranchiseDirector);

        HashMap<String, Object> dealer1 = new HashMap<String, Object>();
        dealer1.put("id", 1);
        dealer1.put("firstName", "Raphael");
        dealer1.put("lastName", "Alampay");
        dealer1.put("dateOfBirth", "1988-04-19");
        dealer1.put("position", positionFranchiseManager);

        HashMap<String, Object> dealer2 = new HashMap<String, Object>();
        dealer2.put("id", 2);
        dealer2.put("firstName", "Leonardo");
        dealer2.put("lastName", "Alampay");
        dealer2.put("dateOfBirth", "1988-04-19");
        dealer2.put("position", positionManagingDirector);

        List<HashMap<String, Object>> dealers = new ArrayList<HashMap<String, Object>>();
        dealers.add(dealer1);
        dealers.add(dealer2);

        report.put("dealers", dealers);
    }
}
