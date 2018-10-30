<<<<<<< HEAD:src/sample/Controller.java
package sample;
=======
package src;
import javafx.application.Platform;
>>>>>>> efefb329722dc7c4d24f02a24b5c2e695ccce56f:src/Controller.java
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.net.URL;
import netscape.javascript.JSObject;
import javafx.concurrent.Worker.State;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Controller {
    @FXML
    private Button button1;

    @FXML
    private WebView htmlGmap;

    @FXML
    private ListView<String> list;

    public class JavaBridge
    {
        public void log(String text)
        {
            System.out.println(text);
        }
    }

    @FXML
    private void initialize(){
        WebEngine webEngine = htmlGmap.getEngine();
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
            @Override
            public void changed(ObservableValue<? extends State> observableValue, State oldState, State newState) {
                if (newState == State.SUCCEEDED) {
                	
                	JSObject jdoc = (JSObject) webEngine.getDocument();
                	// Object str = jdoc.getMember("current");
                	// System.out.println(str.toString());
                	
                }
            }
        });


        URL urlGoogleMaps = getClass().getResource("search.html");
        webEngine.load(urlGoogleMaps.toExternalForm());
    }

    @FXML
    protected void handleButton1Action(ActionEvent event){
    	WebEngine webEngine = htmlGmap.getEngine();
    	String val = (String) webEngine.executeScript("document.getElementById('status').innerHTML");
    	System.out.println(val);
    	
    	if (!val.equals("")) {
        	list.getItems().add(val);
    	}
    	else {
            System.out.println("Please choose spots from map");
    	}
    }
}
