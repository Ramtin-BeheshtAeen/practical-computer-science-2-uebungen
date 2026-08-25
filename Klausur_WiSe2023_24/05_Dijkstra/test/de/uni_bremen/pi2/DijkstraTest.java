package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse Dijkstra (Kürzeste Wege nach
 * Dijkstra), Klausur WiSe 2023/24, Aufgabe 5 (20 Punkte).
 */
public class DijkstraTest
{
    /**
     * Baut eine gerichtete Nachbarschaftsmatrix aus einer Knotenzahl und Kanten
     * {von, nach, distanz}.
     * @param n Die Anzahl der Knoten.
     * @param edges Die gerichteten Kanten als {von, nach, distanz}.
     * @return Die Nachbarschaftsmatrix.
     */
    private Integer[][] graph(final int n, final int[]... edges)
    {
        final Integer[][] matrix = new Integer[n][n];
        for (final int[] edge : edges) {
            matrix[edge[0]][edge[1]] = edge[2];
        }
        return matrix;
    }

    /** Der Startknoten selbst hat die Distanz 0. */
    @Test
    public void testStartHatNull()
    {
        final Integer[][] matrix = graph(3, new int[] {0, 1, 4}, new int[] {1, 2, 5});
        final int[] distances = Dijkstra.shortestDistances(matrix, 0);
        assertEquals(0, distances[0]);
    }

    /** Ein direkter Nachbar hat die Distanz der Kante. */
    @Test
    public void testDirekterNachbar()
    {
        final Integer[][] matrix = graph(2, new int[] {0, 1, 7});
        final int[] distances = Dijkstra.shortestDistances(matrix, 0);
        assertEquals(7, distances[1]);
    }

    /** Ein kürzerer Umweg wird gegenüber einer direkten, längeren Kante bevorzugt. */
    @Test
    public void testKuerzererUmweg()
    {
        // 0 -> 2 direkt kostet 10, aber 0 -> 1 -> 2 kostet 3 + 4 = 7.
        final Integer[][] matrix = graph(3,
                new int[] {0, 2, 10},
                new int[] {0, 1, 3},
                new int[] {1, 2, 4});
        final int[] distances = Dijkstra.shortestDistances(matrix, 0);
        assertEquals(3, distances[1]);
        assertEquals(7, distances[2]);
    }

    /** Ein klassisches Beispiel mit fünf Knoten. */
    @Test
    public void testFuenfKnoten()
    {
        final Integer[][] matrix = graph(5,
                new int[] {0, 1, 10},
                new int[] {0, 3, 5},
                new int[] {1, 2, 1},
                new int[] {3, 1, 3},
                new int[] {3, 2, 9},
                new int[] {3, 4, 2},
                new int[] {2, 4, 4},
                new int[] {4, 2, 6},
                new int[] {1, 3, 2});
        final int[] distances = Dijkstra.shortestDistances(matrix, 0);
        assertEquals(0, distances[0]);
        assertEquals(8, distances[1]);
        assertEquals(9, distances[2]);
        assertEquals(5, distances[3]);
        assertEquals(7, distances[4]);
    }

    /** Nicht erreichbare Knoten behalten die Distanz Integer.MAX_VALUE. */
    @Test
    public void testNichtErreichbar()
    {
        final Integer[][] matrix = graph(3, new int[] {0, 1, 4});
        final int[] distances = Dijkstra.shortestDistances(matrix, 0);
        assertEquals(4, distances[1]);
        assertEquals(Integer.MAX_VALUE, distances[2]);
    }

    /** Ein einzelner Knoten ohne Kanten hat nur die Distanz 0 zu sich selbst. */
    @Test
    public void testEinKnoten()
    {
        final Integer[][] matrix = graph(1);
        assertArrayEquals(new int[] {0}, Dijkstra.shortestDistances(matrix, 0));
    }

    /** Ein anderer Startknoten liefert andere Distanzen. */
    @Test
    public void testAndererStart()
    {
        final Integer[][] matrix = graph(4,
                new int[] {0, 1, 1},
                new int[] {1, 2, 1},
                new int[] {2, 3, 1},
                new int[] {3, 0, 1});
        final int[] distances = Dijkstra.shortestDistances(matrix, 2);
        assertEquals(2, distances[0]);
        assertEquals(3, distances[1]);
        assertEquals(0, distances[2]);
        assertEquals(1, distances[3]);
    }
}
