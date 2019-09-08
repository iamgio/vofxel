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

    private Vertex[] vertices;

    Cube(Vertex[] vertices) {
        this.vertices = vertices;
        setWidth(0.1);
        setHeight(0.1);
        setDepth(0.1);
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
     * @return 4 vertices which compose the cube
     */
    public Vertex[] getVertices() {
        return vertices;
    }
}
