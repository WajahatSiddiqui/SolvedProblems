import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * RoadRepairing - Swiggy
 *
 * @author wajahat
 */
public class RoadRepairing {

    private static volatile int count = -1;

    enum ROAD_TYPE {
        FUNCTIONAL,
        DAMAGED
    }

    private static class Node {
        int roadId;
        ROAD_TYPE roadType;
        Node next;
        public Node(int roadId, ROAD_TYPE roadType) {
            this.roadId = roadId;
            this.roadType = roadType;
            this.next = null;
        }
    }

    private static Node addNode(Node head, int roadId, ROAD_TYPE road_type) {
        Node node = new Node(roadId, road_type);
        Node curr = null;
        if (head != null) {
            curr = head;
        }
        head = node;
        node.next = curr;
        return head;
    }

    private static void dfs(Node[] adjList, int V) {
        boolean [] visited = new boolean[V + 1];
        int count = -1;
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                dfsUtil(adjList, i, visited);
            }
        }
    }

    private static void dfsUtil(Node[] adjList, int u, boolean []visited) {
        visited[u] = true;
        Node curr = adjList[u];
        while (curr != null) {
            if (!visited[curr.roadId]) {
                if (curr.roadType == ROAD_TYPE.DAMAGED) {
                    count++;
                }
                dfsUtil(adjList, curr.roadId, visited);
            }
            curr = curr.next;
        }
    }

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER t - Number of cities
     *  2. 2D_INTEGER_ARRAY functional
     *  3. 2D_INTEGER_ARRAY damaged
     */
    public static int solve(int t, List<List<Integer>> functional, List<List<Integer>> damaged) {
        Node []adjList = new Node[t+1];
        count = -1;
        for (List<Integer> list : functional) {
            adjList[list.get(0)] = addNode(adjList[list.get(0)], list.get(1), ROAD_TYPE.FUNCTIONAL);
            adjList[list.get(1)] = addNode(adjList[list.get(1)], list.get(0), ROAD_TYPE.FUNCTIONAL);
        }

        for (List<Integer> list : damaged) {
            adjList[list.get(0)] = addNode(adjList[list.get(0)], list.get(1), ROAD_TYPE.DAMAGED);
            adjList[list.get(1)] = addNode(adjList[list.get(1)], list.get(0), ROAD_TYPE.DAMAGED);
        }

        dfs(adjList, t);
        return count == -1 ? -1 : count + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> functional = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                functional.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> damaged = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                damaged.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = RoadRepairing.solve(t, functional, damaged);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
