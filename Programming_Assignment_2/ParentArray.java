

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents implementation of DisjointSet using ParentArray
 */

public class ParentArray implements DisjointSet {

    Map<Integer, Node> allNodes = new HashMap<>();

    /**
     * findSet returns the id of the parent which the Node belongs to
     * @param index
     * @return
     */
    @Override
    public int findSet(int index) {
        int parent = allNodes.get(index).id;
        if( parent == index)
            return index;
        else
            return findSet(parent);
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
        allNodes.put(parent2, allNodes.get(parent1));
    }

    /**
     * makeSet operation makes a new set by creating a new Node with an unique id.
     * @param value
     * @return
     */
    @Override
    public void makeSet(int value) {
        allNodes.put(value, new Node(value));
    }

}
