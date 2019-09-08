package eu.iamgio.vofxel;

/**
 * Represents a cube which composes a voxel model
 * @author Giorgio Garofalo
 */
public class Cube {

    private Vertex[] vertices;

    Cube(Vertex[] vertices) {
        this.vertices = vertices;
    }

    /**
     * @return 4 vertices which compose the cube
     */
    public Vertex[] getVertices() {
        return vertices;
    }
}
