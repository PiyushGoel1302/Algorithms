import java.lang.reflect.Array;
import java.util.*;

/**
 *Class containing Algorithm implementation
 * @param <T>: Type of parent of MinHeapVertex
 */

public class ProgrammingAssignment1<T> {


    // Map to maintain index of the vertex along with its weight
    private Map<Integer,Double> weightMap = new HashMap<>();


    /**
     * Dijkstra's Algorithm functionality
     * @param graph: User input graph
     * @param source: Index of the source vertex
     * @param target: Index of the target vertex
     */
    public void dijkstraAlgorithm(Graph graph, int source, int target)
    {
        // initializing the priority queue
        PriorityQueue heap = initializeSingleSource(graph,source);
        // Stores the vertex along with its distance from the source
        List<MinHeapVertex> result = new ArrayList<>();

        while(heap.getMinHeap().size()>0)
        {
            // Extract minimum element from priority queue
            MinHeapVertex u = heap.extractMin();
            // Remove the element from map to maintain only the uncalculated one
            weightMap.remove(u.index);
            result.add(u);
            // get all the edges from vertex
            List<Edge> allEdge = graph.allVertex.get(u.index).edges;
            for(Edge edge : allEdge)
            {
                // update the priority queue
                relax(u,edge,heap);
            }

        }

        // print all the vertex along with distance and path of the
        // target vertex
        printPath(result,target);
    }

    /**
     * Prim's Algorithm implementation
     * @param graph: User input graph
     */
    public void primsAlgorithm(Graph graph)
    {
        // We initialize first element of the graph as our
        // starting point
        int source = graph.allVertex.get(0).index;
        // initializing the priority queue
        PriorityQueue heap = initializeSingleSource(graph,source);
        // Stores the edges with the minimum weight covering all the vertex
        List<Edge> result = new ArrayList<>();

        while(heap.getMinHeap().size()>0)
        {
            // Extract minimum element from priority queue
            MinHeapVertex u = heap.extractMin();
            // Remove the element from map to maintain only the uncalculated one
            weightMap.remove(u.index);

            if(u.parent!=null)
                result.add((Edge) u.parent);

            // get all the edges from vertex
            List<Edge> allEdge = graph.allVertex.get(u.index).edges;
            for(Edge edge : allEdge)
            {
                // update the priority queue
                primRelax(u,edge,heap);
            }
        }
        printMST(result);
    }

    /**
     * Update the priority according to the distance of the vertex from
     * the source
     * @param u: Starting vertex
     * @param edge: Edge between starting and target vertex
     * @param heap: Priority queue
     */
    public void relax(MinHeapVertex u, Edge edge, PriorityQueue heap)
    {
        double edgeDistance = edge.weight;
        int adjacentVertexIndex = edge.toVertex.index;
        if(!weightMap.containsKey(adjacentVertexIndex))
            return;
        double w = weightMap.get(adjacentVertexIndex);
        if(w>u.distance+edgeDistance)
        {
            weightMap.put(adjacentVertexIndex,u.distance+edgeDistance);
            heap.decrease(adjacentVertexIndex,u.distance+edge.weight,(T)u);
        }
    }

    /**
     * Update the priority for Prim Algorithm
     * @param u: Starting vertex
     * @param edge: Edge between starting and target vertex
     * @param heap: Priority queue
     */
    public void primRelax(MinHeapVertex u, Edge edge, PriorityQueue heap)
    {
        double edgeDistance = edge.weight;
        int adjacentVertexIndex = edge.toVertex.index;
        if(!weightMap.containsKey(adjacentVertexIndex))
            return;
        double w = weightMap.get(adjacentVertexIndex);
        if(w>edgeDistance)
        {
            weightMap.put(adjacentVertexIndex,edgeDistance);
            heap.decrease(adjacentVertexIndex,edge.weight, (T) edge);
        }
    }

    /**
     * Initializing the priority queue for both dijkstra's and prim's algorithm
     * @param graph: User input graph
     * @param source: Source provided by user for dijkstra's and
     *              first vertex for prim's algorithm
     * @return list of all vertex for priority queue initialization
     */
    public PriorityQueue initializeSingleSource(Graph graph, int source)
    {
        int pos = 0;
        List<MinHeapVertex> vertexArray = new ArrayList<>();
        PriorityQueue heap;
        Map<Integer,Integer> indexingMap = new HashMap<>();
        for (Vertex v : graph.getAllVertex()) {
            if (v.index == source) {
                    vertexArray.add(new MinHeapVertex(v.index, 0.0, null));
                this.weightMap.put(v.index, 0.0);
            } else {
                vertexArray.add(new MinHeapVertex(v.index, Double.POSITIVE_INFINITY, null));
                this.weightMap.put(v.index,Double.POSITIVE_INFINITY);
            }
            indexingMap.put(v.index,pos);
            pos++;
        }
        heap = new PriorityQueue(vertexArray,indexingMap);
        return heap;
    }


    /**
     * Print output of Dijkstra's Algorithm
     * @param result: List of vertex containing distance form source with parent
     * @param target: For which path of the graph need to be found
     */
    public void printPath(List<MinHeapVertex> result, int target)
    {
        System.out.println("Dijkstra Algorithm");
        System.out.println("Target\tDistance\tParent");
        MinHeapVertex targetVetex=null;
        for(MinHeapVertex m : result)
        {
            System.out.println( m.toString());
            if(m.index==target)
                targetVetex=m;
        }

        if(targetVetex!=null) {
            MinHeapVertex parent = (MinHeapVertex)targetVetex.parent;
            List<Integer> path = new ArrayList<>();
            path.add(target);
            while(parent!=null)
            {
                path.add(0, parent.index);
                parent = (MinHeapVertex)parent.parent;
            }

            System.out.println("Path "+ path.toString());
            System.out.println("Distance "+targetVetex.distance);
        }
        else
            System.out.println("No path found from source to target.");
    }


    /**
     * Print output of Prim's Algorithm
     * @param result: List of edges forming MST
     */
    public void printMST(List<Edge> result)
    {
        System.out.println("\nPrim's Algorithm");
        System.out.println("From\tTo\tWeight");

        for(Edge m : result)
        {
            System.out.println( m.toString());
        }
    }
}
