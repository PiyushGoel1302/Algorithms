

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Executor class that will run Kruskal's algorithm
 * with 4 ways of Union-find, depeding on the input
 * you give.
 */

public class Executor {
    public static void main(String[] args) {
        while (true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Enter \n 1 NameArray \n 2 ParentArray\n" +
                    " 3 Weighted Parent\n 4 Path Compression");
            int input = userInput.nextInt();
            DisjointSet obj;
            switch (input) {
                case 1:
                    obj = new NameArray();
                    break;
                case 2:
                    obj = new ParentArray();
                    break;
                case 3:
                    obj = new WeightedParent();
                    break;
                case 4:
                    obj = new WeightedPathCompression();
                    break;
                default:
                    System.out.println("Invalid input");
                    return;
            }
            System.out.println("Enter path of the file containing graph: ");
            String fileName = userInput.next();
            String line;
            Integer flag = 0;
            Integer noOfVertices = 0;
            Graph graph = new Graph(false);
            try {
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr);

                while ((line = br.readLine()) != null) {
                    if (flag == 0) {
                        noOfVertices = Integer.parseInt(String.valueOf(line));
                        flag += 1;
                    } else {
                        String[] data = line.split("\t");
                        Integer vertex1 = Integer.parseInt(String.valueOf(data[0]));
                        Integer vertex2 = Integer.parseInt(String.valueOf(data[1]));
                        Double edgeWt = Double.parseDouble(String.valueOf(data[2]));
                        graph.addEdge(vertex1, vertex2, edgeWt);
                    }
                }
                br.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
                return;
            } catch (IOException ex) {
                System.out.println("Could not read file!");
                return;
            }

            KruskalAlgorithm obj1 = new KruskalAlgorithm();
            obj1.execute(graph, obj);
        }
    }
}
