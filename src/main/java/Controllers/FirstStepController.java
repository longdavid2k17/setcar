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
import java.util.Locale;
import java.util.ResourceBundle;

public class FirstStepController implements Initializable
{
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

    public void showSecondStep(MouseEvent mouseEvent)
    {
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
