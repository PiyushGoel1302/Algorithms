/**
 * Edge class represents an edge of the graph
 * containing source and destination
 * along with weight of the edge.
 */

public class Edge
{
    public Vertex fromVertex;
    public Vertex toVertex;
    public double weight;

    public Edge(Vertex fromVertex, Vertex toVertex, double weight) {
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.weight = weight;
    }

    public String toString()
    {
        return String.format(fromVertex.toString() + "\t\t" + toVertex.toString() + "\t" + weight);
    }
}
