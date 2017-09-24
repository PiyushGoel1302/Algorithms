/**
 * Entry point of the code
 * giving input and checking output.
 */

public class Executor {
    public static void main(String[] args) {

        Graph graph = new Graph(false);
        graph.addEdge(0, 1, 4.0);
        graph.addEdge(0, 7, 8.0);
        graph.addEdge(1, 2, 8.0);
        graph.addEdge(1, 7, 11.0);
        graph.addEdge(7, 8, 7.0);
        graph.addEdge(7, 6, 1.0);
        graph.addEdge(2, 8, 2.0);
        graph.addEdge(2, 3, 7.0);
        graph.addEdge(2, 5, 4.0);
        graph.addEdge(3, 5, 14.0);
        graph.addEdge(3, 4, 9.0);
        graph.addEdge(5, 4, 10.0);
        graph.addEdge(8, 6, 6.0);
        graph.addEdge(6, 5, 2.0);

//        graph.addEdge(0, 1, 3.0);
//        graph.addEdge(1, 2, 1.0);
//        graph.addEdge(2, 3, 1.0);
//        graph.addEdge(1, 3, 3.0);
//        graph.addEdge(0, 3, 1.0);
//        graph.addEdge(3, 4, 6.0);
//        graph.addEdge(4, 5, 2.0);
//        graph.addEdge(2, 5, 4.0);
//        graph.addEdge(2, 4, 5.0);




        ProgrammingAssignment1 oo = new ProgrammingAssignment1();
        oo.dijkstraAlgorithm(graph,0,5);
        oo.primsAlgorithm(graph);


    }
}
