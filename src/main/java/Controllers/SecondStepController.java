package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class SecondStepController implements Initializable
{
    private WizardController wizardController;
    Locale locale = Locale.getDefault();
    ResourceBundle resources = ResourceBundle.getBundle("bundles/messages",locale);

    public void setWizardController(WizardController wizardController)
    {
        this.wizardController = wizardController;
    }

    public void showThird(MouseEvent mouseEvent)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/ThirdStepWizard.fxml"),resources);
        try
        {
            Parent sceneMain = loader.load();
            ThirdStepController controller = loader.<ThirdStepController>getController();
            wizardController.getBorderPane().setCenter(sceneMain);
            controller.setWizardController(wizardController);
            controller.init();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void init()
    {
        wizardController.getSecondIcon().setOpacity(1.0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
