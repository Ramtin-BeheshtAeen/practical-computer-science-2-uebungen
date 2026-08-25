package de.uni_bremen.pi2;

import java.util.PriorityQueue;

/**
 * Die Klasse bestimmt einen minimal aufspannenden Baum (MST) eines
 * zusammenhängenden, ungerichteten, gewichteten Graphen nach dem Verfahren von
 * Jarnik, Prim und Dijkstra.
 *
 * Der Graph wird durch eine Nachbarschaftsmatrix gegeben. Ist
 * adjacencyMatrix[i][j] ungleich null, gibt es eine Kante zwischen den Knoten i
 * und j, deren Gewicht der Matrixeintrag ist. Die Matrix ist symmetrisch.
 */
public class MST
{
    /**
     * Bestimmt einen minimal aufspannenden Baum.
     *
     * Das Ergebnis ist ein Array, das für jeden Knoten den Vorgängerknoten im
     * aufspannenden Baum enthält. Für den Startknoten und für Knoten, die nicht
     * erreichbar sind, ist der Eintrag -1.
     *
     * Es wird eine Prioritätswarteschlange (frontier) verwendet, die Kanten der
     * Form {von, nach} nach aufsteigendem Gewicht liefert. Zu Beginn sind alle
     * Einträge in edges auf -1 gesetzt und die ausgehenden Kanten des
     * Startknotens in die frontier eingefügt. Anschließend wird wiederholt die
     * leichteste Kante entnommen und verarbeitet.
     *
     * @param adjacencyMatrix Die Nachbarschaftsmatrix. Sie ist quadratisch und
     *         nicht null. Ist adjacencyMatrix[i][j] ungleich null, gibt es eine
     *         Kante zwischen i und j mit dem entsprechenden Gewicht.
     * @param start Der Startknoten. Ist ein gültiger Index für adjacencyMatrix.
     * @return Ein Array mit dem Vorgänger jedes Knotens im aufspannenden Baum.
     *         Der Startknoten und nicht erreichbare Knoten haben den Wert -1.
     */
    public static int[] minimumSpanningTree(final Integer[][] adjacencyMatrix, final int start)
    {
        // Für jeden Knoten der Vorgänger im Baum, zu Beginn -1 (nicht im Baum).
        final int[] edges = new int[adjacencyMatrix.length];
        for (int i = 0; i < edges.length; ++i) {
            edges[i] = -1;
        }

        // Die frontier liefert Kanten {von, nach} nach aufsteigendem Gewicht.
        final PriorityQueue<int[]> frontier = new PriorityQueue<>(
                (a, b) -> adjacencyMatrix[a[0]][a[1]] - adjacencyMatrix[b[0]][b[1]]);

        // Der Startknoten gehört zum Baum. Seine Kanten kommen in die frontier.
        edges[start] = start;
        for (int neighbor = 0; neighbor < adjacencyMatrix[start].length; ++neighbor) {
            if (adjacencyMatrix[start][neighbor] != null) {
                frontier.add(new int[] {start, neighbor});
            }
        }

        // Solange es Kandidatenkanten gibt, die leichteste verarbeiten.
        while (!frontier.isEmpty()) {
            final int[] edge = frontier.poll();

            // TODO: Aufgabe 5 (Zeilen 63-70 der Musterlösung)
        }

        // Der Startknoten hat keinen Vorgänger.
        edges[start] = -1;
        return edges;
    }
}
