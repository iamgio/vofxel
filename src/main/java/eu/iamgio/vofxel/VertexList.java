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
     * @throws VofxelException if list size is not multiple of 8
     */
    public List<Cube> group() throws VofxelException {
        if(size() % 8 != 0) throw new VofxelException("List size not multiple of 8");
        List<Cube> cubes = new ArrayList<>();
        Vertex[] vertices = new Vertex[8];
        int vertexIndex = 0;
        for(int i = 0; i < size(); i++) {
            vertices[vertexIndex] = get(i);
            if(vertexIndex == 7) {
                cubes.add(new Cube(vertices));
                vertices = new Vertex[8];
                vertexIndex = 0;
            } else {
                vertexIndex++;
            }
        }
        return cubes;
    }
}
