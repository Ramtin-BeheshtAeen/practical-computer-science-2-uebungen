package de.uni_bremen.pi2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Aufgabe 5: Minimal aufspannende Bäume nach Jarnik, Prim und Dijkstra (20 %).
 * Klausur WiSe 2022/23.
 *
 * Es dürfen keine Klassen der Laufzeitbibliothek außer den hier sowieso
 * schon genutzten verwendet werden.
 */
public class MinimumSpanningTree
{
    /**
     * Bestimmt mit dem Verfahren von Jarnik, Prim und Dijkstra einen minimal
     * aufspannenden Baum eines ungerichteten Graphen.
     * @param adjacencyMatrix Die Nachbarschaftsmatrix. Sie ist quadratisch,
     *         symmetrisch und nicht null. Ist adjacencyMatrix[i][j] ungleich
     *         null, gibt es eine Kante zwischen i und j mit diesem Gewicht.
     * @param start Der Startknoten (die Wurzel des Baums). Ist auf jeden Fall
     *         ein gültiger Index für adjacencyMatrix.
     * @return Ein Array, das für jeden Knoten seinen Vorgänger im Baum enthält.
     *         Der Startknoten ist sein eigener Vorgänger. Knoten, die nicht
     *         erreicht werden können, haben den Eintrag -1.
     */
    public static int[] minimumSpanningTree(final Integer[][] adjacencyMatrix, final int start)
    {
        // Noch kein Knoten ist im Baum, außer dem Startknoten.
        final int[] edges = new int[adjacencyMatrix.length];
        Arrays.fill(edges, -1);
        edges[start] = start;

        // Die Front enthält Kanten {von, nach}, sortiert nach ihrem Gewicht.
        final PriorityQueue<int[]> frontier = new PriorityQueue<>(
                (a, b) -> Integer.compare(adjacencyMatrix[a[0]][a[1]], adjacencyMatrix[b[0]][b[1]]));
        for (int neighbor = 0; neighbor < adjacencyMatrix[start].length; ++neighbor) {
            if (adjacencyMatrix[start][neighbor] != null) {
                frontier.add(new int[] {start, neighbor});
            }
        }

        while (!frontier.isEmpty()) {
            final int[] edge = frontier.poll();

            // TODO: Aufgabe 5 (Musterlösung: 8 Zeilen)
            // Ist das Ziel der Kante noch nicht im Baum, die Kante in den
            // Baum aufnehmen und alle Kanten des Ziels in die Front legen.
        }
        return edges;
    }
}
