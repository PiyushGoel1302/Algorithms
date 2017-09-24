
import java.util.HashMap;
import java.util.Map;

/**
 * Represents implementation of DisjointSet using WeightedParent
 */
public class WeightedParent implements DisjointSet{
    Map<Integer,RankedNode> allNodes = new HashMap<>();

    /**
     * findSet returns the id of the parent which the Node belongs to
     * @param index
     * @return
     */
    @Override
    public int findSet(int index) {
        int parent = allNodes.get(index).parent;
        if( parent == index)
            return index;
        else
            return findSet(parent);
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
