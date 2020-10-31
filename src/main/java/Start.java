import Controllers.LoadingScreenController;
import Utils.FXMLUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Locale;
import java.util.ResourceBundle;

public class Start extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Locale locale = Locale.getDefault();
        ResourceBundle resources = ResourceBundle.getBundle("bundles/messages",locale);

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/LoadingScreen.fxml"),resources);
        Parent sceneMain = loader.load();
        LoadingScreenController controller = loader.<LoadingScreenController>getController();
        controller.initialize();
        Scene scene = new Scene(sceneMain);
        FXMLUtils.makeWindowDragable(scene,stage);
        scene.getStylesheets().add("/css/style.css");
        stage.setTitle("SetCar");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.getIcons().add(new Image(Start.class.getResourceAsStream("icon/app_icon.png")));
        stage.setScene(scene);
        stage.show();
    }
}
