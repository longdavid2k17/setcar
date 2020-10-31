package Utils;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class FXMLUtils
{
    private static double xOffset = 0;
    private static double yOffset = 0;

    public static Pane fxmlLoader(String fxmlPath)
    {
        FXMLLoader loader = new FXMLLoader(FXMLUtils.class.getResource(fxmlPath));
        loader.setResources(getResourceBundle());
        try
        {
            return loader.load();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static FXMLLoader getLoader(String fxmlPath)
    {
        FXMLLoader loader = new FXMLLoader(FXMLUtils.class.getResource(fxmlPath));
        loader.setResources(getResourceBundle());
        return loader;
    }


    public static ResourceBundle getResourceBundle()
    {
        return ResourceBundle.getBundle("bundles/messages");
    }

    public static void makeWindowDragable(Scene sceneMain, Stage stage)
    {
        sceneMain.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        sceneMain.setOnMouseDragged(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
                stage.setOpacity(0.8f);
            }
        });

        sceneMain.setOnDragDone(new EventHandler<DragEvent>()
        {
            @Override
            public void handle(DragEvent dragEvent)
            {
                stage.setOpacity(1.0f);
            }
        });

        sceneMain.setOnMouseReleased(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                stage.setOpacity(1.0f);
            }
        });
    }
}
