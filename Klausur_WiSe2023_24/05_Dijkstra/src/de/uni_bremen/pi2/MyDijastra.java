package de.uni_bremen.pi2;/*
 *  The map (start A, goal F). Every road works in both directions.
 *
 *               4               9
 *        A ------------ B ------------ D
 *         \             | \            | \
 *          \            |   \          |  \  2
 *         5 \        11 |     \ 7   13 |   \
 *            \          |       \      |    F
 *             \         |         \    |   /
 *              \        |           \  |  /  6
 *               ------- C ------------ E -
 *                              3
 *
 *  Shortest route: A -> C -> E -> F   (5 + 3 + 6 = 14)
 */
import java.util.PriorityQueue;


public class MyDijastra {
    static final String[] NAME = {"A", "B", "C", "D", "E", "F"};

    public static void main(String[] args) {
        // ---------- the map: graph[i][j] = road length, 0 = no road ----------
        // Every road is written twice, because you can drive it both ways.
        int[][] graph = new int[6][6];
        graph[0][1] = 4;   // A - B
        graph[1][0] = 4;
        graph[0][2] = 5;   // A - C
        graph[2][0] = 5;
        graph[1][2] = 11;   // B - C
        graph[2][1] = 11;
        graph[1][3] = 9;   // B - D
        graph[3][1] = 9;
        graph[1][4] = 7;   // B - E
        graph[4][1] = 7;
        graph[2][4] = 3;   // C - E
        graph[4][2] = 3;
        graph[3][4] = 13;   // D - E
        graph[4][3] = 13;
        graph[3][5] = 2;   // D - F
        graph[5][3] = 2;
        graph[4][5] = 6;   // E - F
        graph[5][4] = 6;

        int start = 0;  // A
        int goal = 5;   // F

        //-------------- Paper Table------------------//
        int[] dist = new int[6]; //distance row
        int[] prev = new int[6]; //small letter
        boolean[] done = new boolean[6]; //check marks
        //Assign inf to each letter:
        for (int i = 0; i < 6; i++) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }
        dist[start] = 0;

        PriorityQueue<int[]> box = new PriorityQueue<>((p, q) -> p[0] - q[0]);
        //add the start to the box:
        box.add(new int[]{0, start});

        // TODO: write the loop yourself. Your paper, in 6 steps:
        //  1. while the box is not empty:
        //  2.   take the smallest pair out -> its city is "node"
        //  3.   if node is already done: skip it (continue)
        //  4.   give node a check mark; if node is the goal: stop (break)
        //  5.   for every city "next" with a road from node (graph[node][next] != 0):
        //  6.     if dist[node] + road < dist[next]:
        //            write dist, write prev, put [newDist, next] into the box

        while (!box.isEmpty()) {
            int[] pair = box.poll() ;// take smallest out
            int node = pair[1];

            if (done[node]) {
                System.out.println("skip " + NAME[node] + " (already processed)");
                continue;
            }
            done[node] = true;               // give it a check mark
            System.out.println("process " + NAME[node] + " (" + dist[node] + ")");
            if (node == goal) {
                break;
            }

            for (int neighbour = 0; neighbour < 6; neighbour++) {
                if (graph[node][neighbour] == 0 || done[neighbour]) {
                    continue;  // 0 means they are no roads
                }
                int road = graph[node][neighbour];
                if (dist[node] + road < dist[neighbour]) {
                    dist[neighbour] = dist[node] + road;
                    prev[neighbour] = node;
                    box.add(new int[]{dist[node] + road, neighbour});
                }
            }

        }

        // ---------- read the route backwards with prev, then flip ----------
        String route = NAME[goal];
        for (int v = prev[goal]; v != -1; v = prev[v]) {
            route = NAME[v] + " -> " + route;
        }
        System.out.println("route: " + route + "   length: " + dist[goal]);
    }
}
