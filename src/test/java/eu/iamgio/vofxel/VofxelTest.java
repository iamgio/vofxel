package eu.iamgio.vofxel;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Gio
 */
class VofxelTest {

    @Test
    void testRead() throws IOException {
        InputStream inputStream = PlyParser.class.getResourceAsStream("/3x3x3.ply");
        PlyParser parser = new PlyParser(inputStream);
        System.out.println(parser.getLines());
    }
}
