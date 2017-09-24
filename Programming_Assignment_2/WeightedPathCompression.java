
import java.util.HashMap;
import java.util.Map;

/**
 * Represents the implementation of DisjointSet using
 * WeightedPathCompression
 */

public class WeightedPathCompression implements DisjointSet {
    Map<Integer,RankedNode> allNodes = new HashMap<>();

    /**
     * findSet returns the id of the parent which the Node belongs to
     * @param index
     * @return
     */
    @Override
    public int findSet(int index) {
        RankedNode node1 = allNodes.get(index);
        if( node1.parent != index)
            node1.parent=findSet(node1.parent);
        return node1.parent;
    }

    /**
     * union operation combines 2 sets if they are disjoint,
     * also changes the rank of the common parent accordingly.
     * @param id1
     * @param id2
     */
    @Override
    public void union(int id1, int id2) {
        int parent1 = findSet(id1);
        int parent2 = findSet(id2);
        RankedNode node1 = allNodes.get(parent1);
        RankedNode node2 = allNodes.get(parent2);

        if(node1.rank>node2.rank)
        {
            node2.parent=node1.parent;
        }

        else if(node1.rank<node2.rank)
        {
            node1.parent=node2.parent;
        }
        else
        {
            node2.parent=node1.parent;
            node1.rank+=1;
        }
    }

    /**
     * makeSet operation makes a new set by creating a new element
     * with a unique id, a rank of 0, and a parent pointer to itself.
     * @param value
     * @return
     */
    @Override
    public void makeSet(int value) {
        allNodes.put(value,new RankedNode(value,0));
    }
}
