package de.uni_bremen.pi2;

import java.util.PriorityQueue;

/**
 * Die Klasse bestimmt mit dem Verfahren von Dijkstra für jeden Knoten eines
 * Graphen die Mindestentfernung, in der dieser vom Startknoten aus erreicht
 * werden kann. Es wird nicht nach dem Weg zu einem bestimmten Knoten gesucht.
 */
public class Dijkstra
{
    /**
     * Bestimmt für jeden Knoten die kürzeste Distanz vom Startknoten.
     *
     * @param adjacencyMatrix Die Nachbarschaftsmatrix. Sie ist quadratisch und
     *         nicht null. Ist adjacencyMatrix[i][j] ungleich null, gibt es eine
     *         Kante von Knoten i zu Knoten j. Der Matrixeintrag selbst gibt dann
     *         die Distanz zwischen beiden an. Ist adjacencyMatrix[i][j] null,
     *         gibt es keine Kante.
     * @param start Der Startknoten. Ist auf jeden Fall ein gültiger Index für
     *         adjacencyMatrix.
     * @return Ein Array, das für jeden Knoten die kürzeste Distanz vom
     *         Startknoten enthält. Die Distanzen sind am Index der jeweiligen
     *         Knotennummern eingetragen. Für nicht erreichbare Knoten ist die
     *         Distanz Integer.MAX_VALUE.
     */
    public static int[] shortestDistances(final Integer[][] adjacencyMatrix, final int start)
    {
        // Zu Beginn ist jeder Knoten unendlich weit entfernt ...
        final int[] shortestDistances = new int[adjacencyMatrix.length];
        for (int i = 0; i < shortestDistances.length; ++i) {
            shortestDistances[i] = Integer.MAX_VALUE;
        }

        // ... außer dem Startknoten, der die Distanz 0 hat.
        shortestDistances[start] = 0;

        // Die frontier liefert die Knoten nach aufsteigender bisher bekannter
        // Distanz.
        final PriorityQueue<Integer> frontier = new PriorityQueue<>(
                (a, b) -> shortestDistances[a] - shortestDistances[b]);
        frontier.add(start);

        // Solange es noch Knoten zu bearbeiten gibt, den nächstgelegenen nehmen
        // und seine Nachbarn relaxieren.
        while (!frontier.isEmpty()) {
            final int node = frontier.remove();

            // TODO: Aufgabe 5 (Zeilen 57-64 der Musterlösung)
        }

        return shortestDistances;
    }
}
