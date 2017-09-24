import java.util.HashMap;
import java.util.Map;

public class UnionFind {
    private Map<Integer, Node> parentList = new HashMap<>();

    public void makeSet(int data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        parentList.put(data, node);
    }

    public void union(int data1, int data2) {
        Node node1 = parentList.get(data1);
        Node node2 = parentList.get(data2);
        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        if(parent1.data == parent2.data)
            return;

        if(parent1.rank >= parent2.rank) {
            if(parent1.rank == parent2.rank)
                parent1.rank += 1;
            parent2.parent = parent1;
        }
        else {
            parent1.parent = parent2;
        }
    }

    public int findSet(int data) {
        return findSet(parentList.get(data)).data;
    }

    private Node findSet(Node node) {
        Node parent = node.parent;

        if(parent == node)
            return parent;

        // path compression
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public static void main(String args[]) {
        UnionFind u = new UnionFind();
        u.makeSet(1);
        u.makeSet(2);
        u.makeSet(3);
        u.makeSet(4);
        
    }
}
