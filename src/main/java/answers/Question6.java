package answers;
import java.util.PriorityQueue;

public class Question6 {

    public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {

        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        int[] distances = new int[numServers];
        boolean[] visited = new boolean[numServers];
        distances[0] = 0;

        for (int i = 1; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE / 2;
            visited[i] = false;
        }

        Node n = new Node(0, 0);
        queue.add(n);

        while (!queue.isEmpty()) {
            int fromVertex = queue.poll().vertex;

            if (fromVertex == targetServer)
                break;

            if (!visited[fromVertex]) {
                visited[fromVertex] = true;

                for (int v = 0; v < numServers; v++) {
                    if (v != fromVertex) {
                        if (!visited[v]) {
                            int newDist = distances[fromVertex] + times[fromVertex][v];

                            if (newDist < distances[v]) {
                                queue.add(new Node(v, newDist));
                                distances[v] = newDist;
                            }
                        }
                    }
                }
            }
        }

        return distances[targetServer];
    }
}

/*
 A simple node to hold the vertex and the distance to that vertex
 from src vertex
 */
class Node implements Comparable<Node> {
    int vertex;
    int dist;

    public Node(int vertex, int dist) {
        this.vertex = vertex;
        this.dist = dist;
    }

    public int compareTo(Node n) {
        return this.dist - n.dist;
    }
}

