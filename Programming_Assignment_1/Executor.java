import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Testing class for taking input from the user
 * and accordingly implementing dijkstra's and prim's
 * algorithm
 */
public class ExecutorTest {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter 1 for Dijkstra's Algo and 2 for Prim's Algo: ");
        int input = userInput.nextInt();
        if (input == 1) {
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
                    }
                    else {
                        String[] data = line.split("\t");
                        Integer vertex1 = Integer.parseInt(String.valueOf(data[0]));
                        Integer vertex2 = Integer.parseInt(String.valueOf(data[1]));
                        Double edgeWt = Double.parseDouble(String.valueOf(data[2]));
                        graph.addEdge(vertex1, vertex2, edgeWt);
                    }
                }

                br.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found!");
                return;
            }
            catch (IOException ex) {
                System.out.println("Could not read file!");
                return;
            }

            System.out.println("Enter source: ");
            int source = userInput.nextInt();
            System.out.println("Enter target: ");
            int target = userInput.nextInt();
            ProgrammingAssignment1 obj1 = new ProgrammingAssignment1();
            obj1.dijkstraAlgorithm(graph, source,target);
        }
        else if (input == 2) {
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
                    }
                    else {
                        String[] data = line.split("\t");
                        Integer vertex1 = Integer.parseInt(String.valueOf(data[0]));
                        Integer vertex2 = Integer.parseInt(String.valueOf(data[1]));
                        Double edgeWt = Double.parseDouble(String.valueOf(data[2]));
                        graph.addEdge(vertex1, vertex2, edgeWt);
                    }
                }

                br.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found!");
                return;
            }
            catch (IOException ex) {
                System.out.println("Could not read file!");
                return;
            }

            ProgrammingAssignment1 obj1 = new ProgrammingAssignment1();
            obj1.primsAlgorithm(graph);
        }
        else {
            System.out.println("Invalid input!");
        }
    }
}
