package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class FifthStepController implements Initializable
{
    private WizardController wizardController;
    private Locale locale = Locale.getDefault();
    private ResourceBundle resources = ResourceBundle.getBundle("bundles/messages",locale);

    public void goBack(ActionEvent actionEvent)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/FourthStepWizard.fxml"),resources);
        try
        {
            Parent sceneMain = loader.load();
            FourthStepController controller = loader.<FourthStepController>getController();
            wizardController.getBorderPane().setCenter(sceneMain);
            controller.setWizardController(wizardController);
            controller.init();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void goNext(ActionEvent actionEvent)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/FinalStepWizard.fxml"),resources);
        try
        {
            Parent sceneMain = loader.load();
            FinalStepController controller = loader.<FinalStepController>getController();
            wizardController.getBorderPane().setCenter(sceneMain);
            controller.setWizardController(wizardController);
            controller.init(5);
            // TODO przekazanie finalnej wersji listy oraz wartosci ile pozycji ma zostac wyswietlonych
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void init()
    {
        wizardController.getFifthIcon().setOpacity(1.0);
    }

    public void setWizardController(WizardController wizardController)
    {
        this.wizardController = wizardController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
