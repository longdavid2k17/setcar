package Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ThirdStepController implements Initializable
{
    private WizardController wizardController;
    private Locale locale = Locale.getDefault();
    private ResourceBundle resources = ResourceBundle.getBundle("bundles/messages",locale);
    final ToggleGroup firstGroup = new ToggleGroup();

    @FXML
    private RadioButton answer1Btn,answer2Btn,answer3Btn,answer4Btn;

    @FXML
    private TextField fromField,toField;


    public void setWizardController(WizardController wizardController)
    {
        this.wizardController = wizardController;
    }

    public void init()
    {
        wizardController.getThirdIcon().setOpacity(1.0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        answer1Btn.setToggleGroup(firstGroup);
        answer2Btn.setToggleGroup(firstGroup);
        answer3Btn.setToggleGroup(firstGroup);
        answer4Btn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                if(answer4Btn.isSelected())
                {
                    fromField.setDisable(true);
                    toField.setDisable(true);
                }
                else
                {
                    fromField.setDisable(false);
                    toField.setDisable(false);
                }
            }
        });
    }

    public void showNext(MouseEvent mouseEvent)
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

    public void goBack(MouseEvent mouseEvent)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/SecondStepWizard.fxml"),resources);
        try
        {
            Parent sceneMain = loader.load();
            SecondStepController controller = loader.<SecondStepController>getController();
            wizardController.getBorderPane().setCenter(sceneMain);
            controller.setWizardController(wizardController);
            controller.setAnswers();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void setAnswers()
    {

    }
}
