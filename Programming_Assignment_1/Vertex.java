import java.util.ArrayList;
import java.util.List;

/**
 * Vertex represents vertex of an graph
 * containing index and list of edges
 * from the particular vertex
 */
public class Vertex
{
    public int index;
    public List<Edge> edges = new ArrayList<>();

    /**
     * @param index: Index of the vertex of the graph
     */
    public Vertex(int index) {
        this.index = index;
    }

    /**
     * Update the list of edges of the particular vertex
     * @param e: Edge to be added
     */
    public void addEdge(Edge e)
    {
        edges.add(e);
    }

    public String toString()
    {
        return String.format(index+"");
    }

}
