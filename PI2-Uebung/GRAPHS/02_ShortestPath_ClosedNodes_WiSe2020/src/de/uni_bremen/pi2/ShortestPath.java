package de.uni_bremen.pi2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Aufgabe 4: ShortestPath (20 %).
 * Wiederholungsklausur WiSe 2019/20 (ältere Dijkstra-Variante mit
 * offenen und geschlossenen Knoten).
 *
 * Es dürfen keine Klassen der Laufzeitbibliothek außer den hier sowieso
 * schon genutzten verwendet werden.
 */
public class ShortestPath
{
    /** Ein offener Knoten: Knotennummer plus Distanz, mit der er erreicht wurde. */
    private static class OpenNode implements Comparable<OpenNode>
    {
        /** Die Knotennummer. */
        final int node;

        /** Die Distanz vom Start, mit der der Knoten erreicht wurde. */
        final int distance;

        /**
         * Konstruktor.
         * @param node Die Knotennummer.
         * @param distance Die Distanz vom Start.
         */
        OpenNode(final int node, final int distance)
        {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(final OpenNode other)
        {
            return Integer.compare(distance, other.distance);
        }
    }

    /**
     * Bestimmt mit dem Verfahren von Dijkstra die kürzeste Distanz vom
     * Startknoten zu allen Knoten des Graphen.
     *
     * Die offenen Knoten liegen nach Distanz sortiert in openNodes. Ein Knoten
     * kann dort mehrfach mit verschiedenen Distanzen liegen. Wird er zum ersten
     * Mal herausgenommen, ist seine Distanz die kürzeste. Er wird dann
     * geschlossen und seine Nachbarn werden geöffnet. Wird er später noch
     * einmal herausgenommen, wird er ignoriert.
     *
     * @param adjacencyMatrix Die Nachbarschaftsmatrix. Ist adjacencyMatrix[i][j]
     *         nicht null, gibt es eine Kante von i nach j mit dieser Länge.
     * @param start Der Startknoten.
     * @return Die kürzesten Distanzen aller Knoten. Nicht erreichbare Knoten
     *         behalten Integer.MAX_VALUE.
     */
    public static int[] shortestDistances(final Integer[][] adjacencyMatrix, final int start)
    {
        final int[] shortestDistances = new int[adjacencyMatrix.length];
        Arrays.fill(shortestDistances, Integer.MAX_VALUE);

        final Set<Integer> closedNodes = new HashSet<>();
        final PriorityQueue<OpenNode> openNodes = new PriorityQueue<>();
        openNodes.add(new OpenNode(start, 0));

        while (!openNodes.isEmpty()) {
            final OpenNode openNode = openNodes.poll();
            final int node = openNode.node;
            final int distance = openNode.distance;

            // TODO: Aufgabe 4 (Musterlösung: 9 Zeilen)
            // Nur wenn node noch nicht geschlossen ist: schließen, Distanz
            // eintragen und alle Nachbarn mit ihrer Gesamtdistanz öffnen.
        }
        return shortestDistances;
    }
}
