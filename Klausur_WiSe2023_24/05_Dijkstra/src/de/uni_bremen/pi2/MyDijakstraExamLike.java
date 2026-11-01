package de.uni_bremen.pi2;
import java.util.PriorityQueue;

public class MyDijakstraExamLike {
    static  final String[] NAME = {"A", "B", "C", "D", "E", "F"};


    public static int[] shortestDistances(final Integer[][] adjacencyMatrix, final int start)
    {
        // ---- given in the exam ----
        // Zu Beginn ist jeder Knoten unendlich weit entfernt ...
        final int[] shortestDistances = new int[adjacencyMatrix.length];

        System.out.println(adjacencyMatrix.length);

        for (int i = 0; i < shortestDistances.length; ++i) {
            shortestDistances[i] = Integer.MAX_VALUE;
        }

        // ... außer dem Startknoten, der die Distanz 0 hat.
        shortestDistances[start] = 0;

        // The box: holds city numbers, smallest distance first.
        final PriorityQueue<Integer> frontier = new PriorityQueue<>(
                (a, b) -> shortestDistances[a] - shortestDistances[b]);
        frontier.add(start);

        while (!frontier.isEmpty()) {
            final int node = frontier.remove();            // take the smallest out
            printBox(node, frontier, shortestDistances);   // only for watching
            final int cityIndex = node;
            // TODO: Aufgabe 5 (Zeilen 57-64 der Musterlösung)
            // Same as your practice loop, but:
            //   - "no road" is null, not 0
            //   - no done[] and no prev[]
            //   - if better: remove the neighbour from the frontier,
            //     write the new distance, then add it back

            // if node is done skip it:

            // give node the check mark

            // stop if it is the end node:
            /*  “…bestimmt … für jeden Knoten des Graphen die Mindestentfernung …
            Es wird nicht nach dem Weg zu einem bestimmten Knoten gesucht.”
            So the question isn’t “how far is F?” but “how far is every city?”
            There’s no single goal to stop at. So when does it stop? When the box is empty:
            */
            for(int neighbourCityIndex = 0; neighbourCityIndex < adjacencyMatrix.length; neighbourCityIndex++) {
                if (adjacencyMatrix[cityIndex][neighbourCityIndex] == null){
                     continue;
                }
                //road from city to neighbor city:
                int road = adjacencyMatrix[cityIndex][neighbourCityIndex];
                if(shortestDistances[cityIndex] + road < shortestDistances[neighbourCityIndex]){

                    // update the neighbors prevous path:
                    // -- in this version we delete it and save the correct one:
                    frontier.remove(neighbourCityIndex);
                    // update neighbors distance we found sth smaller:
                    shortestDistances[neighbourCityIndex] = shortestDistances[cityIndex] + road;

                    //put new city into the box:
                    frontier.add(neighbourCityIndex);
                }
            }

        }

        return shortestDistances;
    }


    // =====================================================================
    // Everything below is only for trying it out.
    // =====================================================================

    /*
     *  The map (start A). Every road works in both directions.
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
     */
    public static void main(final String[] args)
    {
        final Integer[][] graph = new Integer[6][6];   // all null = no roads yet
        graph[0][1] = 4;   graph[1][0] = 4;    // A - B
        graph[0][2] = 5;   graph[2][0] = 5;    // A - C
        graph[1][2] = 11;  graph[2][1] = 11;   // B - C
        graph[1][3] = 9;   graph[3][1] = 9;    // B - D
        graph[1][4] = 7;   graph[4][1] = 7;    // B - E
        graph[2][4] = 3;   graph[4][2] = 3;    // C - E
        graph[3][4] = 13;  graph[4][3] = 13;   // D - E
        graph[3][5] = 2;   graph[5][3] = 2;    // D - F
        graph[4][5] = 6;   graph[5][4] = 6;    // E - F

        final int[] result = shortestDistances(graph, 0);

        System.out.println();
        for (int i = 0; i < result.length; ++i) {
            System.out.println("A -> " + NAME[i] + ": " + result[i]);
        }
    }

    /** Prints which city was taken out and what is left in the box, smallest first. */
    static void printBox(final int taken, final PriorityQueue<Integer> frontier, final int[] dist)
    {
        final PriorityQueue<Integer> copy = new PriorityQueue<>(frontier);
        String text = "take out " + NAME[taken] + " (" + dist[taken] + ")   box left: ";
        while (!copy.isEmpty()) {
            final int cityIndex = copy.poll();
            text += "[" + NAME[cityIndex] + " " + dist[cityIndex] + "] ";
        }
        System.out.println(text);
    }
}
