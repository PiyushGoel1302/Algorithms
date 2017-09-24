

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *Class containing Algorithm implementation
 */

public class KruskalAlgorithm {

    /**
     * Kruskal's Algorithm functionality
     * function Execute:
     * @param g: User input graph
     * @param set: object of the Disjoint set we
     *           want to implement
     */

    public void execute(Graph g, DisjointSet set)
    {
        for (Vertex vertex : g.getAllVertex())
        {
            set.makeSet(vertex.index);
        }
        List<Edge> result = new ArrayList<>();
        Collections.sort(g.allEdges,((o1, o2) -> (int)(o1.weight-o2.weight)));
        for(Edge edge : g.allEdges)
        {
            int index1 = edge.fromVertex.index;
            int index2 = edge.toVertex.index;

            if(set.findSet(index1)!= set.findSet(index2))
            {
                result.add(edge);
                set.union(index1,index2);
            }
        }
        printMST(result);

    }

    /**
     * Print output of Kruskal's Algorithm
     * @param result: List of edges forming MST
     */

    private void printMST(List<Edge> result)
    {
        System.out.println("\nKruskal Algorithm");
        System.out.println("From\tTo\tWeight");

        for(Edge m : result)
        {
            System.out.println( m.toString());
        }
    }
}
