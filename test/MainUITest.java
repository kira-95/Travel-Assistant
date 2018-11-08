import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import static org.testfx.api.FxAssert.*;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class MainUITest extends ApplicationTest {
    private SpotsCollection sc = new SpotsCollection();
    private List<String> listCompare = new ArrayList<String>();
    private ListView<String> list;
    private String spotInfo1, spotInfo2, spotInfo3;
     Label text;

    @Override
    public void start(Stage primaryStage) throws Exception{
         text = new Label();
         text.setId("text");
        Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
        primaryStage.setTitle("TravelAssistant");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Before
    public void setUp () throws Exception {
    }

    @After
    public void tearDown () throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    /**
     * test button: add location
     * since testfix can not test the content of javascript, we can not get value from webview
     * the result show be "No Spot Information Found!"
     */
    @Test
    public void testAddLocation () {
        clickOn("#button1");
        verifyThat("#text", hasText("No Spot Information Found!"));
    }

    /**
     * test button:delete location
     */
    @Test
    public void testDeleteLocation(){
        clickOn("#delete");
        verifyThat("#text", hasText("Spot List is Already Empty!"));
    }

    /**
     * test button: generate trip plan
     */
    @Test
    public void testGeneratePlan(){
        clickOn("#buttonGenerate");
        verifyThat("#text", hasText("Can not generate the route!"));
    }

}




