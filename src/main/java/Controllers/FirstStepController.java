package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class FirstStepController implements Initializable
{
    private WizardController wizardController;
    Locale locale = Locale.getDefault();
    ResourceBundle resources = ResourceBundle.getBundle("bundles/messages",locale);

    public void showSecond(MouseEvent mouseEvent)
    {
        //wizardController.loadUI("SecondStepWizard.fxml");
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/SecondStepWizard.fxml"),resources);
        try
        {
            Parent sceneMain = loader.load();
            SecondStepController controller = loader.<SecondStepController>getController();
            wizardController.getBorderPane().setCenter(sceneMain);
            controller.setWizardController(wizardController);
            controller.init();
            wizardController.getFirstIcon().setOpacity(1.0);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void setWizardController(WizardController wizardController)
    {
        this.wizardController = wizardController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //
    }
}
