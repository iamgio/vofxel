package eu.iamgio.vofxel;

import javafx.scene.Group;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

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
     * @return cubes in the model
     */
    public List<Cube> getCubes() {
        return getChildren().stream()
                .filter(Cube.class::isInstance)
                .map(Cube.class::cast)
                .collect(Collectors.toList());
    }

    /**
     * Gets a specific {@link Cube} by index
     * @param index cube index
     * @return corresponding cube
     */
    public Cube getCube(int index) {
        return getCubes().get(index);
    }

    /**
     * Adds a new cube to the model
     * @return the cube itself
     */
    public Cube addCube() {
        Cube cube = getCubes().isEmpty() ? new Cube(new Vertex[]{
                new Vertex(0, 0, 0, 255, 255, 255),
                new Vertex(Cube.SIZE, 0, 0, 255, 255, 255),
                new Vertex(0, Cube.SIZE, 0, 255, 255, 255),
                new Vertex(0, 0, Cube.SIZE, 255, 255, 255),
                new Vertex(Cube.SIZE, Cube.SIZE, 0, 255, 255, 255),
                new Vertex(Cube.SIZE, 0, Cube.SIZE, 255, 255, 255),
                new Vertex(0, Cube.SIZE, Cube.SIZE, 255, 255, 255),
                new Vertex(Cube.SIZE, Cube.SIZE, Cube.SIZE, 255, 255, 255)
        }) : new Cube(getCube(0).getVertices());
        getChildren().add(cube);
        return cube;
    }

    /**
     * Removes a cube from the model
     * @param cube cube instance
     */
    public void removeCube(Cube cube) {
        getChildren().remove(cube);
    }

    /**
     * Removes a cube from the model
     * @param index cube index
     */
    public void removeCube(int index) {
        getChildren().remove(index);
    }

    /**
     * @return model width
     */
    public int getWidth() {
        List<Cube> cubes = getCubes();
        if(cubes.isEmpty()) return 0;
        double width = -1;
        for(Cube cube : cubes) {
            if(cube.getTranslateX() > width) width = cube.getTranslateX();
        }
        return (int) ((width + Cube.SIZE) / Cube.SIZE);
    }

    /**
     * @return model depth
     */
    public int getDepth() {
        List<Cube> cubes = getCubes();
        if(cubes.isEmpty()) return 0;
        double depth = -1;
        for(Cube cube : cubes) {
            if(cube.getTranslateY() > depth) depth = cube.getTranslateY();
        }
        return (int) ((depth + Cube.SIZE) / Cube.SIZE);
    }

    /**
     * @return model height
     */
    public int getHeight() {
        List<Cube> cubes = getCubes();
        if(cubes.isEmpty()) return 0;
        double height = -1;
        for(Cube cube : cubes) {
            if(cube.getTranslateZ() > height) height = cube.getTranslateZ();
        }
        return (int) ((height + Cube.SIZE) / Cube.SIZE);
    }
}
