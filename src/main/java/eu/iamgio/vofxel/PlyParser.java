package eu.iamgio.vofxel;

import java.io.*;

/**
 * Main parser for PLY files
 * @author Giorgio Garofalo
 */
public class PlyParser {

    private InputStream inputStream;

    /**
     * Instantiates a {@link PlyParser}
     * @param inputStream .ply input stream
     */
    public PlyParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Instantiates a {@link PlyParser}
     * @param file .ply file
     */
    public PlyParser(File file) throws IOException {
        this(new FileInputStream(file));
    }

    /**
     * Parses the input stream into a list of vertices
     * @throws IOException if an error occurs
     * @return list of vertices
     */
    public VertexList parse() throws IOException {
        VertexList vertices = new VertexList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        boolean ignore = true;
        while(reader.ready() && (line = reader.readLine()) != null) {
            if(!ignore) {
                String[] parts = line.split(" ");
                if(parts.length != 6) continue;
                Vertex vertex = new Vertex(
                        Float.parseFloat(parts[0]),
                        Float.parseFloat(parts[1]),
                        Float.parseFloat(parts[2]),
                        Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]),
                        Integer.parseInt(parts[5])
                );
                vertices.add(vertex);
            }
            if(line.equals("end_header")) ignore = false;
        }
        return vertices;
    }
}
