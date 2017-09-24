

import java.util.List;

/**\
 * DisjointSet is an interface which is implemented in
 * 4 different ways, each of the 4 ways must implement
 * these functions.
 */

public interface DisjointSet {
    int findSet (int value);
    void union (int id1, int id2);
    void makeSet (int value);

}
