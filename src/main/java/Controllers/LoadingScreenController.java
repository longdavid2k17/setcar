package Controllers;

import Database.DatabaseConnector;
import Utils.FXMLUtils;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoadingScreenController
{
    @FXML
    private Circle biggerCircle;

    @FXML
    private Circle smallerCircle;

    @FXML
    private Label status;

    @FXML
    private Button wizardBtn;

    @FXML
    private Button dbBtn;

    Locale locale = Locale.getDefault();
    private Logger logger = LoggerFactory.getLogger(LoadingScreenController.class);
    ResourceBundle bundle = ResourceBundle.getBundle("bundles/messages",locale);



    private void setRotate(Circle c, boolean reverse, int angle, int duration)
    {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration),c);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setDelay(Duration.seconds(1));
        rotateTransition.setRate(3);
        rotateTransition.setCycleCount(20);
        rotateTransition.play();
        logger.debug("Uruchomiono animację "+c.getId());
    }

    public void initialize()
    {
        if(logger.isDebugEnabled())
        {
            logger.debug("Zainicjowano pobieranie");
        }
        setRotate(biggerCircle,true,360,15);
        setRotate(smallerCircle,true,180,30);
        Thread animationThread = new Thread()
        {
            public void run()
            {
                Platform.runLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        do
                        {
                            DatabaseConnector.setConnection();
                        }
                        while (DatabaseConnector.isConnectionSetted()!=true);
                        status.setVisible(false);
                        wizardBtn.setVisible(true);
                        dbBtn.setVisible(true);
                    }
                });
            }
        };

        animationThread.start();

    }

    public void runWizard(ActionEvent actionEvent)
    {
        try
        {
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/Wizard.fxml"),bundle);
            Parent sceneMain = loader.load();
            WizardController controller = loader.<WizardController>getController();
            Scene dashboard = new Scene(sceneMain);
            Stage window = new Stage();
            window.initStyle(StageStyle.UNDECORATED);
            window.getIcons().add(new Image(LoadingScreenController.class.getResourceAsStream("/icon/app_icon.png")));
            FXMLUtils.makeWindowDragable(dashboard,window);
            window.setScene(dashboard);
            window.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void runSearchEngine(ActionEvent actionEvent)
    {
        try
        {
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/SearchEngine.fxml"),bundle);
            Parent sceneMain = loader.load();
            SearchEngineController controller = loader.<SearchEngineController>getController();
            Scene dashboard = new Scene(sceneMain);
            Stage window = new Stage();
            window.initStyle(StageStyle.UNDECORATED);
            window.getIcons().add(new Image(LoadingScreenController.class.getResourceAsStream("/icon/app_icon.png")));
            FXMLUtils.makeWindowDragable(dashboard,window);
            window.setScene(dashboard);
            window.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
