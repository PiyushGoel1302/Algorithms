import java.util.*;

/**
 * Represents minimum priority queue using heap
 * @param <T>: Depending upon the type of parent of MinHeapVertex
 */
public class PriorityQueue<T> {

    // Represents priority queue using an array
    private List<MinHeapVertex> minHeap;

    // Map for maintaining position of vertex in an array
    // according to its index
    private Map<Integer,Integer> indexingMap;

    // Properties to implement minimum heap functionality
    private int heapSize;
    private int arraySize;
    private int i;
    public int getLeft() {
        return 2*i+1;
    }
    public int getRight() {
        return 2*i+2;
    }
    public List<MinHeapVertex> getMinHeap() {return minHeap;}


    /**
     * Initializing priority queue with provided minHeap
     *  and creating priority queue using createMinHeap
     * @param minHeap: Containing list of priority queue node
     * @param indexingMap: map containing positioning of the vertex
     */
    public PriorityQueue(List<MinHeapVertex> minHeap, Map<Integer,Integer> indexingMap ) {
        this.indexingMap = indexingMap;
        this.minHeap = minHeap;
        this.heapSize = minHeap.size();
        this.arraySize = minHeap.size();
        this.i = 0;
        createMinHeap();
    }

    /**
     *to update the distance from the source and its parent
     * and bubble up the node to its correct position in priority queue
     * @param adj: adjacent node index
     * @param w: distance of the node from its source
     * @param u: parent of the node
     */
    public void decrease(int adj, double w, T u)
    {
        int pos = indexingMap.get(adj);
        this.minHeap.get(pos).distance = w;
        this.minHeap.get(pos).parent=u;
        decreaseKey(pos);
    }

    /**
     * helper function for decrease function
     * position the provided index node to
     * correct position
     * @param i:take the index in heap array
     */
    public void decreaseKey(int i)
    {
        int parent = (i-1)/2;

        while(parent>=0)
        {
            if(minHeap.get(parent).distance>minHeap.get(i).distance)
            {
                this.indexingMap.put(minHeap.get(i).index,parent);
                this.indexingMap.put(minHeap.get(parent).index,i);
                Collections.swap(this.minHeap,parent,i);
                i=parent;
                parent=(i-1)/2;
            }
            else
                break;
        }
    }

    /**
     * create the priority queue using provided node array
     */
    public void createMinHeap()
    {
        for(int i=(int)Math.floor(this.arraySize/2);i>=0;i--)
        {
            minHeapify(i);
        }
    }

    /**
     * Extract minimum node from priority queue
     * and heapify the priority queue
     * @return Minimum distance node
     */
    public MinHeapVertex extractMin()
    {
        MinHeapVertex min = this.minHeap.get(0);
        this.indexingMap.remove(this.minHeap.get(0).index);
        Collections.swap(this.minHeap,0,this.heapSize-1);
        this.indexingMap.put(this.minHeap.get(0).index,0);
        this.minHeap.remove(this.heapSize-1);
        this.heapSize=this.heapSize-1;
        minHeapify(0);
        return min;
    }

    /**
     * Heapify the priority queue with respect to the
     * provided index i
     * @param i: Index of the node in array need to be heapified
     */
    public void minHeapify(int i)
    {
        this.i=i;
        int l = this.getLeft();
        int r = this.getRight();
        int largest;

        if (l<this.heapSize && this.minHeap.get(l).distance<this.minHeap.get(i).distance)
            largest=l;
        else largest=i;
        if(r<this.heapSize && this.minHeap.get(r).distance<this.minHeap.get(largest).distance)
            largest=r;
        if (largest!=i)
        {
            this.indexingMap.put(minHeap.get(i).index,largest);
            this.indexingMap.put(minHeap.get(largest).index,i);
            Collections.swap(this.minHeap,i,largest);
            minHeapify(largest);
        }
    }
}
