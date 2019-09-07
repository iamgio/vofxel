package eu.iamgio.vofxel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Main parser for PLY files
 * @author Giorgio Garofalo
 */
public class PlyParser {

    private List<String> lines = new ArrayList<>();

    /**
     * Instantiates a {@link PlyParser} and loads lines from given {@link InputStream}
     * @param inputStream .ply input stream
     * @throws IOException if an error occurs
     */
    public PlyParser(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        boolean ignore = true;
        while(reader.ready() && (line = reader.readLine()) != null) {
            if(!ignore) lines.add(line);
            if(line.equals("end_header")) ignore = false;
        }
    }

    /**
     * Instantiates a {@link PlyParser} and loads lines from given {@link File}
     * @param file .ply file
     * @throws IOException if an error occurs
     */
    public PlyParser(File file) throws IOException {
        this(new FileInputStream(file));
    }

    /**
     * @return lines which include vertices information. Header ones are ignored
     */
    public List<String> getLines() {
        return lines;
    }
}
