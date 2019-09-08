package eu.iamgio.vofxel;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Gio
 */
class VofxelTest {

    @Test
    void test() throws IOException {
        InputStream inputStream = PlyParser.class.getResourceAsStream("/3x3x3.ply");
        PlyParser parser = new PlyParser(inputStream);
        VertexList vertices = parser.parse();
        assertEquals(288, vertices.size());
        List<Cube> cubes = vertices.group();
        assertEquals(72, cubes.size());
        Cube cube = cubes.get(0);
        Vertex vertex = cube.getVertices()[0];
        assertEquals(0, vertex.getX());
        assertEquals(0.2, vertex.getY());
        assertEquals(0.3, vertex.getZ());
    }
}
