import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.*;

public class UIController {

    private SpotsCollection sc = new SpotsCollection();
    private List<String> listCompare = new ArrayList<String>();

    @FXML
    private Button button1;

    @FXML
    private Label text = new Label();
    private Button buttongenarate;

    @FXML
    private WebView htmlGmap;


    @FXML
    private ListView<String> list;

    @FXML
    protected void initialize(){
        WebEngine webEngine = htmlGmap.getEngine();
        URL urlGoogleMaps = getClass().getResource("search.html");
        webEngine.load(urlGoogleMaps.toExternalForm());
    }

    @FXML
    protected void handleButton1Action(ActionEvent event){
    	WebEngine webEngine = htmlGmap.getEngine();
    	String spotInfo = (String) webEngine.executeScript("document.getElementById('status').innerHTML");

        if (!spotInfo.equals("")) {
            if (!listCompare.contains(spotInfo)){
                sc.addSpot(spotInfo);
                listCompare.add(spotInfo);
                list.getItems().add(spotInfo);
                System.out.println(listCompare);
            }
            else{
                System.out.println("Repeated Location!");
                text.setText("Repeated Location!");
            }
        }
        else {
            System.out.println("No Spot Information Found!");
            text.setText("No Spot Information Found!");
        }
    }

    @FXML
    protected void handleDeleteAction(ActionEvent event){
        if (listCompare.isEmpty()){
            System.out.println("Spot List is Already Empty!");
            text.setText("Spot List is Already Empty!");
        }
        else{
            sc.deleteSpot();
            listCompare.remove(listCompare.size()-1);
            list.getItems().remove(list.getItems().size()-1);
        }
    }

    @FXML
    protected void handleButtonGenerateTripPlan(ActionEvent event){
        text.setText("Loading...");
        list.getItems().clear();

        try{
            sc.setNumSpots(sc.getSpots().size());
            sc.saveDistancesToMatrix();

            List<String> spotList = ShortestRoute.findNearestNeighbor(sc);

            list.getItems().addAll(spotList);
            text.setText("Success!");

        }catch (Exception e){

            System.out.println("Can not generate the route!");
            text.setText("Can not generate the route!");
        }

    }
}
