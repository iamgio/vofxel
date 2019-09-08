package eu.iamgio.vofxel;

import java.util.ArrayList;
import java.util.List;

/**
 * List of ungrouped vertices
 * @author Giorgio Garofalo
 */
public class VertexList extends ArrayList<Vertex> {

    /**
     * Groups list of vertices into list of cubes
     * @return cubes list
     * @throws VofxelException if list size is not multiple of 4
     */
    public List<Cube> group() throws VofxelException {
        if(size() % 4 != 0) throw new VofxelException("List size not multiple of 4");
        List<Cube> cubes = new ArrayList<>();
        Vertex[] vertices = new Vertex[4];
        int vertexIndex = 0;
        for(int i = 1; i <= size(); i++) {
            vertices[vertexIndex] = get(i - 1);
            if(i % 4 == 0) {
                cubes.add(new Cube(vertices));
                vertexIndex = 0;
            }
        }
        return cubes;
    }
}
