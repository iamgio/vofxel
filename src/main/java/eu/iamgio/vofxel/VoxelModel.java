package eu.iamgio.vofxel;

import javafx.scene.Group;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Represents a voxel model built by cubes
 * @author Giorgio Garofalo
 */
public class VoxelModel extends Group {

    /**
     * Loads a {@link VoxelModel} from an input stream
     * @param inputStream .ply input stream
     * @throws IOException if an error occurs
     */
    public void load(InputStream inputStream) throws IOException {
        PlyParser parser = new PlyParser(inputStream);
        List<Cube> cubes = parser.parse().group();
        for(Cube cube : cubes) {
            getChildren().add(cube);
        }
    }

    /**
     * Loads a {@link VoxelModel} from an input stream
     * @param file .ply file
     * @throws IOException if an error occurs
     */
    public void load(File file) throws IOException {
        load(new FileInputStream(file));
    }

    /**
     * Gets a specific {@link Cube} by index
     * @param index cube index
     * @return corresponding cube
     */
    public Cube getCube(int index) {
        return (Cube) getChildren().get(index);
    }
}
