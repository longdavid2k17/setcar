package Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class FirstStepController implements Initializable
{
    // TODO walidacja odpowiedzi i przekazanie listy
    private List<String> wizardAnswersList;

    @FXML
    private RadioButton yesRadioBtn,noRadioBtn;

    @FXML
    private ChoiceBox producerBox;

    @FXML
    private ImageView imageView;

    @FXML
    private RadioButton smallCarRadioBtn, normalCarRadioBtn,bigCarRadioBtn,sportCarRadioBtn;

    @FXML
    private ImageView smallCarImage, normalCarImage,bigCarImage,sportCarImage;

    private WizardController wizardController;
    Locale locale = Locale.getDefault();
    ResourceBundle resources = ResourceBundle.getBundle("bundles/messages",locale);

    final ToggleGroup firstGroup = new ToggleGroup();
    final ToggleGroup secondGroup = new ToggleGroup();

    public List<String> getWizardAnswersList()
    {
        return wizardAnswersList;
    }

    public void setWizardAnswersList(List<String> wizardAnswersList)
    {
        this.wizardAnswersList = wizardAnswersList;
    }

    public void init()
    {
        wizardController.getFirstIcon().setOpacity(1.0);
        wizardController.getSecondIcon().setOpacity(0.5);
        wizardController.getThirdIcon().setOpacity(0.5);
        wizardController.getFourthIcon().setOpacity(0.5);
        wizardController.getFifthIcon().setOpacity(0.5);
        wizardController.getSixthIcon().setOpacity(0.5);
    }

    public void setAnswers()
    {
        // TODO tutaj ustawiamy odpowiedzi z listy przekazanej wcześniej seterem, z widoków późniejszych przy cofaniu się
        if(getWizardAnswersList().get(0)=="Yes")
        {

        }
        else
        {

        }
    }

    public void showSecondStep(MouseEvent mouseEvent)
    {
        // TODO zapisywanie odpowiedzi do listy i przekazanie jej w inicie do drugiego kontrolera
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
        // TODO pobranie i umieszczenie producentów w choiceBoxie
        producerBox.getItems().add("Audi");
        producerBox.getItems().add("BMW");
        producerBox.getItems().add("Citroen");
        producerBox.getItems().add("Dacia");
        producerBox.getItems().add("Ford");
        producerBox.getItems().add("Mercedes-BENZ");

        imageView.setPreserveRatio(true);
        yesRadioBtn.setToggleGroup(firstGroup);
        noRadioBtn.setToggleGroup(firstGroup);

        smallCarRadioBtn.setToggleGroup(secondGroup);
        normalCarRadioBtn.setToggleGroup(secondGroup);
        bigCarRadioBtn.setToggleGroup(secondGroup);
        sportCarRadioBtn.setToggleGroup(secondGroup);

        noRadioBtn.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
            {
                producerBox.setDisable(true);
            }
        });

        yesRadioBtn.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
            {
                    producerBox.setDisable(false);
            }
        });

        smallCarRadioBtn.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
            {
                smallCarImage.setOpacity(1.0);
                normalCarImage.setOpacity(0.5);
                bigCarImage.setOpacity(0.5);
                sportCarImage.setOpacity(0.5);
            }
        });

        normalCarRadioBtn.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
            {
                smallCarImage.setOpacity(0.5);
                normalCarImage.setOpacity(1.0);
                bigCarImage.setOpacity(0.5);
                sportCarImage.setOpacity(0.5);
            }
        });

        bigCarRadioBtn.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
            {
                smallCarImage.setOpacity(0.5);
                normalCarImage.setOpacity(0.5);
                bigCarImage.setOpacity(1.0);
                sportCarImage.setOpacity(0.5);
            }
        });

        sportCarRadioBtn.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
            {
                smallCarImage.setOpacity(0.5);
                normalCarImage.setOpacity(0.5);
                bigCarImage.setOpacity(0.5);
                sportCarImage.setOpacity(1.0);
            }
        });
    }

    

    public void clear(ActionEvent actionEvent)
    {
        noRadioBtn.setSelected(false);
        yesRadioBtn.setSelected(false);
        smallCarRadioBtn.setSelected(false);
        normalCarRadioBtn.setSelected(false);
        bigCarRadioBtn.setSelected(false);
        sportCarRadioBtn.setSelected(false);
        producerBox.getSelectionModel().clearSelection();
        producerBox.setDisable(true);
        smallCarImage.setOpacity(0.5);
        normalCarImage.setOpacity(0.5);
        bigCarImage.setOpacity(0.5);
        sportCarImage.setOpacity(0.5);
    }


}
