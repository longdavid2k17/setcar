package Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class SearchEngineController implements Initializable
{
    @FXML
    private BorderPane borderPane;

    Locale locale = Locale.getDefault();
    ResourceBundle resources = ResourceBundle.getBundle("bundles/messages",locale);
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

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


}
