import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
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

        System.out.println("ID: " + dealer1.get("id"));
        System.out.println("Name: " + dealer1.get("lastName") + ", " + dealer1.get("firstName"));
        System.out.println("Date of Birth: " + dealer1.get("dateOfBirth"));

        // Explicit Casting: Converts one data type to another by declaring the data type in () to the left of the value
        HashMap<String, Object> tempPosition = (HashMap<String, Object>)dealer1.get("position");
        System.out.println("Position: " + tempPosition.get("name"));
    }
}
