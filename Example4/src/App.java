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

        for (HashMap<String, Object> position : positions) {
            System.out.println("ID: " + position.get("id") + " Name: " + position.get("name"));
        }
    }
}
