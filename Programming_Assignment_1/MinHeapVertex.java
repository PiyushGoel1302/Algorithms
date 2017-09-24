/**
 * Represents the node of the priority queue structure
 * @param <T>: Decided on the basis of algortithm implemented
 *           for Dijkstra's parent will be a MinHeapVertex
 *           and for Prim's parent will be an Edge
 */

public class MinHeapVertex<T> {
   public Integer index;
   public double distance;
   public T parent;

    /**
     *
     * @param index: Index of the vertex of the graph
     * @param distance: Represents the distance from the source
     * @param parent: Depending upon the Algorithm either an
     *                Edge or MinHeapVertex
     */
    public MinHeapVertex(int index, double distance, T parent) {
        this.index = index;
        this.distance = distance;
        this.parent = parent;
    }

    @Override
    public String toString() {
        if (parent instanceof MinHeapVertex) {
            MinHeapVertex a = (MinHeapVertex) parent;
            return String.format(index + "\t\t" + distance + "\t\t\t" + a.index);
        }
        return "";
    }
}
