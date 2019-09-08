package eu.iamgio.vofxel;

import java.util.Arrays;

/**
 * Represents a cube which composes a voxel model
 * @author Giorgio Garofalo
 */
public class Cube {

    private Vertex[] vertices;

    Cube(Vertex[] vertices) {
        this.vertices = vertices;
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
