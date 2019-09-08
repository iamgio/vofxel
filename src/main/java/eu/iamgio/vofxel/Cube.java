package eu.iamgio.vofxel;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

import java.util.Arrays;

/**
 * Represents a cube which composes a voxel model
 * @author Giorgio Garofalo
 */
public class Cube extends Box {

    public static final float SIZE = .1f;

    private Vertex[] vertices;

    Cube(Vertex[] vertices) {
        this.vertices = vertices;
        setWidth(SIZE);
        setHeight(SIZE);
        setDepth(SIZE);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(new Color(vertices[0].getRed() / 255.0, vertices[0].getGreen() / 255.0, vertices[0].getBlue() / 255.0, 1));
        material.setSpecularColor(material.getDiffuseColor());
        this.setMaterial(material);
        setTranslateX(getVertices()[0].getX());
        setTranslateY(getVertices()[0].getY());
        setTranslateZ(getVertices()[0].getZ());
    }

    @Override
    public String toString() {
        return "Cube" + Arrays.toString(vertices);
    }

    /**
     * @return 8 vertices which compose the cube
     */
    public Vertex[] getVertices() {
        return vertices;
    }

    /**
     * Moves the cube along X-axis slots
     * @param x slots amount
     */
    public void moveX(int x) {
        setTranslateX(getTranslateX() + SIZE * x);
    }

    /**
     * Moves the cube along Y-axis slots
     * @param y slots amount
     */
    public void moveY(int y) {
        setTranslateY(getTranslateY() + SIZE * y);
    }

    /**
     * Moves the cube along Z-axis slots
     * @param z slots amount
     */
    public void moveZ(int z) {
        setTranslateZ(getTranslateZ() + SIZE * z);
    }
}
