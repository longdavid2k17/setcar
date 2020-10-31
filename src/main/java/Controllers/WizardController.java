package Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class WizardController implements Initializable
{
    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView firstIcon,secondIcon,thirdIcon,fourthIcon,fifthIcon,sixthIcon;

    Locale locale = Locale.getDefault();
    ResourceBundle resources = ResourceBundle.getBundle("bundles/messages",locale);
    private Stage stage;
    private WizardController wizardController;

    public void minimize(MouseEvent mouseEvent)
    {
        stage = (Stage)borderPane.getScene().getWindow();
        stage.setIconified(true);
    }

    public void maximize(MouseEvent mouseEvent)
    {
        stage = (Stage)borderPane.getScene().getWindow();
        stage.setMaximized(!stage.isMaximized());
    }

    public void close(MouseEvent mouseEvent)
    {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle(resources.getString("exit.title"));
        DialogPane dialogPane = confirmationDialog.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/css/exit_style.css").toExternalForm());
        dialogPane.getStyleClass().add("dialog");
        confirmationDialog.setHeaderText(resources.getString("exit.header"));
        Stage stage = (Stage) confirmationDialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(SearchEngineController.class.getResourceAsStream("/icon/app_icon.png")));
        Optional<ButtonType> result = confirmationDialog.showAndWait();
        if(result.get()==ButtonType.OK)
        {
            Platform.exit();
            System.exit(0);
        }
    }

    public BorderPane getBorderPane()
    {
        return borderPane;
    }

    public ImageView getFirstIcon()
    {
        return firstIcon;
    }

    public ImageView getSecondIcon()
    {
        return secondIcon;
    }

    public ImageView getThirdIcon()
    {
        return thirdIcon;
    }

    public ImageView getFourthIcon()
    {
        return fourthIcon;
    }

    public ImageView getFifthIcon()
    {
        return fifthIcon;
    }

    public ImageView getSixthIcon()
    {
        return sixthIcon;
    }

    public void setWizardController(WizardController wizardController)
    {
        this.wizardController = wizardController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        setWizardController(this);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/FirstStepWizard.fxml"),resources);
        try
        {
            Parent sceneMain = loader.load();
            FirstStepController controller = loader.<FirstStepController>getController();
            borderPane.setCenter(sceneMain);
            controller.setWizardController(wizardController);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void loadUI(String name)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/"+name));
            borderPane.setCenter(loader.load());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
