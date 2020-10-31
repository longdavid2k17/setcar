package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ThirdStepController implements Initializable
{
    private WizardController wizardController;
    Locale locale = Locale.getDefault();
    ResourceBundle resources = ResourceBundle.getBundle("bundles/messages",locale);


    public void setWizardController(WizardController wizardController)
    {
        this.wizardController = wizardController;
    }

    public void showFirst(MouseEvent mouseEvent)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/FirstStepWizard.fxml"),resources);
        try
        {
            Parent sceneMain = loader.load();
            FirstStepController controller = loader.<FirstStepController>getController();
            wizardController.getBorderPane().setCenter(sceneMain);
            controller.setWizardController(wizardController);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showSecond(MouseEvent mouseEvent)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/SecondStepWizard.fxml"),resources);
        try
        {
            Parent sceneMain = loader.load();
            SecondStepController controller = loader.<SecondStepController>getController();
            wizardController.getBorderPane().setCenter(sceneMain);
            controller.setWizardController(wizardController);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void init()
    {
        wizardController.getThirdIcon().setOpacity(1.0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
