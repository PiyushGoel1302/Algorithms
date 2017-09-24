import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Graph class represents provided graph
 * contains map of vertex along with functionality to
 * add an edge to the graph.
 */

public class Graph {

    // To check provided is an directed or undirected
    boolean isDirected;

    // Mapping each vertex of the graph to it's index
    public Map<Integer,Vertex> allVertex;

    /**
     *
      * @param isDirected: deciding type of graph
     */
    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        this.allVertex = new HashMap<>();
    }

    // provides all vertex of the graph
    public Collection<Vertex> getAllVertex()
    {
        return allVertex.values();
    }

    /**
     * Add an edge to the graph according to its type
     * @param index1:index of starting vertex
     * @param index2:index of target vertex
     * @param weight: weight of an edge
     */
    public void addEdge(int index1, int index2, Double weight) {
        Vertex fromVertex;
        if (allVertex.containsKey(index1))
            fromVertex = allVertex.get(index1);
        else {
            fromVertex = new Vertex(index1);
            allVertex.put(index1, fromVertex);
        }

        Vertex toVertex;
        if (allVertex.containsKey(index2))
            toVertex = allVertex.get(index2);
        else {
            toVertex = new Vertex(index2);
            allVertex.put(index2, toVertex);
        }

        Edge edge = new Edge(fromVertex, toVertex, weight);
        fromVertex.addEdge(edge);

        if (!isDirected) {
            Edge toEdge = new Edge(toVertex, fromVertex, weight);
            toVertex.addEdge(toEdge);
        }
    }
}

