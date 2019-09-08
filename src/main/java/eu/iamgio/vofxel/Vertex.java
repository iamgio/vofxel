package eu.iamgio.vofxel;

/**
 * Represents a cube vertex
 * @author Giorgio Garofalo
 */
public class Vertex {

    private float x;
    private float y;
    private float z;

    private int red;
    private int green;
    private int blue;

    Vertex(float x, float y, float z, int red, int green, int blue) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public String toString() {
        return "Vertex[" + x + ", " + y + ", " + z + "]";
    }

    /**
     * @return vertex X coordinate
     */
    public float getX() {
        return x;
    }

    /**
     * @return vertex Y coordinate
     */
    public float getY() {
        return y;
    }

    /**
     * @return vertex Z coordinate
     */
    public float getZ() {
        return z;
    }

    /**
     * @return vertex red color
     */
    public int getRed() {
        return red;
    }

    /**
     * @return vertex green color
     */
    public int getGreen() {
        return green;
    }

    /**
     * @return vertex blue color
     */
    public int getBlue() {
        return blue;
    }
}
