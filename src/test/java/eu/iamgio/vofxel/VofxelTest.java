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
    void testRead() throws IOException {
        InputStream inputStream = PlyParser.class.getResourceAsStream("/3x3x3.ply");
        PlyParser parser = new PlyParser(inputStream);
        VertexList vertices = parser.parse();
        assertEquals(288, vertices.size());
        List<Cube> cubes = vertices.group();
        assertEquals(72, cubes.size());
    }
}
