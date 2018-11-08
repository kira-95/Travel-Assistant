import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.*;

public class Controller {

    private SpotsCollection sc = new SpotsCollection();
    List<String> listCompare = new ArrayList<String>();

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
    	//sc.addSpot(spotInfo);




    	
    	if (!spotInfo.equals("")) {
            if (!listCompare.contains(spotInfo)){
                sc.addSpot(spotInfo);
                listCompare.add(spotInfo);
                list.getItems().add(spotInfo);
            }
            else{
                System.out.println("Repeated Location!");
            }


    	}
    	else {
            System.out.println("No Spot Information Found!");
    	}
    }

    @FXML
    protected void handleDeleteAction(ActionEvent event){
        if (listCompare.isEmpty()){
            System.out.println("Already Empty!");
        }
        else{
            sc.deleteSpot();
            listCompare.remove(listCompare.size()-1);
            list.getItems().remove(list.getItems().size()-1);

        }



    }

    @FXML
    protected void handleButtonGenerateTripPlan(ActionEvent event){
        try{
            list.getItems().clear();
            list.getItems().add("Loading...");
            sc.setNumSpots(sc.getSpots().size());
            sc.saveDistancesToMatrix();

            List<String> spotList = ShortestRoute.findNearestNeighbor(sc);
            list.getItems().clear();
            list.getItems().addAll(spotList);
            //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("TripPlanResult.fxml"));
            //Parent root1 = (Parent) fxmlLoader.load();
            //Stage stage = new Stage();
            //stage.setTitle("Trip Plan");
            //stage.setScene(new Scene(root1));
            //stage.show();

        }catch (Exception e){
            list.getItems().clear();
            System.out.println("Can not build the route!");
        }

    }
}
