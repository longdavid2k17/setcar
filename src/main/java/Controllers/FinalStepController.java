package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class FinalStepController implements Initializable
{
    private WizardController wizardController;
    private Locale locale = Locale.getDefault();
    private ResourceBundle resources = ResourceBundle.getBundle("bundles/messages",locale);

    @FXML
    private VBox pnItems = null;

    public void init(int count)
    {
        wizardController.getSixthIcon().setOpacity(1.0);
        Node[] nodes = new Node[count];
        for (int i = 0; i < nodes.length; i++)
        {
            try
            {
                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getClassLoader().getResource("views/CarItem.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event ->
                {
                    nodes[j].setStyle("-fx-background-color : #262829");
                });
                nodes[i].setOnMouseExited(event ->
                {
                    nodes[j].setStyle("-fx-background-color : #393C3E");
                });
                pnItems.getChildren().add(nodes[i]);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void setWizardController(WizardController wizardController)
    {
        this.wizardController = wizardController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public void restart(ActionEvent actionEvent)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/FirstStepWizard.fxml"),resources);
        try
        {
            Parent sceneMain = loader.load();
            FirstStepController controller = loader.<FirstStepController>getController();
            wizardController.getBorderPane().setCenter(sceneMain);
            controller.setWizardController(wizardController);
            controller.init();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
