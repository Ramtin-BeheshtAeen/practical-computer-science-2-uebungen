package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse MST (Minimal aufspannende
 * Bäume nach Jarnik, Prim und Dijkstra), Klausur WiSe 2022/23, Aufgabe 5
 * (20 Punkte).
 */
public class MSTTest
{
    /**
     * Baut eine symmetrische Nachbarschaftsmatrix aus einer Knotenzahl und
     * einer Liste von Kanten {von, nach, gewicht}.
     * @param n Die Anzahl der Knoten.
     * @param edges Die Kanten als {von, nach, gewicht}.
     * @return Die Nachbarschaftsmatrix.
     */
    private Integer[][] graph(final int n, final int[]... edges)
    {
        final Integer[][] matrix = new Integer[n][n];
        for (final int[] edge : edges) {
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }
        return matrix;
    }

    /**
     * Bestimmt das Gesamtgewicht des durch das Vorgänger-Array beschriebenen
     * Baums.
     * @param matrix Die Nachbarschaftsmatrix.
     * @param edges Das Vorgänger-Array.
     * @return Die Summe der Kantengewichte im Baum.
     */
    private int weight(final Integer[][] matrix, final int[] edges)
    {
        int sum = 0;
        for (int node = 0; node < edges.length; ++node) {
            if (edges[node] != -1) {
                sum += matrix[node][edges[node]];
            }
        }
        return sum;
    }

    /**
     * Prüft, dass das Vorgänger-Array einen echten aufspannenden Baum
     * beschreibt: genau ein Knoten ohne Vorgänger (die Wurzel), alle anderen
     * über gültige Kanten erreichbar, keine Zyklen.
     * @param matrix Die Nachbarschaftsmatrix.
     * @param start Der Startknoten.
     * @param edges Das Vorgänger-Array.
     */
    private void assertSpanningTree(final Integer[][] matrix, final int start, final int[] edges)
    {
        assertEquals(matrix.length, edges.length, "Falsche Länge des Ergebnisses.");
        assertEquals(-1, edges[start], "Der Startknoten darf keinen Vorgänger haben.");
        for (int node = 0; node < edges.length; ++node) {
            if (node == start) {
                continue;
            }
            assertTrue(edges[node] != -1, "Knoten " + node + " ist nicht mit dem Baum verbunden.");
            assertNotNull(matrix[node][edges[node]],
                    "Zwischen " + node + " und seinem Vorgänger " + edges[node] + " gibt es keine Kante.");
            // Dem Vorgänger bis zur Wurzel folgen, um Zyklen auszuschließen.
            int current = node;
            int steps = 0;
            while (current != start) {
                current = edges[current];
                assertTrue(current != -1, "Knoten " + node + " führt nicht zur Wurzel.");
                assertTrue(++steps <= edges.length, "Zyklus im Baum entdeckt.");
            }
        }
    }

    /** Ein Graph aus zwei Knoten und einer Kante. */
    @Test
    public void testZweiKnoten()
    {
        final Integer[][] matrix = graph(2, new int[] {0, 1, 5});
        final int[] edges = MST.minimumSpanningTree(matrix, 0);
        assertSpanningTree(matrix, 0, edges);
        assertEquals(5, weight(matrix, edges));
    }

    /** Ein Dreieck: die beiden leichteren Kanten bilden den MST. */
    @Test
    public void testDreieck()
    {
        final Integer[][] matrix = graph(3,
                new int[] {0, 1, 1},
                new int[] {1, 2, 2},
                new int[] {0, 2, 3});
        final int[] edges = MST.minimumSpanningTree(matrix, 0);
        assertSpanningTree(matrix, 0, edges);
        assertEquals(3, weight(matrix, edges), "Der MST soll die beiden leichtesten Kanten wählen.");
    }

    /** Ein klassisches Beispiel mit fünf Knoten. */
    @Test
    public void testFuenfKnoten()
    {
        final Integer[][] matrix = graph(5,
                new int[] {0, 1, 2},
                new int[] {0, 3, 6},
                new int[] {1, 2, 3},
                new int[] {1, 3, 8},
                new int[] {1, 4, 5},
                new int[] {2, 4, 7},
                new int[] {3, 4, 9});
        final int[] edges = MST.minimumSpanningTree(matrix, 0);
        assertSpanningTree(matrix, 0, edges);
        assertEquals(16, weight(matrix, edges));
    }

    /** Der Startknoten darf ein beliebiger Knoten sein; das Gesamtgewicht bleibt gleich. */
    @Test
    public void testAndererStart()
    {
        final Integer[][] matrix = graph(5,
                new int[] {0, 1, 2},
                new int[] {0, 3, 6},
                new int[] {1, 2, 3},
                new int[] {1, 3, 8},
                new int[] {1, 4, 5},
                new int[] {2, 4, 7},
                new int[] {3, 4, 9});
        final int[] edges = MST.minimumSpanningTree(matrix, 3);
        assertSpanningTree(matrix, 3, edges);
        assertEquals(16, weight(matrix, edges));
    }

    /** Ein Quadrat mit Diagonalen: die vier Außenkanten sind am leichtesten. */
    @Test
    public void testQuadrat()
    {
        final Integer[][] matrix = graph(4,
                new int[] {0, 1, 1},
                new int[] {1, 2, 1},
                new int[] {2, 3, 1},
                new int[] {3, 0, 1},
                new int[] {0, 2, 5},
                new int[] {1, 3, 5});
        final int[] edges = MST.minimumSpanningTree(matrix, 0);
        assertSpanningTree(matrix, 0, edges);
        assertEquals(3, weight(matrix, edges));
    }

    /** Ein einzelner Knoten ohne Kanten hat einen leeren Baum. */
    @Test
    public void testEinKnoten()
    {
        final Integer[][] matrix = graph(1);
        final int[] edges = MST.minimumSpanningTree(matrix, 0);
        assertArrayEquals(new int[] {-1}, edges);
    }
}
