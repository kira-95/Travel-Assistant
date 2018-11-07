import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.*;

public class Controller {

    private SpotsCollection sc = new SpotsCollection();

    @FXML
    private Button button1;

    @FXML
    private Button buttongenarate;

    @FXML
    private WebView htmlGmap;

    @FXML
    private ListView<String> list;




    @FXML
    private void initialize(){
        WebEngine webEngine = htmlGmap.getEngine();
        URL urlGoogleMaps = getClass().getResource("search.html");
        webEngine.load(urlGoogleMaps.toExternalForm());
    }

    @FXML
    protected void handleButton1Action(ActionEvent event){
    	WebEngine webEngine = htmlGmap.getEngine();
    	String spotInfo = (String) webEngine.executeScript("document.getElementById('status').innerHTML");
    	sc.addSpot(spotInfo);

    	System.out.println(spotInfo);

    	
    	if (!spotInfo.equals("")) {
        	list.getItems().add(spotInfo);
    	}
    	else {
            System.out.println("Please choose spots from map");
    	}
    }

    @FXML
    protected void handleButtonGenerateTripPlan(ActionEvent event){
        try{
            sc.setNumSpots(sc.getSpots().size());
            sc.saveDistancesToMatrix();
            System.out.println(sc.getDistanceMatrix().length);
            List<String> spotList = ShortestRoute.findNearestNeighbor(sc);

            list.getItems().addAll(spotList);
            //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("TripPlanResult.fxml"));
            //Parent root1 = (Parent) fxmlLoader.load();
            //Stage stage = new Stage();
            //stage.setTitle("Trip Plan");
            //stage.setScene(new Scene(root1));
            //stage.show();

        }catch (Exception e){
            System.out.println("Can not load new page");
        }

    }
}
