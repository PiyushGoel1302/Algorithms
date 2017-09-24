
import java.util.HashMap;
import java.util.Map;

/**
 * Represents implementation of DisjointSet using NameArray
 */
public class NameArray implements DisjointSet {
    Map<Integer,Node> allNodes = new HashMap<>();

    /**
     * findSet returns the id of the parent which the Node belongs to
     * @param value
     * @return
     */
    @Override
    public int findSet(int value) {
            return allNodes.get(value).id;
    }

    /**
     * union operation combines 2 sets if they are disjoint
     * @param id1
     * @param id2
     */
    @Override
    public void union(int id1, int id2) {
        int parent1 = findSet(id1);
        int parent2 = findSet(id2);
        for(Map.Entry<Integer, Node> entry : allNodes.entrySet())
        {
            if(entry.getValue().id == parent2)
                allNodes.put(entry.getKey(), allNodes.get(parent1));
        }
    }

    /**
     * makeSet operation makes a new set by creating a new Node with an unique id.
     * @param value
     * @return
     */
    @Override
    public void makeSet(int value) {
        allNodes.put(value,new Node(value));
    }
}
