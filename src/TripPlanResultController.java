
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.web.WebEngine;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TripPlanResultController {


    public List<String> spotList = new ArrayList<String>();

    @FXML
    private ListView<String> planlist;

    @FXML
    private void initialize(){
        System.out.println(spotList);
        planlist.getItems().addAll(spotList);

    }


}