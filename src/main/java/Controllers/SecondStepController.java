package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class SecondStepController implements Initializable
{
    @FXML
    private RadioButton answer1Btn,answer2Btn,answer3Btn,answer4Btn,answer5Btn,answer6Btn;

    private WizardController wizardController;
    Locale locale = Locale.getDefault();
    ResourceBundle resources = ResourceBundle.getBundle("bundles/messages",locale);
    final ToggleGroup firstGroup = new ToggleGroup();
    final ToggleGroup secondGroup = new ToggleGroup();

    public void setWizardController(WizardController wizardController)
    {
        this.wizardController = wizardController;
    }

    public void showNext(MouseEvent mouseEvent)
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

    public void goBack(MouseEvent mouseEvent)
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

    public void init()
    {
        wizardController.getSecondIcon().setOpacity(1.0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        answer1Btn.setToggleGroup(firstGroup);
        answer2Btn.setToggleGroup(firstGroup);
        answer3Btn.setToggleGroup(firstGroup);
        answer4Btn.setToggleGroup(secondGroup);
        answer5Btn.setToggleGroup(secondGroup);
        answer6Btn.setToggleGroup(secondGroup);
    }

    public void setAnswers()
    {

    }


}
