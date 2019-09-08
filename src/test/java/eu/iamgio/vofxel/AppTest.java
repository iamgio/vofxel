package eu.iamgio.vofxel;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Giorgio Garofalo
 */
public class AppTest extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        PerspectiveCamera camera = new PerspectiveCamera(true);
        Rotate cameraRotateX = new Rotate(-45, Rotate.X_AXIS);
        Rotate cameraRotateY = new Rotate(180, Rotate.Y_AXIS);
        Rotate cameraRotateZ = new Rotate(0, Rotate.Z_AXIS);
        Translate cameraTranslate = new Translate(-1, -1, -10);
        camera.getTransforms().addAll(
                cameraRotateX,
                cameraRotateY,
                cameraRotateZ,
                cameraTranslate);
        root.getChildren().add(camera);

        InputStream inputStream = PlyParser.class.getResourceAsStream("/castle.ply");
        PlyParser parser = new PlyParser(inputStream);
        List<Cube> cubes = parser.parse().group();
        for(Cube cube : cubes) {
            root.getChildren().add(cube);
        }

        Scene scene = new Scene(root, 800, 450, true);
        stage.setTitle("Test 3D");
        stage.setScene(scene);
        scene.setFill(Color.GRAY);
        scene.setCamera(camera);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
