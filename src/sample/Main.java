package sample;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;



public class Main extends Application {

    private Scene scene;
    MyBrowser myBrowser;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TravelAssistant");
        myBrowser = new MyBrowser();
        primaryStage.setScene(new Scene(myBrowser, 640, 480));
        primaryStage.show();
    }

    class MyBrowser extends Region{

        HBox toolbar;

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        public MyBrowser(){

            final URL urlGoogleMaps = getClass().getResource("search.html");
            webEngine.load(urlGoogleMaps.toExternalForm());

            getChildren().add(webView);

        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}

