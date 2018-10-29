package sample;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Window;
import javafx.stage.Stage;
import java.net.URL;
import javafx.concurrent.Worker;
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
                    JSObject window = (JSObject) webEngine.executeScript("window");
                    JavaBridge bridge = new JavaBridge();
                    /* The two objects are named using the setMember() method. */
                    window.setMember("java", bridge);
                    webEngine.executeScript("console.log = function(message)\n" +
                            "{\n" +
                            "    java.log(message);\n" +
                            "};");
                }
            }
        });




        URL urlGoogleMaps = getClass().getResource("search.html");
        webEngine.load(urlGoogleMaps.toExternalForm());
    }




    @FXML
    protected void handleButton1Action(ActionEvent event){
        list.getItems().add("Please choose spots from map");


    }


}
