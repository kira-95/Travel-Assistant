
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.Scene;
import java.net.URL;
import javafx.stage.Stage;
import java.util.*;
import jdk.nashorn.internal.objects.Global;
import netscape.javascript.JSObject;
import javafx.concurrent.Worker.State;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Controller {


    public List<String> spotList = new ArrayList<String>();


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
    	spotList.add(spotInfo);




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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("TripPlanResult.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Trip Plan");
            stage.setScene(new Scene(root1));
            stage.show();

        }catch (Exception e){
            System.out.println("Can not load new page");
        }

    }
}
