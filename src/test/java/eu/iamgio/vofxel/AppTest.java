package eu.iamgio.vofxel;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Giorgio Garofalo
 */
public class AppTest extends Application {

    private double oldMouseX, oldMouseY;

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        PerspectiveCamera camera = new PerspectiveCamera(true);
        Rotate cameraRotateX = new Rotate(-45, Rotate.X_AXIS);
        Rotate cameraRotateY = new Rotate(0, Rotate.Y_AXIS);
        Rotate cameraRotateZ = new Rotate(0, Rotate.Z_AXIS);
        Translate cameraTranslate = new Translate(1, -2, -10);
        camera.getTransforms().addAll(
                cameraRotateX,
                cameraRotateY,
                cameraRotateZ,
                cameraTranslate);
        root.getChildren().add(camera);


        VoxelModel model = new VoxelModel();
        // Load from file
        model.load(getClass().getResourceAsStream("/castle.ply"));
        // Rotate it properly
        model.getTransforms().add(new Rotate(60, Rotate.X_AXIS));
        root.getChildren().add(model);
        // Add some cubes manually
        Cube cube1 = model.addCube();
        cube1.setMaterial(new PhongMaterial(Color.RED));
        cube1.moveZ(-10);
        Cube cube2 = model.addCube();
        cube2.setMaterial(new PhongMaterial(Color.BLUE));
        cube2.moveX(-10);

        Scene scene = new Scene(root, 800, 450, true, SceneAntialiasing.BALANCED);

        scene.setOnMouseMoved(e -> {
            cameraRotateX.setAngle(cameraRotateX.getAngle() - (e.getSceneY() - oldMouseY) / 20);
            cameraRotateY.setAngle(cameraRotateY.getAngle() + (e.getSceneX() - oldMouseX) / 20);
            oldMouseX = e.getSceneX();
            oldMouseY = e.getSceneY();
        });
        scene.setOnKeyPressed(e -> {
            switch(e.getCode()) {
                case UP:
                    cameraTranslate.setY(cameraTranslate.getY() - 0.05);
                    break;
                case DOWN:
                    cameraTranslate.setY(cameraTranslate.getY() + 0.05);
                    break;
                case RIGHT:
                    cameraTranslate.setX(cameraTranslate.getX() + 0.05);
                    break;
                case LEFT:
                    cameraTranslate.setX(cameraTranslate.getX() - 0.05);
                    break;
                case A:
                    cameraTranslate.setZ(cameraTranslate.getZ() - 0.05);
                    break;
                case Z:
                    cameraTranslate.setZ(cameraTranslate.getZ() + 0.05);
                    break;
            }
        });

        stage.setTitle("Demo");
        stage.setScene(scene);
        scene.setFill(Color.GRAY);
        scene.setCamera(camera);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
