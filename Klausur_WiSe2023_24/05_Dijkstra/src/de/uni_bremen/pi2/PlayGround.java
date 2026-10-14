package de.uni_bremen.pi2;

/**
 * Dijkstra zum Zuschauen.
 *
 * Starten: javac DijkstraDemo.java && java DijkstraDemo
 * (oder in IntelliJ einfach main() ausführen)
 *
 * Der Graph ist derselbe wie in DijkstraTest.testFuenfKnoten,
 * nur heißen die Knoten hier A..E statt 0..4.
 *
 * Achtung: Diese Version sucht den nächsten Knoten mit einer einfachen
 * Schleife statt mit einer PriorityQueue, damit man jeden Schritt sieht.
 * Die Klausur-Version (mit PriorityQueue) schreibst du danach selbst.
 */
public class PlayGround
{
    static final String[] NAME = {"A", "B", "C", "D", "E"};
    static final int INF = Integer.MAX_VALUE;

    public static void main(final String[] args)
    {
        final Integer[][] m = new Integer[5][5];
        edge(m, 0, 1, 10);   // A -> B kostet 10
        edge(m, 0, 3, 5);    // A -> D kostet 5
        edge(m, 1, 2, 1);    // B -> C kostet 1
        edge(m, 1, 3, 2);    // B -> D kostet 2
        edge(m, 2, 4, 4);    // C -> E kostet 4
        edge(m, 3, 1, 3);    // D -> B kostet 3
        edge(m, 3, 2, 9);    // D -> C kostet 9
        edge(m, 3, 4, 2);    // D -> E kostet 2
        edge(m, 4, 2, 6);    // E -> C kostet 6

        printMatrix(m);
        final int[] dist = dijkstra(m, 0);

        System.out.println("\n=== ERGEBNIS: kuerzeste Distanz von A ===");
        for (int i = 0; i < dist.length; ++i) {
            System.out.println("  " + NAME[i] + ": " + show(dist[i]));
        }
    }

    static int[] dijkstra(final Integer[][] m, final int start)
    {
        final int n = m.length;

        // Schritt 0: alle unendlich weit weg, nur der Start hat 0.
        final int[] dist = new int[n];
        for (int i = 0; i < n; ++i) {
            dist[i] = INF;
        }
        dist[start] = 0;

        // done[i] == true heißt: dist[i] ist endgueltig, wird nie mehr kleiner.
        final boolean[] done = new boolean[n];

        System.out.println("\n--- Start ---");
        printTable(dist, done);

        for (int round = 1; ; ++round) {
            // 1. Den NAECHSTGELEGENEN noch nicht fertigen Knoten suchen.
            //    (Das ist genau das, was frontier.remove() in der Klausur macht.)
            int node = -1;
            for (int i = 0; i < n; ++i) {
                if (!done[i] && dist[i] != INF && (node == -1 || dist[i] < dist[node])) {
                    node = i;
                }
            }
            if (node == -1) {
                break; // keiner mehr erreichbar -> fertig
            }
            done[node] = true;

            System.out.println("\n--- Runde " + round + ": naechster Knoten ist "
                    + NAME[node] + " (Distanz " + dist[node] + ") -> jetzt endgueltig ---");

            // 2. Alle Nachbarn von node ansehen = die Zeile m[node][...].
            for (int neighbor = 0; neighbor < n; ++neighbor) {
                if (m[node][neighbor] == null) {
                    continue; // keine Kante
                }
                final int via = dist[node] + m[node][neighbor];
                final String line = "  " + NAME[node] + "->" + NAME[neighbor] + ": "
                        + dist[node] + " + " + m[node][neighbor] + " = " + via
                        + "  (bisher " + show(dist[neighbor]) + ")";

                // 3. Ist der Weg UEBER node kürzer als alles bisher Bekannte?
                if (via < dist[neighbor]) {
                    System.out.println(line + "  -> besser, uebernehmen!");
                    dist[neighbor] = via;
                } else {
                    System.out.println(line + "  -> nicht besser, bleibt");
                }
            }
            printTable(dist, done);
        }
        return dist;
    }

    // ------------------------------------------------------------------
    // Nur Hilfsmethoden fuer die Ausgabe
    // ------------------------------------------------------------------

    static void edge(final Integer[][] m, final int from, final int to, final int w)
    {
        m[from][to] = w;
    }

    static String show(final int d)
    {
        return d == INF ? "inf" : String.valueOf(d);
    }

    static void printTable(final int[] dist, final boolean[] done)
    {
        final StringBuilder names = new StringBuilder("  Knoten:  ");
        final StringBuilder dists = new StringBuilder("  Distanz: ");
        for (int i = 0; i < dist.length; ++i) {
            names.append(String.format("%-5s", NAME[i] + (done[i] ? "*" : "")));
            dists.append(String.format("%-5s", show(dist[i])));
        }
        System.out.println(names);
        System.out.println(dists);
    }

    static void printMatrix(final Integer[][] m)
    {
        System.out.println("Nachbarschaftsmatrix (Zeile = von, Spalte = nach, . = keine Kante):");
        System.out.print("      ");
        for (final String s : NAME) {
            System.out.printf("%-4s", s);
        }
        System.out.println();
        for (int i = 0; i < m.length; ++i) {
            System.out.printf("  %-4s", NAME[i]);
            for (int j = 0; j < m.length; ++j) {
                System.out.printf("%-4s", m[i][j] == null ? "." : m[i][j]);
            }
            System.out.println();
        }
    }
}