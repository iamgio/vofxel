package eu.iamgio.vofxel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Giorgio Garofalo
 */
public class PlyParser {

    private List<String> lines = new ArrayList<>();

    public PlyParser(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        boolean ignore = true;
        while(reader.ready() && (line = reader.readLine()) != null) {
            if(!ignore) lines.add(line);
            if(line.equals("end_header")) ignore = false;
        }
    }

    public PlyParser(File file) throws IOException {
        this(new FileInputStream(file));
    }

    public List<String> getLines() {
        return lines;
    }
}
